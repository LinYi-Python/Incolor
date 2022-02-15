package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.PropertyValue;
import vip.incolor.entity.PropertyValueExample;
import vip.incolor.vo.PropertyVO;

@Mapper
@Repository
public interface PropertyValueMapper {
    int deleteByPrimaryKey(Integer property_value_id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    List<PropertyValue> selectByExample(PropertyValueExample example);

    PropertyValue selectByPrimaryKey(Integer property_value_id);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);

    List<PropertyVO> selectByProductId(Integer productId);
}
