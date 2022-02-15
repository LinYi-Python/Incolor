package vip.incolor.dto;


import vip.incolor.entity.Classify;
import vip.incolor.entity.Product;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductStyle;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/8/10
 * @time 23:29
 */
public class ProductItem {
    private Classify classify;

    private Product product;

    private ProductStyle productStyle;

    private ProductPicture productPicture;

    public ProductItem() {
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductStyle getProductStyle() {
        return productStyle;
    }

    public void setProductStyle(ProductStyle productStyle) {
        this.productStyle = productStyle;
    }

    public ProductPicture getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(ProductPicture productPicture) {
        this.productPicture = productPicture;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "classify=" + classify +
                ", product=" + product +
                ", productStyle=" + productStyle +
                ", productPicture=" + productPicture +
                '}';
    }
}
