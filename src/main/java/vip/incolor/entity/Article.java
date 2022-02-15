package vip.incolor.entity;

import java.util.Date;

public class Article {
    private Integer article_id;

    private String article_label;

    private String article_desc;

    private String article_title;

    private String article_picture;

    private Date article_create_time;

    private Date article_update_time;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_label() {
        return article_label;
    }

    public void setArticle_label(String article_label) {
        this.article_label = article_label;
    }

    public String getArticle_desc() {
        return article_desc;
    }

    public void setArticle_desc(String article_desc) {
        this.article_desc = article_desc;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_picture() {
        return article_picture;
    }

    public void setArticle_picture(String article_picture) {
        this.article_picture = article_picture;
    }

    public Date getArticle_create_time() {
        return article_create_time;
    }

    public void setArticle_create_time(Date article_create_time) {
        this.article_create_time = article_create_time;
    }

    public Date getArticle_update_time() {
        return article_update_time;
    }

    public void setArticle_update_time(Date article_update_time) {
        this.article_update_time = article_update_time;
    }
}