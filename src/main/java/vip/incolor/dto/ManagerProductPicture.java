package vip.incolor.dto;

import java.util.List;
/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description:产品图片dto
 * @date 2018/5/9
 * @time 22:50
 */
public class ManagerProductPicture {
    /**
     * 产品图片编号
     */
    private Integer productPictureId;

    /**
     *是否是缩略图：0 代表缩略图，1 代表详细图
     */
    private Boolean type;
    /**
     * 图片地址
     */
    private String  picturePath;

    public ManagerProductPicture(){

    }
    public ManagerProductPicture(Integer productPictureId, Boolean type, String  picturePath){
        this.productPictureId = productPictureId;
        this.type = type;
        this.picturePath = picturePath;
    }

    public Integer getProductPictureId() {
        return productPictureId;
    }

    public void setProductPictureId(Integer productPictureId) {
        this.productPictureId = productPictureId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "ManagerProductPicture{" +
                "productPictureId=" + productPictureId +
                ", type=" + type +
                ", picturePaths=" + picturePath +
                '}';
    }
}
