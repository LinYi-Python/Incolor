package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.dto.MicroOrder;
import vip.incolor.entity.Order;
import vip.incolor.entity.OrderExample;
@Mapper
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer order_id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<MicroOrder> getAllMicroOrder();
/**
     * 添加订单
     *
     * @param record
     */
    void insertOrder(Order record);

    int getPayedOrderTotal();
}
