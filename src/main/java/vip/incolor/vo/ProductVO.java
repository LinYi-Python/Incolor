package vip.incolor.vo;

import vip.incolor.entity.ProductPicture;

import java.util.Date;

/**
 * @author: JimLin
 * @description: 产品展现到页面表单
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 16:53
 */
public class ProductVO {
    /**
     * 配件分类名称
     */
    private String productType;
    /**
     * 产品尺码表
     */
    private String productSize;
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
     * 商品预估价格区间
     */
    private String productEstimatePrice;

    /**
     * 商品数量
     */
    private Integer productNumber;

    /**
     * 是否为配件，配件则附上所属产品的 id,不为配件直接写 0
     */
    private Integer productAttachId;

    /**
     * 商品图片
     */
    private ProductPicture picture;

    /**
     * 表记录创建时间
     */
    private Date createTime;

    public ProductVO() {
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
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

    public String getProductEstimatePrice() {
        return productEstimatePrice;
    }

    public void setProductEstimatePrice(String productEstimatePrice) {
        this.productEstimatePrice = productEstimatePrice;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getProductAttachId() {
        return productAttachId;
    }

    public void setProductAttachId(Integer productAttachId) {
        this.productAttachId = productAttachId;
    }

    public ProductPicture getPicture() {
        return picture;
    }

    public void setPicture(ProductPicture picture) {
        this.picture = picture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "productType='" + productType + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productClassId=" + productClassId +
                ", productPrice=" + productPrice +
                ", productEstimatePrice='" + productEstimatePrice + '\'' +
                ", productNumber=" + productNumber +
                ", productAttachId=" + productAttachId +
                ", picture=" + picture +
                ", createTime=" + createTime +
                '}';
    }
}
