package vip.incolor.dto;

import java.util.HashMap;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/30
 * @time 14:02
 */
public class MainProductInfo {
    private String name;
    private int number;
    private List<HashMap<String,String>> value;
    private List<SubAttatchOrderInfo> attatchOrderInfos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<HashMap<String, String>> getValue() {
        return value;
    }

    public void setValue(List<HashMap<String, String>> value) {
        this.value = value;
    }

    public List<SubAttatchOrderInfo> getAttatchOrderInfos() {
        return attatchOrderInfos;
    }

    public void setAttatchOrderInfos(List<SubAttatchOrderInfo> attatchOrderInfos) {
        this.attatchOrderInfos = attatchOrderInfos;
    }
}
