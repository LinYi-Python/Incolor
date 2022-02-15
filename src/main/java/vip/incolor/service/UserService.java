package vip.incolor.service;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import vip.incolor.dto.RequestResult;
import vip.incolor.dto.SearchCondition;
import vip.incolor.entity.User;
import vip.incolor.entity.UserGivenEmail;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 用户管理
 * @date 2018-03-31
 * @time 21:02
 */
public interface UserService {
    /**
     * 查看所有用户
     *
     * @param pageNum 页数
     * @return
     */
    Page<User> checkUser(Integer pageNum);

    /**
     * 冻结帐号
     *
     * @param userId 用户编号
     * @return
     */
    int freezeUser(Integer userId);

    int unfreezeUser(Integer userId);

    Page<User> searchUser(SearchCondition con, Integer pageNum);

    int signUpEmail(String email);

    User getUser(Integer userId);

    void modifyUser(String familyName, String givenName, Boolean gender,String phone, HttpSession session );
    void modifyPassword(String oldPassword, String newPassword, HttpSession session);
    void modifyEmail(String email,String password, HttpSession session);
    String getExpress(Integer orderId);
//    Integer getOrderIdFromOrderInfo(Integer UserId);

    List<UserGivenEmail> getSignUpEmail();
}
