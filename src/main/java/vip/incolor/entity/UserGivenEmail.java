package vip.incolor.entity;

import java.util.Date;

public class UserGivenEmail {
    private Integer user_given_email_id;

    private String user_given_email;

    private Date user_given_email_create_time;

    private Date user_given_email_update_time;

    public Integer getUser_given_email_id() {
        return user_given_email_id;
    }

    public void setUser_given_email_id(Integer user_given_email_id) {
        this.user_given_email_id = user_given_email_id;
    }

    public String getUser_given_email() {
        return user_given_email;
    }

    public void setUser_given_email(String user_given_email) {
        this.user_given_email = user_given_email == null ? null : user_given_email.trim();
    }

    public Date getUser_given_email_create_time() {
        return user_given_email_create_time;
    }

    public void setUser_given_email_create_time(Date user_given_email_create_time) {
        this.user_given_email_create_time = user_given_email_create_time;
    }

    public Date getUser_given_email_update_time() {
        return user_given_email_update_time;
    }

    public void setUser_given_email_update_time(Date user_given_email_update_time) {
        this.user_given_email_update_time = user_given_email_update_time;
    }
}