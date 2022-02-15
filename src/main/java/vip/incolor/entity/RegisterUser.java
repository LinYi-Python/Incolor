package vip.incolor.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description 注册用户类
 * @date 2018-03-18
 * @time 14:50
 */
public class RegisterUser {
    /**
     * 用户编号
     */
    private Integer user_id;

    /**
     * 用户账户：默认为邮箱
     */
    private String user_account;

    /**
     * 用户密码
     */
    @NotBlank(message = "{NotBlank.password}")
    @Pattern(regexp = "^\\w{8,16}$", message = "{Pattern.password}")
    private String user_password;
    /**
     * 用户确认密码
     */
    @NotBlank(message = "{NotBlank.confirmPassword}")
    private String confirmPassword;
    /**
     * 用户邮箱
     */
    @NotBlank(message = "{NotBlank.email}")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "{Pattern.email}")
    private String user_mail;
    /**
     * 用户姓氏
     */
    private String user_family_name;
    /**
     * 用户名字
     */
    private String user_given_name;
    /**
     * 用户称呼（先生，小姐）
     */
    private Boolean user_gender;

    /**
     * 设置什么时候过期
     */
    private Timestamp out_dated_time;

    public RegisterUser() {
    }

    public RegisterUser(Integer user_id, String user_account, String user_password, String confirmPassword, String user_mail, String user_family_name, String user_given_name, Boolean user_gender, Timestamp out_dated_time) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.confirmPassword = confirmPassword;
        this.user_mail = user_mail;
        this.user_family_name = user_family_name;
        this.user_given_name = user_given_name;
        this.user_gender = user_gender;
        this.out_dated_time = out_dated_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_family_name() {
        return user_family_name;
    }

    public void setUser_family_name(String user_family_name) {
        this.user_family_name = user_family_name;
    }

    public String getUser_given_name() {
        return user_given_name;
    }

    public void setUser_given_name(String user_given_name) {
        this.user_given_name = user_given_name;
    }

    public Boolean getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Boolean user_gender) {
        this.user_gender = user_gender;
    }

    public Timestamp getOut_dated_time() {
        return out_dated_time;
    }

    public void setOut_dated_time(Timestamp out_dated_time) {
        this.out_dated_time = out_dated_time;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", user_family_name='" + user_family_name + '\'' +
                ", user_given_name='" + user_given_name + '\'' +
                ", user_gender=" + user_gender +
                ", out_dated_time=" + out_dated_time +
                '}';
    }
}
