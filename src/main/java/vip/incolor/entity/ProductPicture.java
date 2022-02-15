package vip.incolor.entity;

import java.util.Date;

public class ProductPicture {
    private Integer product_picture_id;

    private Integer product_id;

    private Boolean product_picture_type;

    private String product_picture_path;

    private Date product_picture_create_time;

    private Date product_picture_update_time;

    public Integer getProduct_picture_id() {
        return product_picture_id;
    }

    public void setProduct_picture_id(Integer product_picture_id) {
        this.product_picture_id = product_picture_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Boolean getProduct_picture_type() {
        return product_picture_type;
    }

    public void setProduct_picture_type(Boolean product_picture_type) {
        this.product_picture_type = product_picture_type;
    }

    public String getProduct_picture_path() {
        return product_picture_path;
    }

    public void setProduct_picture_path(String product_picture_path) {
        this.product_picture_path = product_picture_path == null ? null : product_picture_path.trim();
    }

    public Date getProduct_picture_create_time() {
        return product_picture_create_time;
    }

    public void setProduct_picture_create_time(Date product_picture_create_time) {
        this.product_picture_create_time = product_picture_create_time;
    }

    public Date getProduct_picture_update_time() {
        return product_picture_update_time;
    }

    public void setProduct_picture_update_time(Date product_picture_update_time) {
        this.product_picture_update_time = product_picture_update_time;
    }
}