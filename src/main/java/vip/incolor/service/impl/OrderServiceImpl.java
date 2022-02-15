package vip.incolor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.constant.Constants;
import vip.incolor.dto.*;
import vip.incolor.dto.Property;
import vip.incolor.entity.*;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.*;
import vip.incolor.service.OrderService;
import vip.incolor.utils.UUIDUtil;
import vip.incolor.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 21:42
 */

//
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !


@Service
public class OrderServiceImpl implements OrderService {
    private InvoicesMapper invoicesMapper;
    private OrderMapper orderMapper;
    private OrderInformationMapper orderInformationMapper;
    private ProductMapper productMapper;
    private ProductPictureMapper productPictureMapper;
    private ShoppingPropertyValueMapper shoppingPropertyValueMapper;
    private MyOrderDetailMapper myOrderDetailMapper;
    private ShoppingMapper shoppingMapper;
    private UserMapper userMapper;
    private ShoppingDetailMapper shoppingDetailMapper;
    @Resource
    private ProductStyleMapper productStyleMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper,
                            OrderInformationMapper orderInformationMapper,
                            ProductMapper productMapper,
                            ProductPictureMapper productPictureMapper,
                            ShoppingPropertyValueMapper shoppingPropertyValueMapper,
                            MyOrderDetailMapper myOrderDetailMapper,
                            ShoppingMapper shoppingMapper,
                            UserMapper userMapper,
                            ShoppingDetailMapper shoppingDetailMapper,
                            InvoicesMapper invoicesMapper) {
        super();
        this.orderInformationMapper = orderInformationMapper;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.productPictureMapper = productPictureMapper;
        this.shoppingPropertyValueMapper = shoppingPropertyValueMapper;
        this.myOrderDetailMapper = myOrderDetailMapper;
        this.shoppingMapper = shoppingMapper;
        this.userMapper = userMapper;
        this.shoppingDetailMapper=shoppingDetailMapper;
        this.invoicesMapper = invoicesMapper;
    }

    @Override
    public List<FrontOrder> getMyOrder(HttpSession session, Boolean isPayed) {
        int userId = (Integer) session.getAttribute("user_id");
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUser_idEqualTo(userId);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        List<FrontOrder> frontOrders = new ArrayList<>();
        if (!orders.isEmpty()) {
            for (Order order : orders) {
                String imgPath;
                String productName;
                double price;
                int number;
                int orderId = order.getOrder_id();
                String status = order.getOrder_status();
                String detail;
                int type = 0;
                OrderInformationExample orderInformationExample = new OrderInformationExample();
                orderInformationExample.createCriteria().andOrder_idEqualTo(orderId);
                orderInformationExample.setOrderByClause("");
                List<OrderInformation> orderInformations = orderInformationMapper.selectByExample(orderInformationExample);
                if (!orderInformations.isEmpty()) {
                    OrderInformation orderInformation = orderInformations.get(0);
                    int productId = orderInformation.getProduct_id();
                    number = orderInformation.getOrder_number();
                    Product product = productMapper.selectByPrimaryKey(productId);
                    if (product != null) {
                        if (product.getProduct_attach_id() != 0) {  //说明是自行车
                            type = 1;
                        }
                        double singlePrice = product.getProduct_price();
                        price = singlePrice * number;
                        int productPicId = product.getProduct_picture_id();
                        ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(productPicId);
                        productName = product.getProduct_name();
                        if (orderInformations.size() > 1) {
                            productName = productName + "等";
                        }
                        if (productPicture != null) {
                            imgPath = productPicture.getProduct_picture_path();
                        } else {
                            throw new WrongInputException();
                        }
                    } else {
                        throw new WrongInputException();
                    }
                } else {
                    throw new WrongInputException();
                }
                //参数显示
                List<ShoppingPropertyValue> shoppingPropertyValues = shoppingPropertyValueMapper.getOrderParams(orderId);
                StringBuilder sb = new StringBuilder();
                for (ShoppingPropertyValue shoppingPropertyValue : shoppingPropertyValues) {
                    sb.append(shoppingPropertyValue.getShopping_property_value());
                    sb.append(" ");
                }
                detail = sb.toString();
                FrontOrder frontOrder = new FrontOrder();
                frontOrder.setStatus(status);
                frontOrder.setType(type);
                frontOrder.setProductName(productName);
                frontOrder.setDetail(detail);
                frontOrder.setImgPath(imgPath);
                frontOrder.setNumber(number);
                frontOrder.setPrice(price);
                frontOrders.add(frontOrder);
            }
        }
        return frontOrders;
    }

    @Override
    public List<FrontOrder> getMyHistoryOrder(HttpSession session) {
        List<FrontOrder> frontOrders = new ArrayList<>();
        int userId = (Integer) session.getAttribute("user_id");
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUser_idEqualTo(userId);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        String validator = UUIDUtil.getUUID();
        if (!orders.isEmpty()) {
            for (Order order : orders) {
                if (!order.getOrder_state()) {
                    continue;
                }
                List<AttachInfo> attachInfos = new ArrayList<>();
                int orderId = order.getOrder_id();
                String status = order.getOrder_status();  //
                int type = 0;     //
                String productName = "";    //
                String detail;      //
                String imgPath = ""; //
                int number = 0;  //这里指orderDetail的number
                double price = 0;
                List<ShoppingPropertyValue> spvs = shoppingPropertyValueMapper.getOrderParams(orderId);
                StringBuilder sb = new StringBuilder();
                for (ShoppingPropertyValue spv : spvs) {
                    sb.append(spv.getShopping_property_value());
                    sb.append(" ");
                }
                detail = sb.toString();
                /*OrderInformationExample orderInformationExample=new OrderInformationExample();
                orderInformationExample.createCriteria().andOrder_idEqualTo(orderId);
                List<OrderInformation> orderInformations=orderInformationMapper.selectByExample(orderInformationExample);
                if(!orderInformations.isEmpty()){
                    //number=orderInformations.get(0).getOrder_number();
                }else {
                    throw new WrongInputException();
                }*/

                MyOrderDetailExample myOrderDetailExample = new MyOrderDetailExample();
                myOrderDetailExample.createCriteria().andOrder_idEqualTo(orderId);
                List<MyOrderDetail> myOrderDetails = myOrderDetailMapper.selectByExample(myOrderDetailExample);
                if (!myOrderDetails.isEmpty()) {
                    for (MyOrderDetail myOrderDetail : myOrderDetails) {
                        int productId = myOrderDetail.getProduct_id();
                        Product product = productMapper.selectByPrimaryKey(productId);
                        if (product != null) {
                            int singleNumber = myOrderDetail.getNumber(); //从detail获取每个商品的数量
                            Double singlePrice = product.getProduct_price();
                            price += (singlePrice * singleNumber);//每个商品的数量与singlePrice相乘求出单个number的价格
                            if (product.getProduct_attach_id() == 0) {
                                type = 1;
                                productName = product.getProduct_name();
                                int productPicId = product.getProduct_picture_id();
                                ProductPictureExample productPictureExample = new ProductPictureExample();
                                productPictureExample.createCriteria().andProduct_picture_idEqualTo(productPicId);
                                List<ProductPicture> productPictures = productPictureMapper.selectByExample(productPictureExample);
                                number = singleNumber;
                                if (!productPictures.isEmpty()) {
                                    imgPath = productPictures.get(0).getProduct_picture_path();
                                } else {
                                    throw new WrongInputException();
                                }
                            } else if (product.getProduct_attach_id() == -1) {
                                //普通商品
                                type = 2;
                                productName = product.getProduct_name();
                                int productPicId = product.getProduct_picture_id();
                                ProductPictureExample productPictureExample = new ProductPictureExample();
                                productPictureExample.createCriteria().andProduct_picture_idEqualTo(productPicId);
                                List<ProductPicture> productPictures = productPictureMapper.selectByExample(productPictureExample);
                                number = singleNumber;
                                if (!productPictures.isEmpty()) {
                                    imgPath = productPictures.get(0).getProduct_picture_path();
                                } else {
                                    throw new WrongInputException();
                                }
                            } else {
                                //自行车配件Go here
                                List<ShoppingPropertyValue> shoppingPropertyValues = shoppingPropertyValueMapper.getAttachValue(productId);
                                StringBuilder sb1 = new StringBuilder();
                                for (ShoppingPropertyValue spv : shoppingPropertyValues) {
                                    sb1.append(spv.getShopping_property_value());
                                }
                                String spv = sb1.toString();
                                AttachInfo attachInfo = new AttachInfo();
                                attachInfo.setNumber(singleNumber);
                                attachInfo.setPrice(singlePrice * singleNumber);
                                attachInfo.setType(product.getProduct_classify_id());
                                attachInfo.setParams(spv);
                                attachInfos.add(attachInfo);
                            }
                            //products.add(product);
                        } else {
                            throw new WrongInputException();
                        }
                    }

                    FrontOrder frontOrder = new FrontOrder();
                    frontOrder.setStatus(status);
                    frontOrder.setType(type);
                    frontOrder.setProductName(productName);
                    frontOrder.setDetail(detail);
                    frontOrder.setImgPath(imgPath);
                    frontOrder.setNumber(number);
                    frontOrder.setPrice(price);
                    frontOrder.setV(validator);
                    frontOrder.setAttachInfos(attachInfos);
                    frontOrders.add(frontOrder);
                    frontOrder.setOrderId(orderId);
                } else {
                    throw new WrongInputException();
                }
            }
            session.setAttribute("shopping_cart_validator", validator);
        }
        return frontOrders;
    }

    @Override
    public List<FrontOrder> getMyShoppingCart(HttpSession session) {
        int userId = (Integer) session.getAttribute("user_id");
        List<FrontOrder> frontOrders = new ArrayList<>();

        List<ProductAndShopping> productAndShoppings = productMapper.getMyShoppingCartProducts(userId);
        if (!productAndShoppings.isEmpty()) {
            Map<Integer, List<ProductAndShopping>> mainProductMap = new HashMap<>();
            Map<Integer, ProductAndShopping> productMap = new HashMap<>();
            for (ProductAndShopping productAndShopping : productAndShoppings) {
                int attachId = productAndShopping.getProduct_attach_id();
                if (attachId == 0 || attachId == -1) {    //不是配件，加入主产品map
                    mainProductMap.put(productAndShopping.getProduct_id(), new ArrayList<>());
                    productMap.put(productAndShopping.getProduct_id(), productAndShopping);
                }
                //第一次扫描确定主产品都加入了map
            }
            //第二次扫描将配件加入主产品
            for (ProductAndShopping productAndShopping : productAndShoppings) {
                int attachId = productAndShopping.getProduct_attach_id();
                if (attachId != 0 && attachId != -1) {
                    List<ProductAndShopping> list = mainProductMap.get(attachId);
                    list.add(productAndShopping);
                }
            }
            String uuid = UUIDUtil.getUUID();
            //提取主产品信息
            for (Integer productId : mainProductMap.keySet()) {
                List<Integer> shoppingIds = new ArrayList<>();
                List<Integer> productIds = new ArrayList<>();
                ProductAndShopping product = productMap.get(productId);
                productIds.add(productId);
                shoppingIds.add(product.getShopping_id());
                ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
                String imgPath = productPicture.getProduct_picture_path();
                String name = product.getProduct_name();
                int number = product.getShooping_number();
                int singlePrice = product.getShopping_price();
                String detail = "";
                List<AttachInfo> attachInfos = new ArrayList<>();
                int type = 0;
                if (product.getProduct_attach_id() == -1) {
                    type = 2;
                }

                //获取配件信息
                List<ProductAndShopping> pas = mainProductMap.get(productId);
                if (!pas.isEmpty()) {
                    type = 1;
                    List<ShoppingPropertyValue> spvs = shoppingPropertyValueMapper.getShoppingParams(product.getShopping_id());
                    StringBuilder sb = new StringBuilder();
                    for (ShoppingPropertyValue spv : spvs) {
                        sb.append(spv.getShopping_property_value());
                        sb.append(" ");
                    }
                    detail = sb.toString();
                    for (ProductAndShopping p : pas) {
                        List<ShoppingPropertyValue> shoppingPropertyValues = shoppingPropertyValueMapper.getAttachValue(p.getProduct_id());
                        productIds.add(p.getProduct_id());
                        shoppingIds.add(p.getShopping_id());
                        StringBuilder sb1 = new StringBuilder();
                        for (ShoppingPropertyValue spv : shoppingPropertyValues) {
                            sb1.append(spv.getShopping_property_value());
                        }
                        String spv = sb1.toString();
                        AttachInfo attachInfo = new AttachInfo();
                        attachInfo.setNumber(p.getShooping_number());
                        attachInfo.setPrice(singlePrice * p.getShooping_number());
                        attachInfo.setType(product.getProduct_classify_id());
                        attachInfo.setParams(spv);
                        attachInfos.add(attachInfo);
                    }
                }


                FrontOrder frontOrder = new FrontOrder();
                //frontOrder.setStatus(status);
                frontOrder.setType(type);
                //frontOrder.setShoppingId(product.getShopping_id());
                frontOrder.setProductName(name);
                frontOrder.setDetail(detail);
                frontOrder.setImgPath(imgPath);
                frontOrder.setNumber(number);
                frontOrder.setPrice(singlePrice);
                frontOrder.setAttachInfos(attachInfos);
                frontOrder.setShoppingIds(shoppingIds);
                frontOrder.setProductIds(productIds);
                frontOrder.setV(uuid);
                frontOrders.add(frontOrder);
            }
            session.setAttribute("shopping_cart_validator", uuid);
            return frontOrders;
        } else {
            throw new WrongInputException();
        }



        /*ShoppingExample shoppingExample=new ShoppingExample();
        shoppingExample.createCriteria().andUser_idEqualTo(userId).andIs_payedEqualTo(false);
        List<Shopping> shoppings=shoppingMapper.selectByExample(shoppingExample);
        if(!shoppings.isEmpty()){
            for(Shopping shopping:shoppings){
                int productId=shopping.getProduct_id();
                int number=shopping.getShooping_number();   //车架数量
                int singlePrice=shopping.getShopping_price();   //车架价格
                Product product=productMapper.selectByPrimaryKey(productId);
                if (product == null) {
                    continue;
                }
                ProductPicture productPicture=productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
                if(productPicture==null){
                    continue;
                }
                String imgPath=productPicture.getProduct_picture_path();
                String name=product.getProduct_name();
                List<ShoppingPropertyValue> spvs=shoppingPropertyValueMapper.getShoppingParams(shopping.getShopping_id());
                StringBuilder sb=new StringBuilder();
                for(ShoppingPropertyValue spv:spvs){
                    sb.append(spv.getShopping_property_value());
                    sb.append(" ");
                }
                String detail=sb.toString();
            }
        }else{
            return frontOrders;
        }*/
    }

    /*private Product copy(ProductAndShopping productAndShopping){
        Product product=new Product();
        productAndShopping.setProduct_id(product.getProduct_id());
        productAndShopping.setProduct_attach_id(product.getProduct_attach_id());
        productAndShopping.setProduct_class_id(product.getProduct_class_id());
        productAndShopping.setProduct_classify_id(product.getProduct_classify_id());
        pr
    }*/

    @Override
    public MicroOrderWrapper listMicroOrder(int pageNum) {
        Page<MicroOrder> list = PageHelper.startPage(pageNum, 10);
        List<MicroOrder> result = orderMapper.getAllMicroOrder();
        int totals=orderMapper.getPayedOrderTotal();
        int pages=totals/10+1;
        MicroOrderWrapper wrapper=new MicroOrderWrapper();
        wrapper.setMicroOrders(list);
        wrapper.setPages(pages);
        wrapper.setTotal(totals);
        return wrapper;
    }

    @Override
    public OrderInfo getOrderInfo(int orderId) {
        /*
        //佛祖保佑
        OrderInfo orderInfo=new OrderInfo();
        //取出对应order，提取部分信息
        Order order=orderMapper.selectByPrimaryKey(orderId);
        if(order==null){
            throw new WrongInputException();
        }
        orderInfo.setOrderId(orderId);
        int userId=order.getUser_id();
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null){
            throw new WrongInputException();
        }
        orderInfo.setBuyer(user.getUser_family_name()+user.getUser_given_name());
        orderInfo.setReceiver(order.getOrder_receiver());
        orderInfo.setPhone(order.getOrder_phone());
        orderInfo.setAddress(order.getOrder_address());
        orderInfo.setPostalCode(order.getOrder_postalcode());
        orderInfo.setPayed(order.getOrder_state());
        orderInfo.setNeedInvoices(order.getIs_need_invoices());
        orderInfo.setStatus(order.getOrder_status());
        orderInfo.setNeedInvoices(order.getIs_need_invoices());
        orderInfo.setCompanyType(order.getInvoices_type());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime=order.getOrder_create_times();
        String createTimeStr=sdf.format(createTime);
        orderInfo.setCreateTime(createTimeStr);
        Date payTime=order.getOrder_pay_time();
        String payTimeStr=sdf.format(payTime);
        orderInfo.setPayTime(payTimeStr);
        //获取支付方式
        OrderInformationExample orderInformationExample=new OrderInformationExample();
        orderInformationExample.createCriteria().andOrder_idEqualTo(orderId);
        List<OrderInformation> orderInformations=orderInformationMapper.selectByExample(orderInformationExample);
        if(orderInformations.size()!=1){
            throw new WrongInputException();
        }
        orderInfo.setPayId(orderInformations.get(0).getOrder_pay_id());
        //取出产品
        /*MyOrderDetailExample myOrderDetailExample=new MyOrderDetailExample();
        myOrderDetailExample.createCriteria().andOrder_idEqualTo(orderId);
        List<MyOrderDetail> myOrderDetails=myOrderDetailMapper.selectByExample(myOrderDetailExample);
        if(myOrderDetails.isEmpty()){
            throw new WrongInputException();
        }*/


        /*List<ProductAndOrderDetail> products=productMapper.getProductByOrderId(orderId);
        //建立map标记主产品与配件的关系
        Map<Integer,List<ProductAndOrderDetail>> mainProductMap=new HashMap<>();
        //Map<Integer,ProductAndOrderDetail> productMap=new HashMap<>();
        Map<Integer,Integer> listIndexMap=new HashMap<>();

        int index=0;
        List<MainProductInfo> mainProductInfos=new ArrayList<>();
        orderInfo.setMainProductInfos(mainProductInfos);

        //第一次循环取出主产品
        for(ProductAndOrderDetail product:products){
            //productMap.put(product.getProduct_id(),product);
            if(product.getProduct_attach_id()==0||product.getProduct_attach_id()==-1){  //说明是主产品
                mainProductMap.put(product.getProduct_id(),new ArrayList<>());
                MainProductInfo mainProductInfo=new MainProductInfo();
                mainProductInfo.setName(product.getProduct_name());
                mainProductInfo.setNumber(product.getBuyNumber());
                mainProductInfos.add(mainProductInfo);
                listIndexMap.put(product.getProduct_id(),index);
                index++;
            }
        }

        //第二次循环把所属配件加入主产品
        for(ProductAndOrderDetail product:products){
            int attachId=product.getProduct_attach_id();
            if(attachId!=0&&attachId!=-1){
                List<ProductAndOrderDetail> subList=mainProductMap.get(attachId);
                if(subList==null){
                    throw new WrongInputException();
                }
                subList.add(product);
                int listIndex=listIndexMap.get(attachId);
                MainProductInfo mainProductInfo=mainProductInfos.get(listIndex);
                List<SubAttatchOrderInfo> subAttatchOrderInfos=mainProductInfo.getAttatchOrderInfos();
                if(subAttatchOrderInfos==null){
                    subAttatchOrderInfos=new ArrayList<>();
                    mainProductInfo.setAttatchOrderInfos(subAttatchOrderInfos);
                }
                SubAttatchOrderInfo subAttatchOrderInfo=new SubAttatchOrderInfo();
                subAttatchOrderInfo.setName(product.getProduct_name());
                subAttatchOrderInfo.setNumber(product.getBuyNumber());
                List<ShoppingPropertyValue> spvs=shoppingPropertyValueMapper.getAttachValuePayed(product.getProduct_id(),orderId);
                StringBuilder sb=new StringBuilder();
                for(ShoppingPropertyValue spv:spvs){
                    sb.append(spv.getShopping_property_value());
                    sb.append(" ");
                }
                subAttatchOrderInfo.setValue(sb.toString());
                subAttatchOrderInfos.add(subAttatchOrderInfo);
            }
        }
        return orderInfo;*/
        return null;
    }

    @Transactional
    @Override
    public void alterOrderStatus(int orderId, String newStatus) {
        try {
            Order order = orderMapper.selectByPrimaryKey(orderId);
            if (order == null) {
                throw new WrongInputException();
            }
            order.setOrder_status(newStatus);
            orderMapper.updateByPrimaryKeySelective(order);
        } catch (WrongInputException e) {
            throw e;
        } catch (ServerInternalException e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    public List<HashMap<String, Object>> getShoppingCart(Integer userId) {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        List<ShoppingCartVO> shoppingVOS = shoppingMapper.selectShoppingByUserId(userId);
        for (ShoppingCartVO shoppingVO : shoppingVOS) {
            shoppingVO.getProductVO().setPicture(productPictureMapper.selectPictureByProductId(shoppingVO.getProductVO().getProductId()));
            Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingVO.getShoppingId());
            // 查询是否是单车类型
            String style = productStyleMapper.selectProductStyle(shopping.getProduct_id());
            HashMap<String, Object> map = new HashMap<String, Object>();
            if (Constants.BICYCLE.equals(style)) {
                map.put("type", "1");
            } else {
                // 非单车类型
                map.put("type", "0");
                List<PropertyVO> vos = shoppingMapper.selectProductPropertyByProductIdAndShoppingId(shoppingVO.getProductVO().getProductId(), shoppingVO.getShoppingId());
                map.put("properties", vos);
            }
            map.put("vo", shoppingVO);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<ProductPropertyVO> getShoppingCartProperties(Integer shoppingId) {
        // 查询出购物车
        Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingId);
        // 查询出他的配件
        List<ProductVO> list = productMapper.selectPartsByProductId(shopping.getProduct_id());
        List<ProductPropertyVO> list1 = new ArrayList<ProductPropertyVO>();
        for (ProductVO vo : list) {
            ProductPropertyVO productPropertyVO = new ProductPropertyVO();
            List<PropertyVO> vos = shoppingMapper.selectProductPropertyByProductIdAndShoppingId(vo.getProductId(), shoppingId);
            productPropertyVO.setProductType(vo.getProductType());
            productPropertyVO.setProductId(vo.getProductId());
            productPropertyVO.setPicture(vo.getPicture());
            productPropertyVO.setProperties(vos);
            productPropertyVO.setProductClassId(vo.getProductClassId());
            productPropertyVO.setProductName(vo.getProductName());
            productPropertyVO.setProductNumber(vo.getProductNumber());
            productPropertyVO.setProductPrice(vo.getProductPrice());
            list1.add(productPropertyVO);
        }
        return list1;
    }

    @Override
    public OrderInfo getOrderInfo2(int orderId) {
        //佛祖保佑
        OrderInfo orderInfo = new OrderInfo();
        //取出对应order，提取部分信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new WrongInputException();
        }
        orderInfo.setOrderId(orderId);
        int userId = order.getUser_id();
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new WrongInputException();
        }
        orderInfo.setBuyer(user.getUser_family_name() + user.getUser_given_name());
        orderInfo.setReceiver(order.getOrder_receiver());
        orderInfo.setPhone(order.getOrder_phone());
        orderInfo.setAddress(order.getOrder_address());
        orderInfo.setPostalCode(order.getOrder_postalcode());
        orderInfo.setPayed(order.getOrder_state());
        orderInfo.setNeedInvoices(order.getIs_need_invoices());
        orderInfo.setStatus(order.getOrder_status());
        orderInfo.setNeedInvoices(order.getIs_need_invoices());
        orderInfo.setCompanyType(order.getInvoices_type());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime = order.getOrder_create_times();
        String createTimeStr = sdf.format(createTime);
        orderInfo.setCreateTime(createTimeStr);
        Date payTime = order.getOrder_pay_time();
        String payTimeStr = sdf.format(payTime);
        orderInfo.setPayTime(payTimeStr);
        //获取发票信息
        if(order.getIs_need_invoices()){
            InvoicesExample invoicesExample = new InvoicesExample();
            invoicesExample.createCriteria().andUser_idEqualTo(userId);
            List<Invoices> invoices = invoicesMapper.selectByExample(invoicesExample);
            if(!invoices.isEmpty()){
                if(order.getInvoices_type()){
                    //公司
                    orderInfo.setInvoicesName(invoices.get(0).getInvoices_company_name());
                    orderInfo.setInvoicesCode(invoices.get(0).getInvoices_company_number());
                }else{
                    //个人
                    orderInfo.setInvoicesName(invoices.get(0).getInvoices_personal_name());
                }
            }
        }
        //获取支付方式
        OrderInformationExample orderInformationExample = new OrderInformationExample();
        orderInformationExample.createCriteria().andOrder_idEqualTo(orderId);
        List<OrderInformation> orderInformations = orderInformationMapper.selectByExample(orderInformationExample);
        if (orderInformations.size() != 1) {
            throw new WrongInputException();
        }
        orderInfo.setPayId(orderInformations.get(0).getOrder_pay_id());

        //取出主产品
        ShoppingExample shoppingExample=new ShoppingExample();
        shoppingExample.createCriteria().andOrder_idEqualTo(orderId);
        List<Shopping> shoppings=shoppingMapper.selectByExample(shoppingExample);
        List<MainProductInfo> mainProductInfos=new ArrayList<>();
        if(!shoppings.isEmpty()){
            for(Shopping shopping:shoppings){
                MainProductInfo mainProductInfo=new MainProductInfo();
                int shoppingId=shopping.getShopping_id();
                int number=shopping.getShopping_number();
                mainProductInfo.setNumber(number);
                int productId=shopping.getProduct_id();
                Product product=productMapper.selectByPrimaryKey(productId);
                mainProductInfo.setName(product.getProduct_name());
                ShoppingDetailExample shoppingDetailExample=new ShoppingDetailExample();
                shoppingDetailExample.createCriteria().andShopping_idEqualTo(shoppingId);
                List<ShoppingDetail> shoppingDetails=shoppingDetailMapper.selectByExample(shoppingDetailExample);

                List<HashMap<String,String>> values = new ArrayList<>();
                if(!shoppingDetails.isEmpty()){
                    for(ShoppingDetail shoppingDetail:shoppingDetails) {
                        StringBuilder sb = new StringBuilder();
                        HashMap<String,String> map = new HashMap<>();
                        int shoppingPropertyId = shoppingDetail.getShopping_property_id();
                        String propertyName = shoppingDetail.getShopping_property_name();
                        ShoppingPropertyValueExample shoppingPropertyValueExample = new ShoppingPropertyValueExample();
//                    shoppingPropertyValueExample.createCriteria().andShopping_property_idEqualTo(shoppingPropertyId);
                        shoppingPropertyValueExample.createCriteria().andShopping_detail_idEqualTo(shoppingDetail.getShopping_detail_id()).andShopping_property_idEqualTo(shoppingPropertyId);
                        List<ShoppingPropertyValue> shoppingPropertyValues = shoppingPropertyValueMapper.selectByExample(shoppingPropertyValueExample);
                        if (!shoppingPropertyValues.isEmpty()) {
                            for (ShoppingPropertyValue shoppingPropertyValue : shoppingPropertyValues) {
                                String propertyValue = shoppingPropertyValue.getShopping_property_value();
                                sb.append(propertyValue);
                                sb.append(",");
                            }
                        }
                        map.put(propertyName,sb.toString());
                        values.add(map);
                    }
                }
                mainProductInfo.setValue(values);
                mainProductInfos.add(mainProductInfo);
            }
        }
        orderInfo.setMainProductInfos(mainProductInfos);

        /*List<ProductAndOrderDetail> products = productMapper.getOrderProduct(orderId);
        List<MainProductInfo> mainProductInfos = new ArrayList<>();
        for (ProductAndOrderDetail product : products) {
            MainProductInfo mainProductInfo = new MainProductInfo();
            mainProductInfo.setNumber(product.getBuyNumber());
            mainProductInfo.setName(product.getProduct_name());
            //取出参数
            List<Property> properties = productMapper.getMainProductProperty(product.getShoppingId());
            String value = "";
            StringBuilder sb = new StringBuilder();
            for (Property property : properties) {
                sb.append(property.getK());
                sb.append(":");
                sb.append(property.getV());
                sb.append("  ");
            }
            mainProductInfo.setValue(sb.toString());

            SubAttatchOrderInfo subAttatchOrderInfo = new SubAttatchOrderInfo();
            List<Property> subProperties = productMapper.getSubProductProperty(product.getShoppingId());
            StringBuilder sb1 = new StringBuilder();
            for (Property property : subProperties) {
                sb1.append("[");
                sb1.append(property.getName());
                sb1.append("]");
                sb1.append(property.getK());
                sb1.append(":");
                sb1.append(property.getV());
                sb1.append("  ");
            }
            subAttatchOrderInfo.setValue(sb1.toString());
            mainProductInfo.setAttatchOrderInfos(subAttatchOrderInfo);
        }
        orderInfo.setMainProductInfos(mainProductInfos);*/

        return orderInfo;


    }

    @Override
    public List<Order> list(Integer userId) {
        OrderExample orderExample=new OrderExample();
        orderExample.createCriteria().andUser_idEqualTo(userId).andOrder_stateEqualTo(true);
        orderExample.setOrderByClause("order_create_times desc");
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<HashMap<String, Object>> getPayedShoppingCart(Integer userId, Integer orderId) {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        List<ShoppingCartVO> shoppingVOS = shoppingMapper.selectPayedShoppingByOrderId(userId,orderId);
        for (ShoppingCartVO shoppingVO : shoppingVOS) {
            shoppingVO.getProductVO().setPicture(productPictureMapper.selectPictureByProductId(shoppingVO.getProductVO().getProductId()));
            Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingVO.getShoppingId());
            // 查询是否是单车类型
            String style = productStyleMapper.selectProductStyle(shopping.getProduct_id());
            HashMap<String, Object> map = new HashMap<String, Object>();
            if (Constants.BICYCLE.equals(style)) {
                map.put("type", "1");
            } else {
                // 非单车类型
                map.put("type", "0");
                List<PropertyVO> vos = shoppingMapper.selectProductPropertyByProductIdAndShoppingId(shoppingVO.getProductVO().getProductId(), shoppingVO.getShoppingId());
                map.put("properties", vos);
            }
            map.put("vo", shoppingVO);
            list.add(map);
        }
        return list;
    }

    @Override
    public Integer getShoppingCartSum(Integer userId) {
        return shoppingMapper.countShoppingCartSum(userId);
    }

    @Transactional
    @Override
    public void alterExpressNumber(Integer orderId,String expressNumber) {
        try {
            Order order=orderMapper.selectByPrimaryKey(orderId);
            if(order!=null){
                order.setOrder_express_number(expressNumber);
                orderMapper.updateByPrimaryKeySelective(order);
                return;
            }
            //TODO:快递单号正则检测
            throw new WrongInputException();
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }
}
