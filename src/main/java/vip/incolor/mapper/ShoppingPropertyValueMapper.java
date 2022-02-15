package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.ShoppingPropertyValue;
import vip.incolor.entity.ShoppingPropertyValueExample;

@Mapper
@Repository
public interface ShoppingPropertyValueMapper {
    int deleteByPrimaryKey(Integer shopping_property_value_id);

    int insert(ShoppingPropertyValue record);

    int insertSelective(ShoppingPropertyValue record);

    List<ShoppingPropertyValue> selectByExample(ShoppingPropertyValueExample example);

    ShoppingPropertyValue selectByPrimaryKey(Integer shopping_property_value_id);

    int updateByPrimaryKeySelective(ShoppingPropertyValue record);

    int updateByPrimaryKey(ShoppingPropertyValue record);

    List<ShoppingPropertyValue> getOrderParams(@Param("oi") Integer orderId);

    List<ShoppingPropertyValue> getShoppingParams(@Param("si") Integer shoppingId);

    List<ShoppingPropertyValue> getAttachValue(@Param("pi") Integer productId);

    List<ShoppingPropertyValue> getAttachValuePayed(@Param("pi") Integer productId,@Param("oi") Integer orderId);
}