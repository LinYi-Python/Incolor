package vip.incolor.entity;

import java.util.Date;

public class OrderPay {
    private Integer order_pay_id;

    private String order_pay_name;

    private Date order_pay_create_time;

    private Date order_pay_update_time;

    public Integer getOrder_pay_id() {
        return order_pay_id;
    }

    public void setOrder_pay_id(Integer order_pay_id) {
        this.order_pay_id = order_pay_id;
    }

    public String getOrder_pay_name() {
        return order_pay_name;
    }

    public void setOrder_pay_name(String order_pay_name) {
        this.order_pay_name = order_pay_name == null ? null : order_pay_name.trim();
    }

    public Date getOrder_pay_create_time() {
        return order_pay_create_time;
    }

    public void setOrder_pay_create_time(Date order_pay_create_time) {
        this.order_pay_create_time = order_pay_create_time;
    }

    public Date getOrder_pay_update_time() {
        return order_pay_update_time;
    }

    public void setOrder_pay_update_time(Date order_pay_update_time) {
        this.order_pay_update_time = order_pay_update_time;
    }
}