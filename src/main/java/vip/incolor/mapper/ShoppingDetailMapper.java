package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.ShoppingDetail;
import vip.incolor.entity.ShoppingDetailExample;
@Mapper
@Repository
public interface ShoppingDetailMapper {
    int deleteByPrimaryKey(Integer shopping_detail_id);

    int insert(ShoppingDetail record);

    int insertSelective(ShoppingDetail record);

    List<ShoppingDetail> selectByExample(ShoppingDetailExample example);

    ShoppingDetail selectByPrimaryKey(Integer shopping_detail_id);

    int updateByPrimaryKeySelective(ShoppingDetail record);

    int updateByPrimaryKey(ShoppingDetail record);
}