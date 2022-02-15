package vip.incolor.dto;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:53
 */
public class ManagerPropertyValue {

    private Integer propertyValueId;
    private Integer propertyId;
    private Integer productId;
    private String propertyValue;
    private Double propertyPrice;

    public ManagerPropertyValue(){

    }

    public ManagerPropertyValue(Integer propertyValueId, Integer propertyId, Integer productId, String propertyValue, Double propertyPrice){
        this.propertyValueId = propertyValueId;
        this.productId = productId;
        this.propertyId = propertyId;
        this.propertyValue = propertyValue;
        this.propertyPrice = propertyPrice;
    }

    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
}
