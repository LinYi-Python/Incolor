package vip.incolor.entity;

import java.util.Date;

public class ShoppingPropertyValue {
    private Integer shopping_property_value_id;

    private String shopping_property_value;

    private Integer shopping_detail_id;

    private Integer shopping_property_id;

    private Date shopping_property_value_create_time;

    private Date shopping_property_value_update_time;

    public Integer getShopping_property_value_id() {
        return shopping_property_value_id;
    }

    public void setShopping_property_value_id(Integer shopping_property_value_id) {
        this.shopping_property_value_id = shopping_property_value_id;
    }

    public String getShopping_property_value() {
        return shopping_property_value;
    }

    public void setShopping_property_value(String shopping_property_value) {
        this.shopping_property_value = shopping_property_value == null ? null : shopping_property_value.trim();
    }

    public Integer getShopping_property_id() {
        return shopping_property_id;
    }

    public void setShopping_property_id(Integer shopping_property_id) {
        this.shopping_property_id = shopping_property_id;
    }

    public Date getShopping_property_value_create_time() {
        return shopping_property_value_create_time;
    }

    public void setShopping_property_value_create_time(Date shopping_property_value_create_time) {
        this.shopping_property_value_create_time = shopping_property_value_create_time;
    }

    public Date getShopping_property_value_update_time() {
        return shopping_property_value_update_time;
    }

    public void setShopping_property_value_update_time(Date shopping_property_value_update_time) {
        this.shopping_property_value_update_time = shopping_property_value_update_time;
    }

    public Integer getShopping_detail_id() {
        return shopping_detail_id;
    }

    public void setShopping_detail_id(Integer shopping_detail_id) {
        this.shopping_detail_id = shopping_detail_id;
    }
}