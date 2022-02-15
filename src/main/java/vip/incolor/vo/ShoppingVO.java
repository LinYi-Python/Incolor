package vip.incolor.vo;

import java.util.Date;
import java.util.List;

/**
 * @author: JimLin
 * @description: 产品属性 vo
 * @email leafyunjim@gmail.com
 * @date: 2018-04-18
 * @time: 19:45
 */
public class ShoppingVO {

    /**
     * 产品
     */
    private ProductVO productVO;

    /**
     * 产品属性
     */
    private List<PropertyShoppingVO> propertyVOS;

    /**
     * 购物车创建时间
     */
    private Date created;

    public ShoppingVO() {
    }

    public ShoppingVO(ProductVO productVO, List<PropertyShoppingVO> propertyVOS, Date created) {
        this.productVO = productVO;
        this.propertyVOS = propertyVOS;
        this.created = created;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public List<PropertyShoppingVO> getPropertyVOS() {
        return propertyVOS;
    }

    public void setPropertyVOS(List<PropertyShoppingVO> propertyVOS) {
        this.propertyVOS = propertyVOS;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ShoppingVO{" +
                "productVO=" + productVO +
                ", propertyVOS=" + propertyVOS +
                ", created=" + created +
                '}';
    }
}
