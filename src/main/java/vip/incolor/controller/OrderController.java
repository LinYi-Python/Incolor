package vip.incolor.controller;

import com.github.pagehelper.Page;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.incolor.dto.MicroOrder;
import vip.incolor.dto.MicroOrderWrapper;
import vip.incolor.dto.OrderInfo;
import vip.incolor.dto.RequestResult;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.OrderService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/30
 * @time 10:31
 */
@RestController
@RequestMapping("/orderManage")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    //所有用户已支付的订单列表列出（分页给出）
    @RequestMapping(value = "/listOrder/{pageNum}", method = RequestMethod.GET)
    public String listOrder(@PathVariable("pageNum") Integer pageNum){
        MicroOrderWrapper wrapper=orderService.listMicroOrder(pageNum);
        if (wrapper.getMicroOrders().size() > 0) {
            return GsonUtil.getSuccessJson(wrapper);
        } else {
            return GsonUtil.getErrorJson("没有数据");
        }
    }

    @RequestMapping(value = "/alterExpressNumber",method = RequestMethod.POST)
    public String alterExpressNumber(Integer orderId,String expressNumber){
        try{
            orderService.alterExpressNumber(orderId,expressNumber);
            return GsonUtil.getSuccessJson();
        }catch (Exception e){
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    //访问具体的订单
    @RequestMapping(value = "/viewOrder/{orderId}",method = RequestMethod.GET)
    public String viewOrder(@PathVariable("orderId") Integer orderId){
        try {
            OrderInfo orderInfo=orderService.getOrderInfo2(orderId);
            return GsonUtil.getSuccessJson(orderInfo);
        } catch (Exception e) {
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    //改订单状态
    @RequestMapping("/alterOrderStatus")
    public String alterOrderStatus(Integer orderId,String newStatus){
        try {
            orderService.alterOrderStatus(orderId,newStatus);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e){
            return GsonUtil.getErrorJson("server internal error");
        }
    }
}
