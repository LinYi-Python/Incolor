package vip.incolor.vo;

import java.util.List;

/**
 * @author: JimLin
 * @description: 产品图片 VO
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 18:39
 */
public class ProductPictureVO {
    /**
     * 产品图片编号
     */
    private Integer productPictureId;
    /**
     * 是否是缩略图：0 代表缩略图，1 代表详细图
     */
    private byte type;
    /**
     * 图片地址
     */
    private List<String> picturePaths;

    public ProductPictureVO() {
    }

    public ProductPictureVO(Integer productPictureId, byte type, List<String> picturePaths) {
        this.productPictureId = productPictureId;
        this.type = type;
        this.picturePaths = picturePaths;
    }

    public Integer getProductPictureId() {
        return productPictureId;
    }

    public void setProductPictureId(Integer productPictureId) {
        this.productPictureId = productPictureId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public List<String> getPicturePaths() {
        return picturePaths;
    }

    public void setPicturePaths(List<String> picturePaths) {
        this.picturePaths = picturePaths;
    }

    @Override
    public String toString() {
        return "ProductPictureVO{" +
                "productPictureId=" + productPictureId +
                ", type=" + type +
                ", picturePaths=" + picturePaths +
                '}';
    }
}
