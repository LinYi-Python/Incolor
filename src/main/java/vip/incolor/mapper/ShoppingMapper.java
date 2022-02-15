package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.dto.FrontOrder;
import vip.incolor.entity.Shopping;
import vip.incolor.entity.ShoppingExample;
import vip.incolor.vo.ProductPropertyVO;
import vip.incolor.vo.PropertyVO;
import vip.incolor.vo.ShoppingCartVO;
import vip.incolor.vo.ShoppingVO;

@Mapper
@Repository
public interface ShoppingMapper {
    int deleteByPrimaryKey(Integer shopping_id);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    List<Shopping> selectByExample(ShoppingExample example);

    Shopping selectByPrimaryKey(Integer shopping_id);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);

    List<FrontOrder> getUnPayedShoppingCart(@Param("userId") Integer userId);

    Shopping selectProductByProductIdAndUserId(@Param("productId") Integer productId, @Param("userId") Integer userId);


    void updateByShoppingNumber(@Param("shoppingId") Integer shoppingId, @Param("shoppingNumber") Integer shoppingNumber);

    List<Shopping> selectProductByUserId(@Param("userId") Integer userId);

    int insertShopping(Shopping record);

    void insertDetail(PropertyVO vo);

    void insertPropertyValue(@Param("vo") PropertyVO vo);

    void deleteShoppingTrolleySecond(Integer shoppingId);

    void deleteShoppingTrolley(Integer shoppingId);

    Shopping selectProductByShoppingId(Integer shoppingId);

    void deleteShoppingTrolleyDetailAndValue(Integer shoppingId);

    List<ShoppingCartVO> selectShoppingByUserId(Integer userId);

    List<PropertyVO> selectProductPropertyByProductIdAndShoppingId(@Param("productId") Integer productId, @Param("shoppingId") Integer shoppingId);

    PropertyVO selectPropertiesByShoppingId(Integer shoppingId);

    void pay(Integer orderId);

    List<ShoppingCartVO> selectPayedShoppingByOrderId(@Param("userId") Integer userId, @Param("orderId") Integer orderId);

    int countShoppingCartSum(Integer userId);

}
