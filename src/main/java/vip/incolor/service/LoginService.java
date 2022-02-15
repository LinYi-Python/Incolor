package vip.incolor.service;

import vip.incolor.dto.PasswordConfirm;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Manager;
import vip.incolor.entity.User;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 登录
 * @date 2018-03-31
 * @time 20:22
 */
public interface LoginService {

    /**
     * 管理员登录
     *
     * @param account             帐号
     * @param password            密码
     * @param code                验证码
     * @param imgVerificationCode session 中存储的验证码
     * @return
     */
    Manager adminLogin(String account, String password, String code, String imgVerificationCode);


    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    User userLogin(String email, String password);


    /**
     * 添加登录用户
     *
     * @param openid
     */
    Integer addWeixinLoginUser(String openid);


    /**
     * 添加登录用户
     *
     * @param openid
     */
    Integer addQQLoginUser(String openid);


    /**
     * 添加登录用户
     *
     * @param openid
     */
    Integer addWeiboLoginUser(String openid);


    RequestResult forgotPassword(String email, String code, String imgVerificationCode);


    RequestResult forgotPasswordConfirm(String email, String verifyCode);


    void forgotPasswordAddNewPassword(PasswordConfirm confirm);


}
