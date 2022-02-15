package vip.incolor.dto;

import java.util.Date;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/29
 * @time 15:12
 */
public class ProductAndShopping {
    private Integer product_id;

    private String product_name;

    private Integer product_class_id;

    private Integer product_price;

    private Boolean product_marketable;

    private Integer product_attach_id;

    private Integer product_number;

    private Integer product_picture_id;

    private Date product_create_time;

    private Date product_update_time;

    private Integer product_classify_id;

    private Integer shooping_number;

    private Integer shopping_price;

    private Integer shopping_id;

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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_class_id() {
        return product_class_id;
    }

    public void setProduct_class_id(Integer product_class_id) {
        this.product_class_id = product_class_id;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Boolean getProduct_marketable() {
        return product_marketable;
    }

    public void setProduct_marketable(Boolean product_marketable) {
        this.product_marketable = product_marketable;
    }

    public Integer getProduct_attach_id() {
        return product_attach_id;
    }

    public void setProduct_attach_id(Integer product_attach_id) {
        this.product_attach_id = product_attach_id;
    }

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }

    public Integer getProduct_picture_id() {
        return product_picture_id;
    }

    public void setProduct_picture_id(Integer product_picture_id) {
        this.product_picture_id = product_picture_id;
    }

    public Date getProduct_create_time() {
        return product_create_time;
    }

    public void setProduct_create_time(Date product_create_time) {
        this.product_create_time = product_create_time;
    }

    public Date getProduct_update_time() {
        return product_update_time;
    }

    public void setProduct_update_time(Date product_update_time) {
        this.product_update_time = product_update_time;
    }

    public Integer getProduct_classify_id() {
        return product_classify_id;
    }

    public void setProduct_classify_id(Integer product_classify_id) {
        this.product_classify_id = product_classify_id;
    }

    public Integer getShooping_number() {
        return shooping_number;
    }

    public void setShooping_number(Integer shooping_number) {
        this.shooping_number = shooping_number;
    }

    public Integer getShopping_price() {
        return shopping_price;
    }

    public void setShopping_price(Integer shopping_price) {
        this.shopping_price = shopping_price;
    }
}
