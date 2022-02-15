package vip.incolor.service;

import org.springframework.web.bind.annotation.RequestParam;
import vip.incolor.entity.RegisterUser;
import vip.incolor.exception.DuplicateEmailException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 用户注册接口
 * @date 2018-03-18
 * @time 14:26
 */
public interface RegisterService {
    /**
     * 注册用户
     * @editor LiYizhan
     * @param user
     * @throws WrongInputException
     */
    void register(RegisterUser user, HttpServletRequest request, String gender,String isSignUp) throws WrongInputException, DuplicateEmailException, ServerInternalException;

    /**
     * 邮箱验证
     *
     * @param sid   数字签名
     * @param email 邮箱
     * @return
     */
    String emailConfirm(@RequestParam("sid") String sid, @RequestParam("email") String email);
}
