package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.dto.SearchCondition;
import vip.incolor.entity.RegisterUser;
import vip.incolor.entity.User;
import vip.incolor.entity.UserExample;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 新增注册用户
     *
     * @param user 注册用户
     * @return
     */
    int addUser(RegisterUser user);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return
     */
    User findUserByEmail(String email);

    /**
     * 通过验证修改用户验证状态
     *
     * @param email 邮箱
     * @return
     */
    int updateStatus(String email);

    /**
     * 查询用户
     *
     * @return
     */
    List<User> selectUser();

    /**
     * 冻结帐号
     *
     * @param userId 用户编号
     * @return
     */
    int freezeUser(Integer userId);

    /**
     * 解冻帐号
     *
     * @param userId 用户编号
     * @return
     */
    int unfreezeUser(Integer userId);

    /**
     * 以时间为条件查询用户
     *
     * @param con 查询条件
     * @return
     */
    List<User> selectUserByCondition(SearchCondition con);

    /**
     * 通过帐号密码查询用户
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    User selectByAccountAndPassword(@Param("email") String email, @Param("password") String password);

    void addWeixinUUID(@Param("openid") String openid, @Param("userId") Integer userId);

    void addQQUUID(@Param("openid") String openid, @Param("userId") Integer userId);

    void addWeiboUUID(@Param("openid") long openid, @Param("userId") Integer userId);


    Integer selectWeiboUUid(String openid);

    Integer selectQQUUid(String openid);

    Integer selectWeixinUUid(String openid);


    User getByIdAndPassword(@Param("id") Integer userId, @Param("password") String password);

    /**
     * 通过帐号查询用户
     *
     * @param account 邮箱
     * @return
     */
    User selectByAccount(String account);


    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return
     */
    User selectByEmail(String email);

    int updatePassword(@Param("email") String email, @Param("password") String password);
}
