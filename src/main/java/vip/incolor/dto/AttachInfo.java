package vip.incolor.dto;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/27
 * @time 22:28
 */
public class AttachInfo {
    private int type;
    private String params;
    private int number;
    private double price;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
