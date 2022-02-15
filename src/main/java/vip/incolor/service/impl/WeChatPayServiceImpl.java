package vip.incolor.service.impl;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.dto.OrderItem;
import vip.incolor.dto.ReceiverInfo;
import vip.incolor.entity.*;
import vip.incolor.exception.NotPayException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.*;
import vip.incolor.service.WeChatPayService;
import vip.incolor.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 16:57
 */

@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    private ProductMapper productMapper;
    private OrderMapper orderMapper;
    private OrderExpresswayMapper orderExpresswayMapper;
    private OrderPayMapper orderPayMapper;
    private OrderInformationMapper orderInformationMapper;
    private ShoppingMapper shoppingMapper;
    private MyOrderDetailMapper myOrderDetailMapper;

    private static final Map<Integer, ConsultThread> threadPool = new HashMap<>();
    private static final Map<String, RollBackObject> prepayPool = new HashMap<>();

    private class RollBackObject {
        int orderId;
        List<OrderItem> orderItems;
    }

    private class WxWrapper {
        Order order;
        List<OrderItem> items;
        Map<String, String> resp;
        long expireTime;
    }

    private class ConsultThread extends Thread {
        private final int orderId;
        private final String prepayId;
        private final long expireTime;

        ConsultThread(int orderId, String prepayId, long expireTime) {
            this.orderId = orderId;
            this.prepayId = prepayId;
            this.expireTime = expireTime;
        }

        @Override
        public void run() {
            super.run();
            try {
                long stopTime = expireTime;
                while (true) {
                    if (this.isInterrupted()) {
                        //被外部中断，库存恢复由外部负责
                        synchronized (threadPool) {
                            threadPool.remove(orderId);
                        }
                        throw new InterruptedException();
                    }
                    System.out.println("sleep at:" + System.currentTimeMillis());
                    sleep(30 * 1000); //每隔30秒查询一次
                    long currentTime = System.currentTimeMillis();
                    System.out.println("wake at:" + System.currentTimeMillis());
                    if (currentTime > stopTime) {
                        System.out.println("超时了");
                        //超时的时候要清除缓存池和恢复库存
                        RollBackObject object;
                        synchronized (prepayPool) {
                            object = prepayPool.get(prepayId);
                        }
                        if (object != null) {
                            roolBack(object.orderItems);
                        }
                        synchronized (threadPool) {
                            threadPool.remove(orderId);
                        }
                        synchronized (prepayPool) {
                            prepayPool.remove(prepayId);
                        }
                        break;
                    }
                    Map<String, String> resp = WeChatPayServiceImpl.this.consultOrder(orderId);
                    String status = resp.get("trade_state");
                    if (status.equals("SUCCESS")) {
                        //订单已成功支付，记录支付状态并退出线程
                        Order order = new Order();
                        order.setOrder_id(orderId);
                        order.setOrder_pay_time(new Date());
                        order.setOrder_state(true);
                        order.setOrder_status("已支付");
                        orderMapper.updateByPrimaryKeySelective(order);

                        shoppingMapper.pay(orderId);
                        //清理hashmap对应线程
                        synchronized (threadPool) {
                            threadPool.remove(orderId);
                        }
                        synchronized (prepayPool) {
                            prepayPool.remove(prepayId);
                        }
                        break;  //记得退出线程
                    }
                }
            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Autowired
    public WeChatPayServiceImpl(ProductMapper productMapper,
                                OrderMapper orderMapper,
                                OrderExpresswayMapper orderExpresswayMapper,
                                OrderPayMapper orderPayMapper,
                                OrderInformationMapper orderInformationMapper,
                                ShoppingMapper shoppingMapper,
                                MyOrderDetailMapper myOrderDetailMapper) {
        super();
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
        this.orderExpresswayMapper = orderExpresswayMapper;
        this.orderPayMapper = orderPayMapper;
        this.orderInformationMapper = orderInformationMapper;
        this.shoppingMapper = shoppingMapper;
        this.myOrderDetailMapper = myOrderDetailMapper;
    }

    @Transactional
    @Override
    public byte[] getQRCode(ReceiverInfo info) {
        //每次获取支付二维码之前先下单
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes())
                    .getRequest();
            HttpSession session = request.getSession();
            WxWrapper wxWrapper = order(info, session, request);
            String url = url(wxWrapper, session);
            BitMatrix bitMatrix = QRCodeUtil.generateBitMatrix(url);
            return QRCodeUtil.getQRCodeByteArray(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    public WxWrapper order(ReceiverInfo info, HttpSession session, HttpServletRequest request) {
        try {
            //获取用户
            Map<String, String> resp;
            List<OrderItem> items = info.getProducts();
            Integer userId = (Integer) session.getAttribute("user_id");
            if (userId == null) {
                //TODO:改个异常
                throw new WrongInputException();
            }
            //校验输入
            String phone = info.getPhone();
            if (!(Checker.isChinaMobilePhone(phone) || Checker.isHomePhone(phone))) {
                throw new WrongInputException();
            }
            String postalCode = info.getPostalCode();
            if (!Checker.isPostalCode(postalCode)) {
                throw new WrongInputException();
            }
            //校验支付方式和配送方式是否存在
            int payWay = info.getPayWayId();
            int expressWay = info.getExpressWayId();
            OrderPay orderPay = orderPayMapper.selectByPrimaryKey(payWay);
            OrderExpressway orderExpressway = orderExpresswayMapper.selectByPrimaryKey(expressWay);
            if (orderPay == null || orderExpressway == null) {
                throw new WrongInputException();
            }
            //转义处理
            String name = info.getName();
            String address = info.getAddress();
            name = HtmlUtils.htmlEscape(name);
            address = HtmlUtils.htmlEscape(address);

            //生成总订单
            Order order = new Order();
            order.setOrder_create_times(new Date());
            order.setOrder_receiver(name);
            order.setOrder_phone(phone);
            order.setOrder_address(address);
            order.setOrder_postalcode(Integer.parseInt(postalCode));
            order.setOrder_state(false);
            order.setOrder_status("待支付");
            order.setIs_need_invoices(info.isNeedInvoices());
            order.setInvoices_type(info.isCompanyInvoices());
            order.setUser_id(userId);   //TODO:改了
            orderMapper.insert(order);  //TODO:改了

            OrderInformation orderInformation = new OrderInformation();
            orderInformation.setOrder_id(order.getOrder_id());
            //orderInformation.setProduct_id(productId);
            orderInformation.setUser_id(userId);
            orderInformation.setOrder_pay_id(payWay);
            orderInformation.setOrder_expressway_id(expressWay);
            //orderInformation.setOrder_number(buyNumber);
            orderInformationMapper.insert(orderInformation);

            double totalPrice = 0;
            //对购物车的order生成一个orderId
            List<Integer> shoppingIds = info.getShoppingId();
            for (Integer shoppingId : shoppingIds) {
                Shopping shopping = shoppingMapper.selectByPrimaryKey(shoppingId);
                shopping.setOrder_id(order.getOrder_id());
                shopping.setIs_payed(false);
                totalPrice += shopping.getShopping_price() * shopping.getShopping_number();
                shoppingMapper.updateByPrimaryKey(shopping);
            }

            //检查商品是否存在且余量足够，然后再进行订单子项crud操作

            Product firstProduct = null;

            for (int i = 0; i < items.size(); i++) {
                OrderItem item = items.get(i);
                int productId = item.getProductId();  //主产品id
                int buyNumber = item.getNumber();
                if (buyNumber <= 0) {
                    throw new WrongInputException();
                }
                Product product = productMapper.selectByPrimaryKey(productId);
                if (product == null || product.getProduct_number() < buyNumber) {
                    throw new WrongInputException();
                }
                if (i == 0) {
                    firstProduct = product;
                }

                /*OrderInformation orderInformation=new OrderInformation();
                orderInformation.setOrder_id(order.getOrder_id());
                orderInformation.setProduct_id(productId);
                orderInformation.setUser_id(userId);
                orderInformation.setOrder_pay_id(payWay);
                orderInformation.setOrder_expressway_id(expressWay);
                orderInformation.setOrder_number(buyNumber);
                orderInformationMapper.insert(orderInformation);*/
                //更新商品状态
                product.setProduct_number(product.getProduct_number() - buyNumber);
                productMapper.updateByPrimaryKeySelective(product);

                //totalPrice+=product.getProduct_price()*buyNumber;

                MyOrderDetail myOrderDetail = new MyOrderDetail();
                myOrderDetail.setNumber(buyNumber);
                myOrderDetail.setOrder_id(order.getOrder_id());
                myOrderDetail.setProduct_id(productId);
                myOrderDetailMapper.insert(myOrderDetail);
            }

            String body = firstProduct.getProduct_name();
            if (items.size() > 1) {
                body = body + "等商品";
            }
            String ip = IPUtil.getIp(request);
            //统一下单
            MyWxPayConfig config = new MyWxPayConfig();
            //WXPay wxPay=new WXPay(config, WXPayConstants.SignType.MD5,true);
            WXPay wxPay = new WXPay(config);

            Map<String, String> data = new HashMap<>();
            data.put("body", body);
            data.put("out_trade_no", String.valueOf(order.getOrder_id()));
            data.put("device_info", "WEB");
            data.put("fee_type", "CNY");
            data.put("total_fee", String.valueOf((int) (totalPrice * 100)));
            //沙盒测试
            //data.put("total_fee", String.valueOf(301));
            //data.put("total_fee",String.valueOf(info.getTest()));
            data.put("spbill_create_ip", ip);
            data.put("notify_url", "https://www.incolor.vip/pay/onCallWeChatPay");  //微信支付回调接口url
            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
            data.put("product_id", String.valueOf(firstProduct.getProduct_id()));   //此处为订单中第一项商品id
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            System.out.println("now:" + System.currentTimeMillis());
            long nowLong = System.currentTimeMillis();
            long afterLong = nowLong + 10 * 60 * 1000;
            Date now = new Date(nowLong);
            Date after = new Date(afterLong);
            String afterStr = simpleDateFormat.format(after);
            String nowStr = simpleDateFormat.format(now);
            data.put("time_expire", afterStr);
            data.put("time_start", nowStr);
            /*data.put("time_start",)
            data.put("time_expired",)*/
            //沙箱测试用
            /*String nonceStr=WXPayUtil.generateNonceStr();
            String mchId="1490191822";
            Map<String,String> sandBox=new HashMap<>();
            sandBox.put("mch_id",mchId);
            sandBox.put("nonce_str",nonceStr);
            Set<String> keySet = sandBox.keySet();
            String[] keyArray = (String[])keySet.toArray(new String[keySet.size()]);
            Arrays.sort(keyArray);
            StringBuilder sb = new StringBuilder();
            String[] var6 = keyArray;
            int var7 = keyArray.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                String k = var6[var8];
                if (!k.equals("sign") && ((String)sandBox.get(k)).trim().length() > 0) {
                    sb.append(k).append("=").append(((String)sandBox.get(k)).trim()).append("&");
                }
            }
            sb.append("key=");
            sb.append(config.getKey());
            sandBox.put("sign",WXPayUtil.MD5(sb.toString()).toUpperCase());
            String respXml=this.requestWithoutCert("https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey",sandBox,8000,10000);
            Map<String,String> respMap=WXPayUtil.xmlToMap(respXml);
            String sandboxKey=respMap.get("sandbox_signkey");
            config.setKey(sandboxKey);*/

            //沙箱测试用
            //Map<String, String> resp =this.unifiedOrder(data,8000,10000,wxPay,sandboxKey);
            resp = wxPay.unifiedOrder(data);
            //处理回传信息
            /*String returnCode=resp.get("return_code");*/
            /*if(returnCode.equals("SUCCESS")){
                String resultCode=resp.get("result_code");
                if(resultCode.equals("SUCCESS")){
                    String prePayId=resp.get("prepay_id");
                    String codeUrl=resp.get("code_url");
                    RollBackObject rollBackObject=new RollBackObject();
                    rollBackObject.orderId=order.getOrder_id();
                    rollBackObject.orderItems=items;
                    synchronized (prepayPool) {
                        prepayPool.put(prePayId,rollBackObject);
                    }

                    //后台启动线程每隔一段时间查询支付状态
                    ConsultThread consultThread=new ConsultThread(order.getOrder_id(),prePayId);
                    synchronized (threadPool) {
                        threadPool.put(order.getOrder_id(),consultThread);
                    }

                    //供前端查询使用
                    session.setAttribute("wxpay_loop_consult",order.getOrder_id());

                    return codeUrl;
                }
            }*/
            WxWrapper wxWrapper = new WxWrapper();
            wxWrapper.order = order;
            wxWrapper.items = items;
            wxWrapper.resp = resp;
            wxWrapper.expireTime = afterLong;
            return wxWrapper;
            //throw new ServerInternalException();
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException(e.getMessage());
        }
        /*String returnCode=resp.get("return_code");
        if(returnCode.equals("SUCCESS")){
            String resultCode=resp.get("result_code");
            if(resultCode.equals("SUCCESS")){
                String prePayId=resp.get("prepay_id");
                String codeUrl=resp.get("code_url");
                RollBackObject rollBackObject=new RollBackObject();
                rollBackObject.orderId=order.getOrder_id();
                rollBackObject.orderItems=items;
                synchronized (prepayPool) {
                    prepayPool.put(prePayId,rollBackObject);
                }
                //后台启动线程每隔一段时间查询支付状态
                ConsultThread consultThread=new ConsultThread(order.getOrder_id(),prePayId);
                synchronized (threadPool) {
                    threadPool.put(order.getOrder_id(),consultThread);
                }
                //供前端查询使用
                session.setAttribute("wxpay_loop_consult",order.getOrder_id());
                return codeUrl;
            }
        }*/
    }

    @Override
    public void onNotify(String notifyXml) {
        System.out.println(notifyXml);
        //接受微信服务器调用
        //取出orderId
        //若支付成功，往下做
        //若支付失败，恢复商品数量
        //修改订单支付状态
        Map<String, String> resp = null;
        try {
            MyWxPayConfig config = new MyWxPayConfig();
            WXPay wxPay = new WXPay(config);
            resp = wxPay.processResponseXml(notifyXml);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
        String resultCode = resp.get("result_code");
        String prepayId = resp.get("prepay_id");
        RollBackObject rollBackObject;
        synchronized (prepayPool) {
            rollBackObject = prepayPool.get(prepayId);
        }
        if (rollBackObject == null) {
            return; //已经在查询线程中被处理了
        }
        Integer orderId = rollBackObject.orderId;
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (resultCode.equals("SUCCESS")) {
            order.setOrder_status("已支付");
            order.setOrder_state(true);
            order.setOrder_pay_time(new Date());
            //更新购物车项为已购买
            /*ShoppingExample example=new ShoppingExample();
            example.createCriteria().andOrder_idEqualTo(orderId);
            List<Shopping> shoppings=shoppingMapper.selectByExample(example);
            for(Shopping shopping:shoppings){
                shopping.setIs_payed(true);
                shoppingMapper.updateByPrimaryKey(shopping);
            }*/
            orderMapper.updateByPrimaryKeySelective(order);
            shoppingMapper.pay(orderId);
        } else {
            List<OrderItem> items = rollBackObject.orderItems;
            roolBack(items);
        }
        //清空缓存，中断线程
        ConsultThread consultThread;
        synchronized (threadPool) {
            consultThread = threadPool.get(orderId);
            threadPool.remove(orderId);
        }
        if (consultThread != null) {
            consultThread.interrupt();
        }
        synchronized (prepayPool) {
            prepayPool.remove(prepayId);
        }
    }

    @Override
    public void consultPayStatus(HttpSession session) {
        //前端查询支付状态
        Integer orderId = (Integer) session.getAttribute("wxpay_loop_consult");
        if (orderId != null) {
            //查询数据库订单支付状态
            Order order = orderMapper.selectByPrimaryKey(orderId);
            if (order == null) {
                //订单不存在
                //TODO:换个异常
                throw new ServerInternalException();
            }
            boolean state = order.getOrder_state();
            if (!state) {
                //未支付抛出未支付异常
                throw new NotPayException();
            }
            //已支付什么都不做，由Controller完成操作
        } else {
            //未成功发起支付
            //TODO:换个异常
            throw new ServerInternalException();
        }

    }

    private Map<String, String> consultOrder(int orderId) throws IOException {
        MyWxPayConfig config = new MyWxPayConfig();
        //WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5, true);
        WXPay wxpay=new WXPay(config);
        Map<String, String> data = new HashMap<>();
        data.put("out_trade_no", String.valueOf(orderId));

        try {
            return wxpay.orderQuery(data);
        } catch (Exception e) {
            throw new ServerInternalException();
        }
    }

    private void roolBack(List<OrderItem> items) {
        for (int i = 0; i < items.size(); i++) {
            int number = items.get(i).getNumber();
            int productId = items.get(i).getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            product.setProduct_number(product.getProduct_number() + number);
            productMapper.updateByPrimaryKeySelective(product);
        }
    }

    private String url(WxWrapper wxWrapper, HttpSession session) {
        Map<String, String> resp = wxWrapper.resp;
        Order order = wxWrapper.order;
        List<OrderItem> items = wxWrapper.items;
        long expireTime = wxWrapper.expireTime;
        String returnCode = resp.get("return_code");
        if (returnCode.equals("SUCCESS")) {
            String resultCode = resp.get("result_code");
            if (resultCode.equals("SUCCESS")) {
                String prePayId = resp.get("prepay_id");
                String codeUrl = resp.get("code_url");
                RollBackObject rollBackObject = new RollBackObject();
                rollBackObject.orderId = order.getOrder_id();
                rollBackObject.orderItems = items;
                synchronized (prepayPool) {
                    prepayPool.put(prePayId, rollBackObject);
                }
                //后台启动线程每隔一段时间查询支付状态
                ConsultThread consultThread = new ConsultThread(order.getOrder_id(), prePayId, expireTime);
                consultThread.start();
                synchronized (threadPool) {
                    threadPool.put(order.getOrder_id(), consultThread);
                }
                //供前端查询使用
                session.setAttribute("wxpay_loop_consult", order.getOrder_id());
                return codeUrl;
            }
        }
        throw new ServerInternalException();
    }
}
