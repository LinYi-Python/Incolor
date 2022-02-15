package vip.incolor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.RegisterUser;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 注册 mapper
 * @date 2018-03-18
 * @time 14:50
 */
@Mapper
@Repository
public interface RegisterMapper {

    /**
     * 新增注册用户
     * @param user
     * @return
     */
    int addUser(@Param("user") RegisterUser user);
}
