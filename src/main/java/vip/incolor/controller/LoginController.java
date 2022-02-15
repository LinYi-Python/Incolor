package vip.incolor.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vip.incolor.constant.Constants;
import vip.incolor.dto.MultiInvoices;
import vip.incolor.dto.PasswordConfirm;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Manager;
import vip.incolor.entity.RegisterUser;
import vip.incolor.entity.User;
import vip.incolor.exception.AccessException;
import vip.incolor.exception.DuplicateEmailException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.LoginService;
import vip.incolor.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 登录
 * @date 2018-03-31
 * @time 20:13
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        super();
        this.loginService = loginService;
    }

    /**
     * 管理员登录
     *
     * @param account  帐号
     * @param password 密码
     * @param code     验证码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String login(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password, @RequestParam(value = "code") String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String imgVerificationCode = (String) session.getAttribute("imgVerificationCode");
        session.removeAttribute("imgVerificationCode");
        Manager manager = loginService.adminLogin(account, password, code, imgVerificationCode);
        if (manager != null) {
            // 先注销
            session.removeAttribute("manager");
            session.setAttribute("manager", manager);
            // 设置过期时间为 2 个小时，以秒为单位
            session.setMaxInactiveInterval(60 * 60 * 2);
            return GsonUtil.getSuccessJson(manager);
        } else {
            return GsonUtil.getErrorJson();
        }
    }

    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, HttpServletRequest request) {
        User user = loginService.userLogin(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            // 先注销
            session.removeAttribute("user_id");
            session.setAttribute("user_id", user.getUser_id());
            // 设置过期时间为 2 个小时，以秒为单位
            session.setMaxInactiveInterval(60 * 60 * 2);
            return GsonUtil.getSuccessJson(user);
        } else {
            return GsonUtil.getErrorJson();
        }
    }

    /**
     * 图片验证码的地址
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET)
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建 imgVerificationCode 实例，用于创建验证码图片
        VerificationCode instance = new VerificationCode(120, 40, 4, 30);
        //将生成的验证码存储于 session 中
        HttpSession session = request.getSession();
        logger.info("session");
        session.removeAttribute("imgVerificationCode");
        session.setAttribute("imgVerificationCode", instance.getCode());
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        instance.write(response.getOutputStream());
    }

//    @ResponseBody
//    @RequestMapping(value = "/getPicVerifyCode", method = RequestMethod.GET)
//    public HashMap<String, String> getPicVerifyCode() {
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        //hashMap.put("codeUrl", "http://www.incolor.vip/incolor1/login/picVerifyCode");
//        //hashMap.put("codeUrl", "http://192.168.43.237:9090/incolor1/login/getVerificationCode");
//        hashMap.put("codeUrl", "http://39.108.214.184/incolor1/login/getVerificationCode");
//        return hashMap;
//    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }


    @RequestMapping(value = "/get/weixin/code", method = RequestMethod.GET)
    @ResponseBody
    public String getWeixinCode() {
        //拼接url
        StringBuilder url = new StringBuilder();
        url.append("https://open.weixin.qq.com/connect/qrconnect?");
        url.append("response_type=code");
        url.append("&scope=snsapi_login");
        url.append("&appid=" + Constants.WEI_CHAT_APP_ID);
        //回调地址 ,回调地址要进行Encode转码
        String redirect_uri = Constants.REDIRECT_URL;
        //转码
        url.append("&redirect_uri=").append(URLEncodeUtil.getURLEncoderString(redirect_uri));
        url.append("&state=ok");
        return GsonUtil.getSuccessJson(url.toString());
    }


    /**
     * 获取 token ,该步骤返回的 token 期限为一个月
     *
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weixin/callback.do", method = RequestMethod.GET)
    @ResponseBody
    public String getWeixinAccessToken(String code, HttpServletRequest request) {
        if (code != null) {
            System.out.println(code);
        }
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
        url.append("grant_type=authorization_code");
        url.append("&appid=").append(Constants.WEI_CHAT_APP_ID);
        url.append("&secret=").append(Constants.WEI_CHAT_APP_SECRET);
        url.append("&code=").append(code);
        String result = null;
        try {
            result = HttpClientUtils.get(url.toString(), "UTF-8");
            JSONObject o = JSON.parseObject(result);
            String accessToken = o.getString("access_token");
            String expires_in = o.getString("expires_in");
            String refresh_token = o.getString("refresh_token");
            String openid = o.getString("openid");
            String scope = o.getString("scope");
            String unionid = o.getString("unionid");
            // 添加第三方登录用户
            Integer userId = loginService.addWeixinLoginUser(openid);
            System.out.println("userId: " + userId);
            HttpSession session = request.getSession();
            // 先注销
            session.removeAttribute("user_id");
            session.setAttribute("user_id", userId);
            // 设置过期时间为 2 个小时，以秒为单位
            session.setMaxInactiveInterval(60 * 60 * 2);
        } catch (Exception e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }


    @RequestMapping("/test")
    @ResponseBody
    public String getMyInvoices(HttpSession session) {
        return GsonUtil.getSuccessJson(session.getAttribute("user_id"));
    }


    @RequestMapping(value = "/get/qq/code", method = RequestMethod.GET)
    @ResponseBody
    public String getQQCode() throws Exception {
        //拼接url
        StringBuilder url = new StringBuilder();
        url.append("https://graph.qq.com/oauth2.0/authorize?");
        url.append("response_type=code");
        url.append("&client_id=").append(Constants.QQ_APP_Id);
        //回调地址 ,回调地址要进行Encode转码
        String redirect_uri = Constants.REDIRECT_URL;
        //转码
        url.append("&redirect_uri=").append(URLEncodeUtil.getURLEncoderString(redirect_uri));
        url.append("&state=ok");
        System.out.println(url.toString());
        return GsonUtil.getSuccessJson(url.toString());
    }


    /**
     * 获取 token ,该步骤返回的 token 期限为一个月
     *
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/qq/callback.do", method = RequestMethod.GET)
    @ResponseBody
    public String getQQAccessToken(String code, HttpServletRequest request) throws Exception {
        if (code != null) {
            System.out.println(code);
        }
        StringBuilder url = new StringBuilder();
        url.append("https://graph.qq.com/oauth2.0/token?");
        url.append("grant_type=authorization_code");
        url.append("&client_id=").append(Constants.QQ_APP_Id);
        url.append("&client_secret=").append(Constants.QQ_APP_SECRET);
        url.append("&redirect_uri=").append(URLEncodeUtil.getURLEncoderString(Constants.REDIRECT_URL));
        url.append("&code=").append(code);
        String result = HttpClientUtils.get(url.toString(), "UTF-8");
        System.out.println(result);
        //把token保存
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(result, "&");
        String s1 = null;
        for (String s : items) {
            s1 = s;
            System.out.println(s);
        }
        String accessToken = items[0].substring(items[0].indexOf('=') + 1);
        System.out.println("items[0]. " + items[0].substring(items[0].indexOf('=') + 1));
        String expiresIn = items[1].substring(items[1].indexOf('=') + 1);
        String refreshToken = items[2].substring(items[2].indexOf('=') + 1);
        StringBuilder url1 = new StringBuilder();
        url1.append("https://graph.qq.com/oauth2.0/me?");
        url1.append("access_token=").append(accessToken);
        String result1 = HttpClientUtils.get(url1.toString(), "UTF-8");
        String[] items1 = StringUtils.splitByWholeSeparatorPreserveAllTokens(result, ",");
        System.out.println("url1: " + url1);
        System.out.println("result1: " + result1);

        JSONObject o = JSON.parseObject(result1.substring(result1.indexOf("(") + 1, result1.lastIndexOf(")")));
        String clientId = o.getString("client_id");
        String openid = o.getString("openid");
        // 添加第三方登录用户
        Integer userId = loginService.addQQLoginUser(openid);
        HttpSession session = request.getSession();
        // 先注销
        session.removeAttribute("user_id");
        session.setAttribute("user_id", userId);
        // 设置过期时间为 2 个小时，以秒为单位
        session.setMaxInactiveInterval(60 * 60 * 2);
        return GsonUtil.getSuccessJson();
    }


    @RequestMapping(value = "/get/weibo/code", method = RequestMethod.GET)
    @ResponseBody
    public String getWeiboCode() throws Exception {
        //拼接url
        StringBuilder url = new StringBuilder();
        url.append("https://api.weibo.com/oauth2/authorize?");
        url.append("&client_id=").append(Constants.WEI_BO_APP_ID);
        //回调地址 ,回调地址要进行Encode转码
        String redirect_uri = Constants.REDIRECT_URL;
        //转码
        url.append("&redirect_uri=").append(URLEncodeUtil.getURLEncoderString(redirect_uri));
        url.append("&state=ok");
        System.out.println(url.toString());
        return GsonUtil.getSuccessJson(url.toString());
    }

    /**
     * 获取token,该步骤返回的token期限为一个月
     *
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weibo/callback.do", method = RequestMethod.GET)
    @ResponseBody
    public String getWeiboAccessToken(String code, HttpServletRequest request) throws Exception {
        if (code != null) {
            System.out.println(code);
        }
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "authorization_code");
        map.put("client_id", Constants.WEI_BO_APP_ID);
        map.put("client_secret", Constants.WEI_BO_APP_SECRET);
        map.put("redirect_uri", Constants.REDIRECT_URL);
        map.put("code", code);
        StringBuilder url = new StringBuilder();
        url.append("https://api.weibo.com/oauth2/access_token");
        String result = HttpClientUtils.postParameters(url.toString(), map);
        System.out.println("url:" + url.toString());
        //把token保存
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(result, "&");
        String s1 = null;
        for (String s : items) {
            s1 = s;
            System.out.println("items: " + s);
        }
        JSONObject o = JSON.parseObject(s1);
        String accessToken = o.getString("accessToken");
        String remindIn = o.getString("remindIn");
        String expiresIn = o.getString("expiresIn");
        String uid = o.getString("uid");
        System.out.println("uid" + uid);
        String isRealName = o.getString("isRealName");
        // 添加第三方登录用户
        Integer userId = loginService.addWeiboLoginUser(uid);
        HttpSession session = request.getSession();
        // 先注销
        session.removeAttribute("user_id");
        session.setAttribute("user_id", userId);
        // 设置过期时间为 2 个小时，以秒为单位
        session.setMaxInactiveInterval(60 * 60 * 2);
        return GsonUtil.getSuccessJson();
    }


    /**
     * 退出登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user_id");
        session.invalidate();
        return GsonUtil.getErrorJson();
    }


    /**
     * 忘记密码第一步:验证邮箱,填写网页验证码，和账号
     *
     * @param email 邮箱
     * @param code  验证码
     * @return
     */
    @RequestMapping(value = "/forgot/password", method = RequestMethod.POST)
    @ResponseBody
    public RequestResult forgotPassword(@RequestParam("email") String email, @RequestParam("code") String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String imgVerificationCode = (String) session.getAttribute("imgVerificationCode");
        session.removeAttribute("imgVerificationCode");
        return loginService.forgotPassword(email, code, imgVerificationCode);

    }


    /**
     * 忘记密码第二步：验证邮箱验证码
     *
     * @param email      邮箱
     * @param verifyCode 邮箱
     * @return
     */
    @RequestMapping(value = "/forgot/password/confirm", method = RequestMethod.POST)
    @ResponseBody
    public RequestResult forgotPasswordConfirm(@RequestParam("email") String email, @RequestParam("verifyCode") String verifyCode) {
        return loginService.forgotPasswordConfirm(email, verifyCode);
    }


    /**
     * 忘记密码第三步：修改密码
     *
     * @param confirm 邮箱
     * @return
     */
    @RequestMapping(value = "/forgot/password/add/new/password", method = RequestMethod.POST)
    @ResponseBody
    public String forgotPasswordAddNewPassword(@Valid PasswordConfirm confirm, BindingResult result) {
        if (result.hasErrors()) {
            //数据格式有错误
            return GsonUtil.getErrorJson(result);
        }
        try {
            loginService.forgotPasswordAddNewPassword(confirm);
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (DuplicateEmailException e) {
            return GsonUtil.getErrorJson("duplicate email");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("bad");
        }
        return GsonUtil.getSuccessJson();
    }


}
