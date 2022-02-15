package vip.incolor.dto;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 21:30
 */
public class FrontOrder {
    private Integer orderId;
    private Integer shoppingId;
    private String imgPath;
    private String productName;
    private String detail;
    private int number;
    private double price;
    private String status;
    private String jumpUrl;
    private int type;
    private List<AttachInfo> attachInfos;
    private List<Integer> productIds;
    private List<Integer> shoppingIds;
    private String v;

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<Integer> getShoppingIds() {
        return shoppingIds;
    }

    public void setShoppingIds(List<Integer> shoppingIds) {
        this.shoppingIds = shoppingIds;
    }

    public int getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(int shoppingId) {
        this.shoppingId = shoppingId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<AttachInfo> getAttachInfos() {
        return attachInfos;
    }

    public void setAttachInfos(List<AttachInfo> attachInfos) {
        this.attachInfos = attachInfos;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }
}
