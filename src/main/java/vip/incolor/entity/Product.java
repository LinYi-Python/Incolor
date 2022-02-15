package vip.incolor.entity;

import java.util.Date;

public class Product {
    private Integer product_id;

    private String product_size;

    private String product_name;

    private Integer product_class_id;

    private Double product_price;

    private String product_estimate_price;

    private Integer product_estimate_deliver_time;

    private Boolean product_marketable;

    private Integer product_attach_id;

    private Integer product_number;

    private Integer product_picture_id;

    private Date product_create_time;

    private Date product_update_time;

    private Integer product_classify_id;

    private Boolean product_is_new;

    private String product_tag;

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
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public Integer getProduct_class_id() {
        return product_class_id;
    }

    public void setProduct_class_id(Integer product_class_id) {
        this.product_class_id = product_class_id;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
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

    public String getProduct_size() {
        return product_size;
    }


    public String getProduct_estimate_price() {
        return product_estimate_price;
    }

    public void setProduct_estimate_price(String product_estimate_price) {
        this.product_estimate_price = product_estimate_price;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public Integer getProduct_estimate_deliver_time() {
        return product_estimate_deliver_time;
    }

    public void setProduct_estimate_deliver_time(Integer product_estimate_deliver_time) {
        this.product_estimate_deliver_time = product_estimate_deliver_time;
    }

    public Boolean getProduct_is_new() {
        return product_is_new;
    }

    public void setProduct_is_new(Boolean product_is_new) {
        this.product_is_new = product_is_new;
    }

    public String getProduct_tag() {
        return product_tag;
    }

    public void setProduct_tag(String product_tag) {
        this.product_tag = product_tag;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_size='" + product_size + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_class_id=" + product_class_id +
                ", product_price=" + product_price +
                ", product_estimate_price='" + product_estimate_price + '\'' +
                ", product_estimate_deliver_time=" + product_estimate_deliver_time +
                ", product_marketable=" + product_marketable +
                ", product_attach_id=" + product_attach_id +
                ", product_number=" + product_number +
                ", product_picture_id=" + product_picture_id +
                ", product_create_time=" + product_create_time +
                ", product_update_time=" + product_update_time +
                ", product_classify_id=" + product_classify_id +
                ", product_is_new=" + product_is_new +
                ", product_tag='" + product_tag + '\'' +
                '}';
    }
}