package vip.incolor.vo;

import vip.incolor.entity.PropertyValue;

import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-04-18
 * @time: 19:56
 */
public class PropertyShoppingVO {
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
    private List<PropertyValue> propertyValues;
    /**
     * 产品编号
     */
    private Integer productId;

    public PropertyShoppingVO() {
    }

    public PropertyShoppingVO(Integer propertyId, String propertyName, List<PropertyValue> propertyValues, Integer productId) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.propertyValues = propertyValues;
        this.productId = productId;
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

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "PropertyShoppingVO{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyValues=" + propertyValues +
                ", productId=" + productId +
                '}';
    }
}
