package vip.incolor.entity;

import java.util.Date;

public class PropertyValue {
    private Integer property_value_id;

    private Integer property_id;

    private Integer product_id;

    private String property_value;

    private Double property_price;

    private Date property_value_create_time;

    private Date property_value_update_time;

    public Integer getProperty_value_id() {
        return property_value_id;
    }

    public void setProperty_value_id(Integer property_value_id) {
        this.property_value_id = property_value_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProperty_value() {
        return property_value;
    }

    public void setProperty_value(String property_value) {
        this.property_value = property_value == null ? null : property_value.trim();
    }

    public Date getProperty_value_create_time() {
        return property_value_create_time;
    }

    public void setProperty_value_create_time(Date property_value_create_time) {
        this.property_value_create_time = property_value_create_time;
    }

    public Date getProperty_value_update_time() {
        return property_value_update_time;
    }

    public void setProperty_value_update_time(Date property_value_update_time) {
        this.property_value_update_time = property_value_update_time;
    }

    public Double getProperty_price() {
        return property_price;
    }
    public void setProperty_price(Double property_price) {
        this.property_price = property_price;
    }

}