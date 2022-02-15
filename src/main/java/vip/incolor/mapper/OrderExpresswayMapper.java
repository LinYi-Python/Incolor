package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.OrderExpressway;
import vip.incolor.entity.OrderExpresswayExample;
@Mapper
@Repository
public interface OrderExpresswayMapper {
    int deleteByPrimaryKey(Integer order_expressway_id);

    int insert(OrderExpressway record);

    int insertSelective(OrderExpressway record);

    List<OrderExpressway> selectByExample(OrderExpresswayExample example);

    OrderExpressway selectByPrimaryKey(Integer order_expressway_id);

    int updateByPrimaryKeySelective(OrderExpressway record);

    int updateByPrimaryKey(OrderExpressway record);
}