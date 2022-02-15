package vip.incolor.vo;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-04
 * @time: 19:58
 */
public class ShoppingCartVO {

    /**
     * 购物编号
     */
    private Integer shoppingId;
    /**
     * 产品
     */
    private ProductVO productVO;
    /**
     * 商品购买数量
     */
    private Integer shoppingNumber;
    /**
     * 商品价格（单价）
     */
    private Double shoppingPrice;

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public Integer getShoppingNumber() {
        return shoppingNumber;
    }

    public void setShoppingNumber(Integer shoppingNumber) {
        this.shoppingNumber = shoppingNumber;
    }

    public Double getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(Double shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCartVO{" +
                "shoppingId=" + shoppingId +
                ", productVO=" + productVO +
                ", shoppingNumber=" + shoppingNumber +
                ", shoppingPrice=" + shoppingPrice +
                '}';
    }
}
