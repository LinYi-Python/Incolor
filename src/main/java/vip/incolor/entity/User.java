package vip.incolor.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private Integer user_id;

    private String user_account;

    private String user_password;

    private String user_phone;

    private String user_mail;

    private String user_family_name;

    private String user_given_name;

    private Boolean user_gender;

    private Boolean user_enable;

    private Boolean user_pass;

    private Timestamp out_dated_time;

    private Date user_create_time;

    private Date user_update_time;


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
        this.user_account = user_account == null ? null : user_account.trim();
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password == null ? null : user_password.trim();
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone == null ? null : user_phone.trim();
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail == null ? null : user_mail.trim();
    }

    public String getUser_family_name() {
        return user_family_name;
    }

    public void setUser_family_name(String user_family_name) {
        this.user_family_name = user_family_name == null ? null : user_family_name.trim();
    }

    public String getUser_given_name() {
        return user_given_name;
    }

    public void setUser_given_name(String user_given_name) {
        this.user_given_name = user_given_name == null ? null : user_given_name.trim();
    }

    public Boolean getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Boolean user_gender) {
        this.user_gender = user_gender;
    }

    public Boolean getUser_enable() {
        return user_enable;
    }

    public void setUser_enable(Boolean user_enable) {
        this.user_enable = user_enable;
    }

    public Boolean getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(Boolean user_pass) {
        this.user_pass = user_pass;
    }

    public Timestamp getOut_dated_time() {
        return out_dated_time;
    }

    public void setOut_dated_time(Timestamp out_dated_time) {
        this.out_dated_time = out_dated_time;
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

    public Date getUser_update_time() {
        return user_update_time;
    }

    public void setUser_update_time(Date user_update_time) {
        this.user_update_time = user_update_time;
    }
}
