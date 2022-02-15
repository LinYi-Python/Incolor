package vip.incolor.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Shopping {
    private Integer shopping_id;
    @NotNull(message = "{NotNull.productId}")
    private Integer product_id;

    private Integer user_id;

    private Boolean is_payed;

    private Integer shopping_number;
    //@NotNull(message = "{NotNull.shoppingPrice}")
    private Double shopping_price;

    private Date shopping_create_time;

    private Date shopping_update_time;

    private Integer order_id;

    public Integer getShopping_id() {
        return shopping_id;
    }

    public void setShopping_id(Integer shopping_id) {
        this.shopping_id = shopping_id;
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

    public Boolean getIs_payed() {
        return is_payed;
    }

    public void setIs_payed(Boolean is_payed) {
        this.is_payed = is_payed;
    }

    public Integer getShopping_number() {
        return shopping_number;
    }

    public void setShopping_number(Integer shopping_number) {
        this.shopping_number = shopping_number;
    }

    public Double getShopping_price() {
        return shopping_price;
    }

    public void setShopping_price(Double shopping_price) {
        this.shopping_price = shopping_price;
    }

    public Date getShopping_create_time() {
        return shopping_create_time;
    }

    public void setShopping_create_time(Date shopping_create_time) {
        this.shopping_create_time = shopping_create_time;
    }

    public Date getShopping_update_time() {
        return shopping_update_time;
    }

    public void setShopping_update_time(Date shopping_update_time) {
        this.shopping_update_time = shopping_update_time;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
}
