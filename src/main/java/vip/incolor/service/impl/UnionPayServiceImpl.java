//package vip.incolor.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.util.HtmlUtils;
//import vip.incolor.dto.OrderItem;
//import vip.incolor.dto.ReceiverInfo;
//import vip.incolor.entity.*;
//import vip.incolor.exception.NotPayException;
//import vip.incolor.exception.ServerInternalException;
//import vip.incolor.exception.WrongInputException;
//import vip.incolor.mapper.*;
//import vip.incolor.service.UnionPayService;
//import vip.incolor.utils.Checker;
//import vip.incolor.utils.unionpay.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.UnsupportedEncodingException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * @author LiYizhan
// * @email 1062585732@qq.com
// * @description
// * @date 2018/6/1
// * @time 19:49
// */
//@Service
//public class UnionPayServiceImpl implements UnionPayService {
//
//    private ProductMapper productMapper;
//    private OrderMapper orderMapper;
//    private OrderExpresswayMapper orderExpresswayMapper;
//    private OrderPayMapper orderPayMapper;
//    private OrderInformationMapper orderInformationMapper;
//    private ShoppingMapper shoppingMapper;
//    private MyOrderDetailMapper myOrderDetailMapper;
//
//    @Autowired
//    public UnionPayServiceImpl(ProductMapper productMapper,
//                             OrderMapper orderMapper,
//                             OrderExpresswayMapper orderExpresswayMapper,
//                             OrderPayMapper orderPayMapper,
//                             OrderInformationMapper orderInformationMapper,
//                             ShoppingMapper shoppingMapper,
//                             MyOrderDetailMapper myOrderDetailMapper) {
//        super();
//        this.productMapper=productMapper;
//        this.orderMapper=orderMapper;
//        this.orderExpresswayMapper=orderExpresswayMapper;
//        this.orderPayMapper=orderPayMapper;
//        this.orderInformationMapper=orderInformationMapper;
//        this.shoppingMapper=shoppingMapper;
//        this.myOrderDetailMapper=myOrderDetailMapper;
//    }
//
//    @Override
//    @Transactional
//    public String order(ReceiverInfo info, HttpServletResponse response) {
//        try {
//            //获取用户
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                    .getRequestAttributes())
//                    .getRequest();
//            HttpSession session=request.getSession();
//            Integer userId=(Integer)session.getAttribute("user_id");
//            if(userId==null){
//                //TODO:改个异常
//                throw new WrongInputException();
//            }
//            //校验输入
//            String phone=info.getPhone();
//            if(!(Checker.isChinaMobilePhone(phone)||Checker.isHomePhone(phone))){
//                throw new WrongInputException();
//            }
//            String postalCode=info.getPostalCode();
//            if(!Checker.isPostalCode(postalCode)){
//                throw new WrongInputException();
//            }
//            //校验支付方式和配送方式是否存在
//            int payWay=info.getPayWayId();
//            int expressWay=info.getExpressWayId();
//            OrderPay orderPay=orderPayMapper.selectByPrimaryKey(payWay);
//            OrderExpressway orderExpressway=orderExpresswayMapper.selectByPrimaryKey(expressWay);
//            if(orderPay==null||orderExpressway==null){
//                throw new WrongInputException();
//            }
//            //转义处理
//            String name=info.getName();
//            String address=info.getAddress();
//            name= HtmlUtils.htmlEscape(name);
//            address=HtmlUtils.htmlEscape(address);
//            //生成总订单
//            Order order=new Order();
//            order.setOrder_create_times(new Date());
//            order.setOrder_receiver(name);
//            order.setOrder_phone(phone);
//            order.setOrder_address(address);
//            order.setOrder_postalcode(Integer.parseInt(postalCode));
//            order.setOrder_state(false);
//            order.setOrder_status("待支付");
//            order.setIs_need_invoices(info.isNeedInvoices());
//            order.setInvoices_type(info.isCompanyInvoices());
//            order.setUser_id(userId);   //TODO:改了
//            orderMapper.insert(order);  //TODO:改了
//
//            OrderInformation orderInformation=new OrderInformation();
//            orderInformation.setOrder_id(order.getOrder_id());
//            //orderInformation.setProduct_id(productId);
//            orderInformation.setUser_id(userId);
//            orderInformation.setOrder_pay_id(payWay);
//            orderInformation.setOrder_expressway_id(expressWay);
//            //orderInformation.setOrder_number(buyNumber);
//            orderInformationMapper.insert(orderInformation);
//
//            double totalPrice=0;
//            //对购物车的order生成一个orderId
//            List<Integer> shoppingIds=info.getShoppingId();
//            for(Integer shoppingId:shoppingIds){
//                Shopping shopping=shoppingMapper.selectByPrimaryKey(shoppingId);
//                shopping.setOrder_id(order.getOrder_id());
//                shopping.setIs_payed(false);
//                totalPrice+=shopping.getShopping_price()*shopping.getShopping_number();
//                shoppingMapper.updateByPrimaryKey(shopping);
//            }
//            //检查商品是否存在且余量足够，然后再进行订单子项crud操作
//
//            Product firstProduct=null;
//            List<OrderItem> items=info.getProducts();
//            for(int i=0;i<items.size();i++){
//                OrderItem item=items.get(i);
//                int productId=item.getProductId();
//                int buyNumber=item.getNumber();
//                if(buyNumber<=0){
//                    throw new WrongInputException();
//                }
//                Product product=productMapper.selectByPrimaryKey(productId);
//                if(product==null||product.getProduct_number()<buyNumber){
//                    throw new WrongInputException();
//                }
//                if(i==0){
//                    firstProduct=product;
//                }
//
//                    /*OrderInformation orderInformation=new OrderInformation();
//                    orderInformation.setOrder_id(order.getOrder_id());
//                    orderInformation.setProduct_id(productId);
//                    orderInformation.setUser_id(userId);
//                    orderInformation.setOrder_pay_id(payWay);
//                    orderInformation.setOrder_expressway_id(expressWay);
//                    orderInformation.setOrder_number(buyNumber);
//                    orderInformationMapper.insert(orderInformation);*/
//
//                //更新商品状态
//                product.setProduct_number(product.getProduct_number()-buyNumber);
//                productMapper.updateByPrimaryKeySelective(product);
//                //totalPrice+=product.getProduct_price()*buyNumber;
//
//                MyOrderDetail myOrderDetail=new MyOrderDetail();
//                myOrderDetail.setNumber(buyNumber);
//                myOrderDetail.setOrder_id(order.getOrder_id());
//                myOrderDetail.setProduct_id(productId);
//                myOrderDetailMapper.insert(myOrderDetail);
//            }
//
//            String body=firstProduct.getProduct_name();
//            if(items.size()>1){
//                body=body+"等商品";
//            }
//
//            response.setContentType("text/html; charset=UTF-8");
//            String merId = "";      //TODO:商户号
//            //String txnAmt = req.getParameter("txnAmt");
//            String txnAmt = String.valueOf((int)(totalPrice*100));
//
//            Map<String, String> requestData = new HashMap<String, String>();
//
///***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
//
//            requestData.put("version", DemoBase.version);     //版本号，全渠道默认值
//
//            requestData.put("encoding", DemoBase.encoding);   //字符集编码，可以使用UTF-8,GBK两种方式
//
//            requestData.put("signMethod", SDKConfig.getConfig().getSignMethod()); //签名方法
//
//            requestData.put("txnType", "01");                 //交易类型 ，01：消费
//
//            requestData.put("txnSubType", "01");              //交易子类型， 01：自助消费
//
//            requestData.put("bizType", "000201");             //业务类型，B2C网关支付，手机wap支付
//
//            requestData.put("channelType", "07");             //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机
//
///***商户接入参数***/
//
//            requestData.put("merId", merId);                //商户号码，请改成自己申请的正式商户号或者open上注册得来的777测试商户号
//
//            requestData.put("accessType", "0");               //接入类型，0：直连商户
//
//            requestData.put("orderId",String.valueOf(order.getOrder_id()));             //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
//
//            requestData.put("txnTime", DemoBase.getCurrentTime());        //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
//
//            requestData.put("currencyCode", "156");           //交易币种（境内商户一般是156 人民币）
//
//            requestData.put("txnAmt", txnAmt);                   //交易金额，单位分，不要带小数点
//
////requestData.put("reqReserved", "透传字段");              //请求方保留域，如需使用请启用即可；透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节。出现&={}[]符号时可能导致查询接口应答报文解析失败，建议尽量只传字母数字并使用|分割，或者可以最外层做一次base64编码(base64编码之后出现的等号不会导致解析失败可以不用管)。
//
////前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
//
////如果想要实现过几秒中自动跳转回商户页面权限，需联系银联业务申请开通自动返回商户权限
//
////异步通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
//
////        requestData.put("frontUrl", DemoBase.frontUrl);
//
////后台通知地址（需设置为【外网】能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
//
////后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
//
////注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码
//
////    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
//
////    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
//
//            requestData.put("backUrl", DemoBase.backUrl);
//
//// 订单超时时间。
//
//// 超过此时间后，除网银交易外，其他交易银联系统会拒绝受理，提示超时。 跳转银行网银交易如果超时后交易成功，会自动退款，大约5个工作日金额返还到持卡人账户。
//
//// 此时间建议取支付时的北京时间加15分钟。
//
//// 超过超时时间调查询接口应答origRespCode不是A6或者00的就可以判断为失败。
//
//            requestData.put("payTimeout", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime() + 15 * 60 * 1000));
//
//
////////////////////////////////////////////////////
//
////
//
////       报文中特殊用法请查看 PCwap网关跳转支付特殊用法.txt
//
////
//
////////////////////////////////////////////////////
//
//
///**请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面**/
//
//            Map<String, String> submitFromData = AcpService.sign(requestData,DemoBase.encoding);  //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
//
//
//            String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();  //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
//
//            String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData,DemoBase.encoding);   //生成自动跳转的Html表单
//
//
//            LogUtil.writeLog("打印请求HTML，此为请求报文，为联调排查问题的依据："+html);
//
////将生成的html写到浏览器中完成自动跳转打开银联支付页面；这里调用signData之后，将html写到浏览器跳转到银联页面之前均不能对html中的表单项的名称和值进行修改，如果修改会导致验签不通过
//
//            //resp.getWriter().write(html);
//            session.setAttribute("alipay_loop_consult",order.getOrder_id());
//
//            return html;
//        }catch (Exception e){
//            throw new ServerInternalException(e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public void notifyUrl(Map<String, String> resp,String encoding) {
//        try {
//            LogUtil.writeLog("BackRcvResponse接收后台通知开始");
//
//            //String encoding = req.getParameter(SDKConstants.param_encoding);
//            LogUtil.printRequestLog(resp);
//            Map<String, String> valideData = null;
//            if (null != resp && !resp.isEmpty()) {
//                Iterator<Map.Entry<String, String>> it = resp.entrySet().iterator();
//                valideData = new HashMap<String, String>(resp.size());
//                while (it.hasNext()) {
//                    Map.Entry<String, String> e = it.next();
//                    String key = (String) e.getKey();
//                    String value = (String) e.getValue();
//                    try {
//                        value = new String(value.getBytes(encoding), encoding);
//                    } catch (UnsupportedEncodingException e1) {
//                        e1.printStackTrace();
//                        //返回其他http状态码
//                    }
//                    valideData.put(key, value);
//                }
//            }
//
////重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
//            if (!AcpService.validate(valideData, encoding)) {
//                LogUtil.writeLog("验证签名结果[失败].");
//    //验签失败，需解决验签问题
//            } else {
//                LogUtil.writeLog("验证签名结果[成功].");
//    //【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态
//                int orderId =Integer.parseInt(valideData.get("orderId")); //获取后台通知的数据，其他字段也可用类似方式获取
//                String respCode = valideData.get("respCode");
//    //判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。
//                if(respCode.equals("00")||respCode.equals("A6")){
//                    Order order=orderMapper.selectByPrimaryKey(orderId);
//                    if(order.getOrder_state()){
//                        return;
//                    }
//                    order.setOrder_status("已支付");
//                    order.setOrder_state(true);
//                    order.setOrder_pay_time(new Date());
//                    //更新购物车项为已购买
//                    shoppingMapper.pay(orderId);
//                    /*ShoppingExample example=new ShoppingExample();
//                    example.createCriteria().andOrder_idEqualTo(orderId);
//                    List<Shopping> shoppings=shoppingMapper.selectByExample(example);
//                    for(Shopping shopping:shoppings){
//                        shopping.setIs_payed(true);
//                        shoppingMapper.updateByPrimaryKey(shopping);
//                    }*/
//                    orderMapper.updateByPrimaryKeySelective(order);
//                }else{
//                    rollBack(orderId);
//                }
//            }
//            LogUtil.writeLog("BackRcvResponse接收后台通知结束");
////返回给银联服务器http 200  状态码
//        } catch (Exception e) {
//            throw new ServerInternalException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void consultPayStatus(HttpSession session) {
//        //前端查询支付状态
//        Integer orderId=(Integer)session.getAttribute("unionpay_loop_consult");
//        if(orderId!=null){
//            //查询数据库订单支付状态
//            Order order=orderMapper.selectByPrimaryKey(orderId);
//            if(order==null){
//                //订单不存在
//                //TODO:换个异常
//                throw new ServerInternalException();
//            }
//            boolean state=order.getOrder_state();
//            if(!state){
//                //未支付抛出未支付异常
//                throw new NotPayException();
//            }
//            //已支付什么都不做，由Controller完成操作
//        }else{
//            //未成功发起支付
//            //TODO:换个异常
//            throw new ServerInternalException();
//        }
//    }
//
//    private void rollBack(int orderId){
//        OrderInformationExample example=new OrderInformationExample();
//        example.createCriteria().andOrder_idEqualTo(orderId);
//        List<OrderInformation> information=orderInformationMapper.selectByExample(example);
//        for(int i=0;i<information.size();i++){
//            int productId=information.get(i).getProduct_id();
//            int number=information.get(i).getOrder_number();
//            Product product=productMapper.selectByPrimaryKey(productId);
//            product.setProduct_number(product.getProduct_number()+number);
//            productMapper.updateByPrimaryKeySelective(product);
//        }
//    }
//}
