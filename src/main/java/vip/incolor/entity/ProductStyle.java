package vip.incolor.entity;

import java.util.Date;

public class ProductStyle {
    private Integer product_style_id;

    private String product_style_name;

    private Boolean is_parent;

    private Boolean is_on_line;

    private Integer parent_id;

    private Integer version;

    private String product_style_picture;

    private Date product_style_create_time;

    private Date product_style_update_time;

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
        this.product_style_name = product_style_name == null ? null : product_style_name.trim();
    }

    public Boolean getIs_on_line() {
        return is_on_line;
    }

    public void setIs_on_line(Boolean is_on_line) {
        this.is_on_line = is_on_line;
    }

    public Boolean getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(Boolean is_parent) {
        this.is_parent = is_parent;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProduct_style_picture() {
        return product_style_picture;
    }

    public void setProduct_style_picture(String product_style_picture) {
        this.product_style_picture = product_style_picture;
    }

    public Date getProduct_style_create_time() {
        return product_style_create_time;
    }

    public void setProduct_style_create_time(Date product_style_create_time) {
        this.product_style_create_time = product_style_create_time;
    }

    public Date getProduct_style_update_time() {
        return product_style_update_time;
    }

    public void setProduct_style_update_time(Date product_style_update_time) {
        this.product_style_update_time = product_style_update_time;
    }

}
