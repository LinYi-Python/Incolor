package vip.incolor.service;

import com.github.pagehelper.Page;
import vip.incolor.dto.FrontOrder;
import vip.incolor.dto.MicroOrder;
import vip.incolor.dto.MicroOrderWrapper;
import vip.incolor.dto.OrderInfo;
import vip.incolor.entity.Order;
import vip.incolor.vo.ProductPropertyVO;
import vip.incolor.vo.ProductVO;
import vip.incolor.vo.ShoppingCartVO;
import vip.incolor.vo.ShoppingVO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 21:42
 */
public interface OrderService {
    List<FrontOrder> getMyOrder(HttpSession session, Boolean isPayed);

    List<FrontOrder> getMyHistoryOrder(HttpSession session);

    List<FrontOrder> getMyShoppingCart(HttpSession session);

    MicroOrderWrapper listMicroOrder(int pageNum);

    OrderInfo getOrderInfo(int orderId);

    void alterOrderStatus(int orderId, String newStatus);

    List<HashMap<String, Object>> getShoppingCart(Integer userId);

    List<ProductPropertyVO> getShoppingCartProperties(Integer shoppingId);

    OrderInfo getOrderInfo2(int orderId);

    List<Order> list(Integer userId);

    List<HashMap<String, Object>> getPayedShoppingCart(Integer userId, Integer orderId);

    Integer getShoppingCartSum(Integer userId);

    void alterExpressNumber(Integer orderId,String expressNumber);
}
