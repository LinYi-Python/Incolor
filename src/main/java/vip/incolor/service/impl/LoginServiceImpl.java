package vip.incolor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.constant.Constants;
import vip.incolor.dto.PasswordConfirm;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.ForgotPasswordConfirm;
import vip.incolor.entity.Manager;
import vip.incolor.entity.RegisterUser;
import vip.incolor.entity.User;
import vip.incolor.exception.DuplicateEmailException;
import vip.incolor.exception.NoSuchUserException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ForgotPasswordConfirmMapper;
import vip.incolor.mapper.ManagerMapper;
import vip.incolor.mapper.UserMapper;
import vip.incolor.service.LoginService;
import vip.incolor.utils.Checker;
import vip.incolor.utils.IncolorResultUtil;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 登录
 * @date 2018-03-31
 * @time 20:26
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private JavaMailSender mailSender;

    private ManagerMapper managerMapper;
    private UserMapper userMapper;
    private ForgotPasswordConfirmMapper forgotPasswordConfirmMapper;

    @Autowired
    public LoginServiceImpl(ManagerMapper managerMapper, UserMapper userMapper, ForgotPasswordConfirmMapper forgotPasswordConfirmMapper) {
        super();
        this.managerMapper = managerMapper;
        this.userMapper = userMapper;
        this.forgotPasswordConfirmMapper = forgotPasswordConfirmMapper;
    }

    /**
     * 管理员登录
     *
     * @param account             帐号
     * @param password            密码
     * @param code                验证码
     * @param imgVerificationCode session 中存储的验证码
     * @return
     */
    @Override
    public Manager adminLogin(String account, String password, String code, String imgVerificationCode) {
        if (!code.equals(imgVerificationCode)) {
            return null;
        }
        // 账户必须为数字、字母、字符构成，12-30 位
        if (!Checker.isIncolorAdminAccount(account)) {
            return null;
        }
        //TODO:MD5加密password，去做哈希碰撞
        // password = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT + account).getBytes());
        password = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT).getBytes());
        return managerMapper.selectByAccountAndPassword(account, password);
    }

    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    @Override
    public User userLogin(String email, String password) {
        // password = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT + email).getBytes());
        password = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT).getBytes());
        System.out.println("password: " + password);
        return userMapper.selectByAccountAndPassword(email, password);
    }


    /**
     * 添加登录用户
     *
     * @param openid
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addWeixinLoginUser(String openid) {
        Integer userId = userMapper.selectWeixinUUid(openid);
        RegisterUser user = new RegisterUser();
        try {
            if (userId == null) {
                user.setUser_account(openid+"-WeiXin");
                userMapper.addUser(user);
                System.out.println(user.getUser_id());
                userMapper.addWeixinUUID(openid, user.getUser_id());
                return user.getUser_id();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
        return userId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addQQLoginUser(String openid) {
        RegisterUser user = new RegisterUser();
        Integer userId = userMapper.selectQQUUid(openid);
        try {
            if (userId == null) {
                user.setUser_account(openid+"-QQ");
                userMapper.addUser(user);
                System.out.println(user.getUser_id());
                userMapper.addQQUUID(openid, user.getUser_id());
                return user.getUser_id();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
        return userId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addWeiboLoginUser(String openid) {
        RegisterUser user = new RegisterUser();
        Integer userId = userMapper.selectWeiboUUid(openid);
        try {
            if (userId == null) {
                user.setUser_account(openid+"-WeiBo");
                userMapper.addUser(user);
                System.out.println(user.getUser_id());
                userMapper.addWeiboUUID(Long.parseLong(openid), user.getUser_id());
                return user.getUser_id();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
        return userId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RequestResult forgotPassword(String email, String code, String imgVerificationCode) {
        if (!code.equals(imgVerificationCode)) {
            return IncolorResultUtil.error("验证码错误");
        }
        User user = userMapper.selectByAccount(email);
        if (user == null) {
            return IncolorResultUtil.error("用户不存在");
        }
        // 产生 6 位随机验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        ForgotPasswordConfirm confirmUser = forgotPasswordConfirmMapper.selectByEmail(email);
        if (confirmUser != null) {
            forgotPasswordConfirmMapper.updateVerifyCodeByEmail(email, verifyCode);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("incolor_china@163.com");
            message.setTo(email);
            message.setSubject("主题：incolor 忘记密码验证");
            message.setText("邮箱验证码为： " + verifyCode);
            mailSender.send(message);
            // 后期修改为 gson 过滤属性
            HashMap<String, Object> map = new HashMap<>();
            map.put("email", email);
            map.put("times", confirmUser.getTimes() - 1);
            return IncolorResultUtil.success(map);
        }
        // 设置 30 分钟后过期
        Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);
        ForgotPasswordConfirm confirm = new ForgotPasswordConfirm();
        confirm.setEmail(email);
        confirm.setVerifyCode(verifyCode);
        // 设置最多 3 次
        confirm.setTimes(3);
        confirm.setCreateTime(new Date());
        confirm.setUpdateTime(outDate);
        forgotPasswordConfirmMapper.insert(confirm);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("incolor_china@163.com");
        message.setTo(email);
        message.setSubject("主题：incolor 忘记密码验证");
        message.setText("邮箱验证码为： " + verifyCode);
        mailSender.send(message);
        // 后期修改为 gson 过滤属性
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("times", confirm.getTimes());
        return IncolorResultUtil.success(map);
    }

    @Override
    public RequestResult forgotPasswordConfirm(String email, String verifyCode) {
        ForgotPasswordConfirm confirm = forgotPasswordConfirmMapper.selectByEmail(email);
        int times = confirm.getTimes();
        // 每天验证次数已用完
        if (times <= 0) {
            return IncolorResultUtil.error("每天验证次数已用完");
        }
        if (confirm.getStatus()) {
            return IncolorResultUtil.error("已完成验证");
        }
        // 是否过期
        if (confirm.getUpdateTime().getTime() <= System.currentTimeMillis()) {
            forgotPasswordConfirmMapper.updateTimes(email, times - 1);
            return IncolorResultUtil.error("链接已过期");
        }
        // 验证码是否正确
        if (!verifyCode.equals(confirm.getVerifyCode())) {
            forgotPasswordConfirmMapper.updateTimes(email, times - 1);
            return IncolorResultUtil.error("验证码不正确或已过期,请重新验证");
        }
        forgotPasswordConfirmMapper.updateStatus(email);
        return IncolorResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void forgotPasswordAddNewPassword(PasswordConfirm confirm) {
        try {
            if (!confirm.getNewPassword().equals(confirm.getConfirmPassword())) {
                throw new WrongInputException();
            }
            // HTML 转义
            String password = HtmlUtils.htmlEscape(confirm.getNewPassword());
            // md5 加密加盐，用户密码加上邮箱
            password = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT).getBytes());
            User user = userMapper.selectByAccount(confirm.getEmail());
            if (user == null) {
                // 数据库不存在当前用户
                throw new NoSuchUserException();
            }
            ForgotPasswordConfirm confirm1 = forgotPasswordConfirmMapper.selectByEmail(confirm.getEmail());
            if (confirm1 == null || !confirm1.getStatus()) {
                // 数据库不存在当前已认证用户，即当前用户并没有参与密码修改
                throw new NoSuchUserException();
            }
            userMapper.updatePassword(confirm.getEmail(), password);
        } catch (WrongInputException | DuplicateEmailException e) {
            // 抛出，触发事务
            throw e;
        } catch (Exception e) {
            // 转换成运行时异常
            throw new ServerInternalException(e.getMessage());
        }
    }
}
