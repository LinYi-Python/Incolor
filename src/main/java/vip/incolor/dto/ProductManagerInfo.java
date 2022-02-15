package vip.incolor.dto;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:27
 */
public class ProductManagerInfo {

    private ManagerClassify managerClassify;
    private ManagerProduct managerProduct;
    private ManagerProductPicture managerProductPicture;
    private ManagerProductStyle managerProductStyle;
    private ManagerProperty managerProperty;
    private ManagerPropertyValue managerPropertyValue;

    public ManagerClassify getManagerClassify() {
        return managerClassify;
    }

    public void setManagerClassify(ManagerClassify managerClassify) {
        this.managerClassify = managerClassify;
    }

    public ManagerProduct getManagerProduct() {
        return managerProduct;
    }

    public void setManagerProduct(ManagerProduct managerProduct) {
        this.managerProduct = managerProduct;
    }

    public ManagerProductPicture getManagerProductPicture() {
        return managerProductPicture;
    }

    public void setManagerProductPicture(ManagerProductPicture managerProductPicture) {
        this.managerProductPicture = managerProductPicture;
    }

    public ManagerProductStyle getManagerProductStyle() {
        return managerProductStyle;
    }

    public void setManagerProductStyle(ManagerProductStyle managerProductStyle) {
        this.managerProductStyle = managerProductStyle;
    }

    public ManagerProperty getManagerProperty() {
        return managerProperty;
    }

    public void setManagerProperty(ManagerProperty managerProperty) {
        this.managerProperty = managerProperty;
    }

    public ManagerPropertyValue getManagerPropertyValue() {
        return managerPropertyValue;
    }

    public void setManagerPropertyValue(ManagerPropertyValue managerPropertyValue) {
        this.managerPropertyValue = managerPropertyValue;
    }
}
