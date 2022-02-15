package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Manager;
import vip.incolor.entity.ManagerExample;
@Mapper
@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer manager_id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer manager_id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    /**
     * 通过帐号密码查询管理员
     *
     * @param account  密码
     * @param password 密码
     * @return
     */
    Manager selectByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    List<Manager> list();
}