package vip.incolor.entity;

import java.util.Date;

public class OrderExpressway {
    private Integer order_expressway_id;

    private String order_expressway_name;

    private Date order_expressway_create_time;

    private Date order_expressway_update_time;

    public Integer getOrder_expressway_id() {
        return order_expressway_id;
    }

    public void setOrder_expressway_id(Integer order_expressway_id) {
        this.order_expressway_id = order_expressway_id;
    }

    public String getOrder_expressway_name() {
        return order_expressway_name;
    }

    public void setOrder_expressway_name(String order_expressway_name) {
        this.order_expressway_name = order_expressway_name == null ? null : order_expressway_name.trim();
    }

    public Date getOrder_expressway_create_time() {
        return order_expressway_create_time;
    }

    public void setOrder_expressway_create_time(Date order_expressway_create_time) {
        this.order_expressway_create_time = order_expressway_create_time;
    }

    public Date getOrder_expressway_update_time() {
        return order_expressway_update_time;
    }

    public void setOrder_expressway_update_time(Date order_expressway_update_time) {
        this.order_expressway_update_time = order_expressway_update_time;
    }
}