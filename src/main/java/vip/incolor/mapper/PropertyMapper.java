package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Property;
import vip.incolor.entity.PropertyExample;
import vip.incolor.vo.PropertyVO;

@Mapper
@Repository
public interface PropertyMapper {
    int deleteByPrimaryKey(Integer property_id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer property_id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}
