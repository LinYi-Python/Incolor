package vip.incolor.entity;

import java.util.Date;

public class Classify {
    private Integer class_id;

    private String class_name;

    private Boolean is_parent;

    private Integer parent_id;

    private Date class_create_time;

    private Date class_update_time;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name == null ? null : class_name.trim();
    }

    public Boolean getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(Boolean is_parent) {
        this.is_parent = is_parent;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Date getClass_create_time() {
        return class_create_time;
    }

    public void setClass_create_time(Date class_create_time) {
        this.class_create_time = class_create_time;
    }

    public Date getClass_update_time() {
        return class_update_time;
    }

    public void setClass_update_time(Date class_update_time) {
        this.class_update_time = class_update_time;
    }
}