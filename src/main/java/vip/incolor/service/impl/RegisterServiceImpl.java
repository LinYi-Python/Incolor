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
import vip.incolor.entity.RegisterUser;
import vip.incolor.entity.User;
import vip.incolor.entity.UserGivenEmail;
import vip.incolor.entity.UserGivenEmailExample;
import vip.incolor.exception.DuplicateEmailException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.UserGivenEmailMapper;
import vip.incolor.mapper.UserMapper;
import vip.incolor.service.RegisterService;
import vip.incolor.utils.GsonUtil;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 用户注册接口实现类
 * @date 2018-03-18
 * @time 14:26
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private JavaMailSender mailSender;
    @Resource
    private UserGivenEmailMapper userGivenEmailMapper;

    /**
     * k
     *
     * @param user    表单内容对象
     * @param request http 请求
     * @throws WrongInputException     表单填写出错
     * @throws DuplicateEmailException 重复邮箱报错
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterUser user, HttpServletRequest request, String gender, String isSignUp) throws WrongInputException, DuplicateEmailException, ServerInternalException {
        try {
            if (!user.getUser_password().equals(user.getConfirmPassword())) {
                throw new WrongInputException();
            }
            // HTML 转义
            String familyName = user.getUser_family_name();
            String name = user.getUser_given_name();
            familyName = HtmlUtils.htmlEscape(familyName);
            name = HtmlUtils.htmlEscape(name);
            user.setUser_family_name(familyName);
            user.setUser_given_name(name);
            // 设置用户账户
            user.setUser_account(user.getUser_mail());
            // md5 加密加盐，用户密码加上邮箱
            user.setUser_password(DigestUtils.md5DigestAsHex((user.getUser_password() + Constants.STATIC_SALT).getBytes()));
            // 设置性别
            if (gender != null && gender.equals("1")) {
                user.setUser_gender(true);
            }
            if (gender != null && gender.equals("0")) {
                user.setUser_gender(false);
            }
            // 设置 30 分钟后过期
            Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);
            //设置注册日期和什么时候过期
            user.setOut_dated_time(outDate);
            User user1 = userMapper.selectByAccount(user.getUser_account());
            if (user1 != null) {
                // 数据库存在重复邮箱
                throw new DuplicateEmailException();
            }
            // 数据库添加用户
            userMapper.addUser(user);
            // 设置密钥,邮箱加上 "$" ，再加上此时的毫秒数和密码
            String secretKey = user.getUser_mail() + "$" + Constants.STATIC_SALT + "$" + user.getUser_password();
            // 产生数字签名
            String digitalSignature = DigestUtils.md5DigestAsHex(secretKey.getBytes());
            System.out.println("digitalSignature: " + digitalSignature);
            // 可以返回当前页面所在的应用的名字;
            MimeMessage message = mailSender.createMimeMessage();
            // 创建邮箱发送邮件对象
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            StringBuilder sb = new StringBuilder();
            sb.append("<p style='text-align:left'>请勿回复本邮件.点击下面的链接,验证邮箱</p>")
                    .append("<a href=http://www.incolor.vip/incolor/html/login-manage.html?" + "sid=")
                    .append(digitalSignature).append("&email=")
                    .append(user.getUser_mail())
                    .append(" target='_BLANK'>点击我验证邮箱</a>")
                    .append("<br/><br/><p>tips:本邮件超过30分钟,链接将会失效，需要重新申请邮箱验证</p>");
            helper.setFrom("incolor_china@163.com");
            helper.setTo(user.getUser_mail());
            helper.setSubject("incolor：邮箱验证");
            helper.setText(sb.toString(), true);
            mailSender.send(message);
            UserGivenEmail email = userGivenEmailMapper.selectByEmail(user.getUser_mail());
            // 订阅邮件
            if (isSignUp.equals("1") && email == null) {
                UserGivenEmail record = new UserGivenEmail();
                record.setUser_given_email(user.getUser_mail());
                userGivenEmailMapper.insert(record);
            }
        } catch (WrongInputException | DuplicateEmailException e) {
            // 抛出，触发事务
            throw e;
        } catch (Exception e) {
            // 转换成运行时异常
            throw new ServerInternalException(e.getMessage());
        }
    }

    /**
     * 验证邮箱
     *
     * @param sid   数字签名
     * @param email 邮箱
     * @return
     */
    @Override
    public String emailConfirm(String sid, String email) {
        // 数据库找出用户
        User user = userMapper.findUserByEmail(email);
        System.out.println("user2: " + user);
        if (user == null) {
            return GsonUtil.getErrorJson("no match user");
        }
        Timestamp outDate = user.getOut_dated_time();
        System.out.println(outDate.getTime() + "date: " + outDate);
        // 表示已经过期
        if (outDate.getTime() <= System.currentTimeMillis()) {
            return GsonUtil.getErrorJson("link is outdated");
        }
        // System.out.println("date   " + outDate.getTime() / 1000 * 1000 + "       date   ");
        // 数字签名
        String key = user.getUser_mail() + "$" + Constants.STATIC_SALT + "$" + user.getUser_password();
        String digitalSignature = DigestUtils.md5DigestAsHex(key.getBytes());
        if (!digitalSignature.equals(sid)) {
            return GsonUtil.getErrorJson("link is outdated,please register again");
        }
        // 修改数据库字段，表示已验证
        int i = userMapper.updateStatus(email);
        if (i < 0) {
            return GsonUtil.getErrorJson("update error");
        }
        return GsonUtil.getSuccessJson();
    }
}
