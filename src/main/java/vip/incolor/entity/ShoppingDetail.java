package vip.incolor.entity;

import java.util.Date;

public class ShoppingDetail {
    private Integer shopping_detail_id;

    private Integer shopping_property_id;

    private String shopping_property_name;

    private Integer shopping_id;

    private Date shopping_property_create_time;

    private Date shopping_property_update_time;

    public Integer getShopping_detail_id() {
        return shopping_detail_id;
    }

    public void setShopping_detail_id(Integer shopping_detail_id) {
        this.shopping_detail_id = shopping_detail_id;
    }

    public Integer getShopping_property_id() {
        return shopping_property_id;
    }

    public void setShopping_property_id(Integer shopping_property_id) {
        this.shopping_property_id = shopping_property_id;
    }

    public String getShopping_property_name() {
        return shopping_property_name;
    }

    public void setShopping_property_name(String shopping_property_name) {
        this.shopping_property_name = shopping_property_name == null ? null : shopping_property_name.trim();
    }

    public Integer getShopping_id() {
        return shopping_id;
    }

    public void setShopping_id(Integer shopping_id) {
        this.shopping_id = shopping_id;
    }

    public Date getShopping_property_create_time() {
        return shopping_property_create_time;
    }

    public void setShopping_property_create_time(Date shopping_property_create_time) {
        this.shopping_property_create_time = shopping_property_create_time;
    }

    public Date getShopping_property_update_time() {
        return shopping_property_update_time;
    }

    public void setShopping_property_update_time(Date shopping_property_update_time) {
        this.shopping_property_update_time = shopping_property_update_time;
    }
}