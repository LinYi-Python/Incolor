package vip.incolor.entity;

public class UserKey {
    private Integer user_id;

    private String user_mail;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail == null ? null : user_mail.trim();
    }
}