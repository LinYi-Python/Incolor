package vip.incolor.dto;


import java.util.List;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:48
 */
public class ManagerProduct {
    /**
     * 产品ID
     */
    private Integer productId;
    /**
     * 尺码表
     */
    private String productSize;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private Double productPrice;
    /**
     * 价格区间
     */
    private String productEstimatePrice;
    /**
     * 产品预计发货天数
     */
    private Integer productDeliverTime;
    /**
     * 1 为可销售，0 为不可销售
     */
    private Boolean productMarketable;
    /**
     * 是否为配件，配件则附上所属产品的 id,不为配件直接写 0
     */
    private Integer productAttachId;
    /**
     * 商品数量
     */
    private Integer productNumber;
    /**
     * 产品是否为新品，如果为新品则为1，不是新品则为0
     */
    private Boolean productIsNew;

    public ManagerProduct(){

    }

    public ManagerProduct(Integer productId, String productSize, String productName, Double productPrice,String productEstimatePrice, Integer productDeliverTime, Boolean productMarketable, Integer productAttachId, Integer productNumber,Boolean productIsNew){
        this.productId = productId;
        this.productSize = productSize;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productEstimatePrice = productEstimatePrice;
        this.productDeliverTime = productDeliverTime;
        this.productMarketable = productMarketable;
        this.productAttachId = productAttachId;
        this.productNumber = productNumber;
        this.productIsNew = productIsNew;

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }


    public Boolean getProductMarketable() {
        return productMarketable;
    }

    public void setProductMarketable(Boolean productMakrtable) {
        this.productMarketable = productMarketable;
    }

    public Integer getProductAttachId() {
        return productAttachId;
    }

    public void setProductAttachId(Integer productAttachId) {
        this.productAttachId = productAttachId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductEstimatePrice() {
        return productEstimatePrice;
    }

    public void setProductEstimatePrice(String productEstimatePrice) {
        this.productEstimatePrice = productEstimatePrice;
    }

    public Integer getProductDeliverTime() {
        return productDeliverTime;
    }

    public void setProductDeliverTime(Integer productDeliverTime) {
        this.productDeliverTime = productDeliverTime;
    }

    public Boolean getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Boolean productIsNew) {
        this.productIsNew = productIsNew;
    }
}
