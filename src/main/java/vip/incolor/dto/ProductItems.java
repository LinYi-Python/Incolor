package vip.incolor.dto;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/8/29
 * @time 0:01
 */
public class ProductItems {
    private Integer class_id;

    private String class_name;

    private Integer product_id;

    private String product_size;

    private String product_name;

    private Integer product_number;

    private Boolean product_is_new;

    private String product_tag;

    private Integer product_style_id;

    private String product_style_name;

    private Boolean product_marketable;

    private Integer product_picture_id;

    private String product_picture_path;

    private Integer product_attach_id;

    private Double product_price;

    private String product_estimate_price;

    private Integer product_estimate_deliver_time;

    public Integer getProduct_attach_id() {
        return product_attach_id;
    }

    public void setProduct_attach_id(Integer product_attach_id) {
        this.product_attach_id = product_attach_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }

    public Boolean getProduct_is_new() {
        return product_is_new;
    }

    public void setProduct_is_new(Boolean product_is_new) {
        this.product_is_new = product_is_new;
    }

    public Integer getProduct_style_id() {
        return product_style_id;
    }

    public void setProduct_style_id(Integer product_style_id) {
        this.product_style_id = product_style_id;
    }

    public String getProduct_style_name() {
        return product_style_name;
    }

    public void setProduct_style_name(String product_style_name) {
        this.product_style_name = product_style_name;
    }

    public String getProduct_tag() {
        return product_tag;
    }

    public void setProduct_tag(String product_tag) {
        this.product_tag = product_tag;
    }

    public Boolean getProduct_marketable() {
        return product_marketable;
    }

    public void setProduct_marketable(Boolean product_marketable) {
        this.product_marketable = product_marketable;
    }

    public Integer getProduct_picture_id() {
        return product_picture_id;
    }

    public void setProduct_picture_id(Integer product_picture_id) {
        this.product_picture_id = product_picture_id;
    }

    public String getProduct_picture_path() {
        return product_picture_path;
    }

    public void setProduct_picture_path(String product_picture_path) {
        this.product_picture_path = product_picture_path;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_estimate_price() {
        return product_estimate_price;
    }

    public void setProduct_estimate_price(String product_estimate_price) {
        this.product_estimate_price = product_estimate_price;
    }

    public Integer getProduct_estimate_deliver_time() {
        return product_estimate_deliver_time;
    }

    public void setProduct_estimate_deliver_time(Integer product_estimate_deliver_time) {
        this.product_estimate_deliver_time = product_estimate_deliver_time;
    }

    @Override
    public String toString() {
        return "ProductItems{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", product_id=" + product_id +
                ", product_size='" + product_size + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_number=" + product_number +
                ", product_is_new=" + product_is_new +
                ", product_tag='" + product_tag + '\'' +
                ", product_style_id=" + product_style_id +
                ", product_style_name='" + product_style_name + '\'' +
                ", product_marketable=" + product_marketable +
                ", product_picture_id=" + product_picture_id +
                ", product_picture_path='" + product_picture_path + '\'' +
                ", product_attach_id=" + product_attach_id +
                ", product_price=" + product_price +
                ", product_estimate_price='" + product_estimate_price + '\'' +
                ", product_estimate_deliver_time=" + product_estimate_deliver_time +
                '}';
    }
}
