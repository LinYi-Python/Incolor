package vip.incolor.vo;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-04-18
 * @time: 19:56
 */
public class PropertyVO {
    /**
     * 购物车详细信息编号
     */
    private Integer shoppingDetailId;
    /**
     * 产品属性编号
     */
    private Integer propertyId;
    /**
     * 产品属性名字
     */
    private String propertyName;
    /**
     * 产品属性值
     */
    private Integer propertyValueId;
    /**
     * 产品属性值
     */
    private String propertyValue;
    /**
     * 属性价格
     */
    private Double propertyPrice;
    /**
     * 产品编号
     */
    private Integer productId;
    /**
     * 购物车编号
     */
    private Integer shoppingId;

    public PropertyVO() {
    }

    public Integer getShoppingDetailId() {
        return shoppingDetailId;
    }

    public void setShoppingDetailId(Integer shoppingDetailId) {
        this.shoppingDetailId = shoppingDetailId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    @Override
    public String toString() {
        return "PropertyVO{" +
                "shoppingDetailId=" + shoppingDetailId +
                ", propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyValueId='" + propertyValueId + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                ", propertyPrice=" + propertyPrice +
                ", productId=" + productId +
                ", shoppingId=" + shoppingId +
                '}';
    }
}
