package vip.incolor.dto;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/6/6
 * @time 21:32
 */
public class MicroOrderWrapper {
    private List<MicroOrder> microOrders;
    private Integer total;
    private Integer pages;

    public List<MicroOrder> getMicroOrders() {
        return microOrders;
    }

    public void setMicroOrders(List<MicroOrder> microOrders) {
        this.microOrders = microOrders;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
