package vip.incolor.entity;

import java.util.Date;

public class OrderInformation {
    private Integer order_information_id;

    private Integer order_id;

    private Integer product_id;

    private Integer user_id;

    private Integer order_pay_id;

    private Integer order_expressway_id;

    private Integer order_number;

    private Date order_create_time;

    private Date order_update_time;

    public Integer getOrder_imformation_id() {
        return order_information_id;
    }

    public void setOrder_imformation_id(Integer order_imformation_id) {
        this.order_information_id = order_imformation_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getOrder_pay_id() {
        return order_pay_id;
    }

    public void setOrder_pay_id(Integer order_pay_id) {
        this.order_pay_id = order_pay_id;
    }

    public Integer getOrder_expressway_id() {
        return order_expressway_id;
    }

    public void setOrder_expressway_id(Integer order_expressway_id) {
        this.order_expressway_id = order_expressway_id;
    }

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public Date getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Date order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Date getOrder_update_time() {
        return order_update_time;
    }

    public void setOrder_update_time(Date order_update_time) {
        this.order_update_time = order_update_time;
    }
}