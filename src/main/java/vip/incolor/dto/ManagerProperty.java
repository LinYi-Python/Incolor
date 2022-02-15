package vip.incolor.dto;

import vip.incolor.entity.Manager;
import vip.incolor.entity.ProductPicture;

import java.util.List;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:52
 */
public class ManagerProperty {


    /**
     * 产品 ID
     */
    private Integer propertyId;

    /**
     * 产品名称
     */
    private String propertyName;

    /**
     * 产品类型 ID
     */
    private Integer classifId;





    public ManagerProperty(){
    }

    public ManagerProperty(Integer propertyId, String propertyName, Integer classifId){
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.classifId = classifId;

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

    public Integer getClassifId() {
        return classifId;
    }

    public void setClassifId(Integer classifId) {
        this.classifId = classifId;
    }
}
