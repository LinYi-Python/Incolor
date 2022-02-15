package vip.incolor.service;


import vip.incolor.entity.Shopping;
import vip.incolor.vo.ProductVO;
import vip.incolor.vo.PropertyVO;
import vip.incolor.vo.ShoppingVO;

import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description: 产品 service
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 17:59
 */
public interface ProductService {

    /**
     * 点击某产品得到三级页面：详情
     *
     * @param productId
     * @return
     */
    HashMap getProductDetail(Integer productId);

    /**
     * 加入购物车，产生一个订单
     */
    HashMap addShoppingTrolleyFirst(Shopping shopping);


    /**
     * 参数选择第二步
     */
    List<ShoppingVO> addShoppingTrolleySecond(Integer shoppingId, List<PropertyVO> propertyVOs);

    /**
     * 参数选择第二步
     */
    void addShoppingTrolleyLast(Integer shoppingId, List<PropertyVO> propertyVOs);

    /**
     * @param shoppingId
     */
    void giveUpShoppingTrolleySecond(Integer shoppingId);


    /**
     * @param shoppingId
     */
    void giveUpShoppingTrolley(Integer shoppingId);


    /**
     * @param shoppingId
     */
    HashMap<String, Object> returnShoppingTrolleyLast(Integer shoppingId);

    String getProductSize(Integer productId);

    List<HashMap<String, Object>> selectProductByProductTag(String productTag);



}
