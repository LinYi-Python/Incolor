package vip.incolor.dto;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/30
 * @time 12:25
 */
public class MicroOrder {
    private int orderId;
    private boolean isPayed;
    private String status;
    private String time;
    private String receiver;
    private String expressNumber;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }
}
