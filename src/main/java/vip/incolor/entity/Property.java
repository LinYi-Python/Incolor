package vip.incolor.entity;

import java.util.Date;

public class Property {
    private Integer property_id;

    private String property_name;

    private Integer classify_id;

    private Date property_create_time;

    private Date property_update_time;

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name == null ? null : property_name.trim();
    }

    public Integer getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(Integer classify_id) {
        this.classify_id = classify_id;
    }

    public Date getProperty_create_time() {
        return property_create_time;
    }

    public void setProperty_create_time(Date property_create_time) {
        this.property_create_time = property_create_time;
    }

    public Date getProperty_update_time() {
        return property_update_time;
    }

    public void setProperty_update_time(Date property_update_time) {
        this.property_update_time = property_update_time;
    }
}