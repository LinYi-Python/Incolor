package vip.incolor.service;

import javax.xml.transform.Result;
import java.awt.*;
import java.util.List;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/4/29
 * @time 15:21
 */
public interface ExpressService {

    /**
     *
     * @param orderId 订单Id
     */
    String  getMyExpressNumber(Integer orderId);


    /**
     *
     * @param ExpressNumber  快递单号
     * @param orderId 订单Id
     */
    void modifyMyExpressNumber(Integer orderId, String ExpressNumber);

    /**
     *
     * @param orderId 订desc单Id
     */
    void deleteMyExpressNumber(Integer orderId);

    /**
     *  @param expressNumber 快递单号
     *
     *
     */
     String postMyExpress(String expressNumber);

//    /**
//     *
//     * @param orderId 用户Id
//     */
//      String getMyExpress(Integer orderId);






}
