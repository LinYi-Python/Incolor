package vip.incolor.entity;

import java.util.Date;

public class MyOrderDetail {
    private Integer order_detail_id;

    private Integer order_id;

    private Integer product_id;

    private Date order_create_time;

    private Date order_update_time;

    private Integer number;

    public Integer getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Integer order_detail_id) {
        this.order_detail_id = order_detail_id;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}