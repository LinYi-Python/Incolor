package vip.incolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.incolor.entity.RegisterUser;
import vip.incolor.exception.DuplicateEmailException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.RegisterService;
import vip.incolor.utils.GsonUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 用户注册 controller
 * @date 2018-03-18
 * @time 14:56
 */
@RestController
@RequestMapping("register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    /**
     * 注册用户并发送验证邮件
     *
     * @param user          注册用户
     * @param bindingResult 错误结果
     * @param request       http 请求
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String register(@Valid RegisterUser user, BindingResult bindingResult, HttpServletRequest request, String gender,String isSignUp) {
        if (bindingResult.hasErrors()) {
            //数据格式有错误
            return GsonUtil.getErrorJson("wrong input");
        }
        try {
            registerService.register(user, request,gender,isSignUp);
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (DuplicateEmailException e) {
            return GsonUtil.getErrorJson("duplicate email");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("bad");
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 验证邮箱
     *
     * @param sid   数字签名
     * @param email 邮箱
     * @return
     */
    @RequestMapping(value = "/email/confirm", method = RequestMethod.GET)
    public String emailConfirm(@RequestParam("sid") String sid, @RequestParam("email") String email) {
        if ("".equals(sid) || "".equals(email)) {
            GsonUtil.getErrorJson("wrong link");
        }
        return registerService.emailConfirm(sid, email);
    }


}
