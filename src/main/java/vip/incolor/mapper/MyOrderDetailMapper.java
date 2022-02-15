package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.MyOrderDetail;
import vip.incolor.entity.MyOrderDetailExample;
@Mapper
@Repository
public interface MyOrderDetailMapper {
    int deleteByPrimaryKey(Integer order_detail_id);

    int insert(MyOrderDetail record);

    int insertSelective(MyOrderDetail record);

    List<MyOrderDetail> selectByExample(MyOrderDetailExample example);

    MyOrderDetail selectByPrimaryKey(Integer order_detail_id);

    int updateByPrimaryKeySelective(MyOrderDetail record);

    int updateByPrimaryKey(MyOrderDetail record);
}