package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Address;
import vip.incolor.entity.AddressExample;

@Mapper
@Repository
public interface AddressMapper {
    int deleteByPrimaryKey(Integer address_id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer address_id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}