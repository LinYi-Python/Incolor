package vip.incolor.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vip.incolor.dto.RequestResult;
import vip.incolor.dto.SearchCondition;
import vip.incolor.entity.User;
import vip.incolor.entity.UserGivenEmail;
import vip.incolor.service.UserService;
import vip.incolor.utils.IncolorResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 用户管理
 * @date 2018-03-31
 * @time 21:00
 */
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    /**
     * 查看所有用户
     *
     * @param pageNum 页数
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public RequestResult checkUser(@RequestParam("pageNum") Integer pageNum) {
        Page<User> list = userService.checkUser(pageNum);
        if (list.getTotal() > 0) {
            return IncolorResultUtil.success(list, list.getPages(), list.getTotal());
        }
        return IncolorResultUtil.error("没有数据");

    }

    /**
     * 时间搜索用户
     *
     * @param con     查询条件
     * @param pageNum 页数
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public RequestResult searchUser(@Valid SearchCondition con, BindingResult result, @RequestParam("pageNum") Integer pageNum) {
        if (result.hasErrors()) {
            return IncolorResultUtil.error(result);
        }
        Page<User> list = userService.searchUser(con, pageNum);
        if (list.getTotal() <= 0) {
            return IncolorResultUtil.error("没有数据");
        }
        return IncolorResultUtil.success(list, list.getPages(), list.getTotal());
    }

    /**
     * 冻结用户
     *
     * @param userId 用户编号
     * @return
     */
    @RequestMapping(value = "/freeze", method = RequestMethod.GET)
    public RequestResult freezeUser(@RequestParam(value = "userId") Integer userId) {
        int i = userService.freezeUser(userId);
        if (i < 0) {
            return IncolorResultUtil.error("冻结帐号失败");
        }
        return IncolorResultUtil.success();
    }


    /**
     * 解冻用户
     *
     * @param userId 用户编号
     * @return
     */
    @RequestMapping(value = "/unfreeze", method = RequestMethod.GET)
    public RequestResult unfreezeUser(@RequestParam(value = "userId") Integer userId) {
        int i = userService.unfreezeUser(userId);
        if (i < 0) {
            return IncolorResultUtil.error("解冻帐号失败");
        }
        return IncolorResultUtil.success();
    }

    /**
     * 用户首页 sign up
     *
     * @param email 用户邮箱
     * @return
     */
    @RequestMapping(value = "/sign/up", method = RequestMethod.POST)
    public RequestResult signUpEmail(@RequestParam(value = "email") String email) {
        int i = userService.signUpEmail(email);
        if (i < 0) {
            return IncolorResultUtil.error("sign up falil");
        }
        return IncolorResultUtil.success();
    }


    @RequestMapping(value = "/get/sign/up/email", method = RequestMethod.GET)
    public RequestResult getSignUpEmail() {
        List<UserGivenEmail> emails = userService.getSignUpEmail();
        if (emails.isEmpty()) {
            return IncolorResultUtil.error("no sign up");
        }
        return IncolorResultUtil.success(emails);
    }

    @RequestMapping(value = "/test/up", method = RequestMethod.GET)
    public RequestResult test(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("user_id"));
        System.out.println(request.getSession(false) == null);
        return IncolorResultUtil.success();
    }


}
