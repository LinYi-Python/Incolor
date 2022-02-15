package vip.incolor.entity;

import java.util.Date;

public class Manager {
    private Integer manager_id;

    private String manager_account;

    private String manager_password;

    private Byte manager_level;

    private Date manager_create_time;

    private Date manager_update_time;

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_account() {
        return manager_account;
    }

    public void setManager_account(String manager_account) {
        this.manager_account = manager_account == null ? null : manager_account.trim();
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password == null ? null : manager_password.trim();
    }

    public Byte getManager_level() {
        return manager_level;
    }

    public void setManager_level(Byte manager_level) {
        this.manager_level = manager_level;
    }

    public Date getManager_create_time() {
        return manager_create_time;
    }

    public void setManager_create_time(Date manager_create_time) {
        this.manager_create_time = manager_create_time;
    }

    public Date getManager_update_time() {
        return manager_update_time;
    }

    public void setManager_update_time(Date manager_update_time) {
        this.manager_update_time = manager_update_time;
    }
}