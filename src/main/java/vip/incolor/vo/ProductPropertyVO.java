package vip.incolor.vo;

import vip.incolor.entity.ProductPicture;

import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-04
 * @time: 21:03
 */
public class ProductPropertyVO {

    /**
     * 配件分类名称
     */
    private String productType;
    /**
     * 产品 ID
     */
    private Integer productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品类型 ID
     */
    private Integer productClassId;

    /**
     * 商品价格
     */
    private Double productPrice;

    /**
     * 商品数量
     */
    private Integer productNumber;

    /**
     * 商品图片
     */
    private ProductPicture picture;

    /**
     * 商品属性
     */
    private List<PropertyVO> properties;

    public ProductPropertyVO() {
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public ProductPicture getPicture() {
        return picture;
    }

    public void setPicture(ProductPicture picture) {
        this.picture = picture;
    }

    public List<PropertyVO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyVO> properties) {
        this.properties = properties;
    }
}
