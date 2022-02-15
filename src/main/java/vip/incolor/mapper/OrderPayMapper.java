package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.OrderPay;
import vip.incolor.entity.OrderPayExample;
@Mapper
@Repository
public interface OrderPayMapper {
    int deleteByPrimaryKey(Integer order_pay_id);

    int insert(OrderPay record);

    int insertSelective(OrderPay record);

    List<OrderPay> selectByExample(OrderPayExample example);

    OrderPay selectByPrimaryKey(Integer order_pay_id);

    int updateByPrimaryKeySelective(OrderPay record);

    int updateByPrimaryKey(OrderPay record);
}