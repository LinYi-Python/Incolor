package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.OrderInformation;
import vip.incolor.entity.OrderInformationExample;
@Mapper
@Repository
public interface OrderInformationMapper {
    int deleteByPrimaryKey(Integer order_information_id);

    int insert(OrderInformation record);

    int insertSelective(OrderInformation record);

    List<OrderInformation> selectByExample(OrderInformationExample example);

    OrderInformation selectByPrimaryKey(Integer order_information_id);

    int updateByPrimaryKeySelective(OrderInformation record);

    int updateByPrimaryKey(OrderInformation record);

    /**
     * 添加订单信息
     *
     * @param record
     */
    void insertOrderInformation(OrderInformation record);
}
