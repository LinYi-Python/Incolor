package vip.incolor.dto;

import java.util.List;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:51
 */
public class ManagerProductStyle {
    /**
     * 产品类型ID
     */
    private Integer productStyleId;
    /**
     * 产品类型名称
     */
    private String productStyleName;
    /**
     * 上线是 1，下线是 0
     */
    private Boolean is_on_line;
    /**
     * 类目大图地址
     */
    private String  product_style_picture;



    public ManagerProductStyle(){

    }

    public ManagerProductStyle(Integer productStyleId, String productStyleName, Boolean is_on_line,String product_style_picture){
        this.productStyleId = productStyleId;
        this.productStyleName = productStyleName;
        this.is_on_line = is_on_line;
        this.product_style_picture = product_style_picture;
    }

    public Integer getProductStyleId() {
        return productStyleId;
    }

    public void setProductStyleId(Integer productStyleId) {
        this.productStyleId = productStyleId;
    }

    public String getProductStyleName() {
        return productStyleName;
    }

    public void setProductStyleName(String productStyleName) {
        this.productStyleName = productStyleName;
    }


    public Boolean getIs_on_line() {
        return is_on_line;
    }

    public void setIs_on_line(Boolean is_on_line) {
        this.is_on_line = is_on_line;
    }

    public String getProduct_style_picture() {
        return product_style_picture;
    }

    public void setProduct_style_picture(String product_style_picture) {
        this.product_style_picture = product_style_picture;
    }
}
