package vip.incolor.service;

import vip.incolor.dto.FrontOrder;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/24
 * @time 21:26
 */
public interface ShoppingService {
    List<FrontOrder> getShoppingCart(HttpSession session);

    void modifyShoppingNumber(Integer shoppingId, Integer number);

    void deleteShoppingCartItem(HttpSession session, Integer shoppingId);
}
