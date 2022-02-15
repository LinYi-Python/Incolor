package vip.incolor.entity;

import java.util.Date;

public class Carousel {
    private Integer carousel_id;

    private Boolean carousel_style;

    private String carousel_path;

    private Date carousel_create_time;

    private Date carousel_update_time;

    public Integer getCarousel_id() {
        return carousel_id;
    }

    public void setCarousel_id(Integer carousel_id) {
        this.carousel_id = carousel_id;
    }

    public Boolean getCarousel_style() {
        return carousel_style;
    }

    public void setCarousel_style(Boolean carousel_style) {
        this.carousel_style = carousel_style;
    }

    public String getCarousel_path() {
        return carousel_path;
    }

    public void setCarousel_path(String carousel_path) {
        this.carousel_path = carousel_path == null ? null : carousel_path.trim();
    }

    public Date getCarousel_create_time() {
        return carousel_create_time;
    }

    public void setCarousel_create_time(Date carousel_create_time) {
        this.carousel_create_time = carousel_create_time;
    }

    public Date getCarousel_update_time() {
        return carousel_update_time;
    }

    public void setCarousel_update_time(Date carousel_update_time) {
        this.carousel_update_time = carousel_update_time;
    }
}