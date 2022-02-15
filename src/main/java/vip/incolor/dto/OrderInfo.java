//package vip.incolor.dto;
//
//import java.util.List;
//
///**
// * @author LiYizhan
// * @email 1062585732@qq.com
// * @description
// * @date 2018/4/30
// * @time 12:50
// */
//public class OrderInfo {
//    //以下是基本信息
//    private int orderId;
//    private String buyer;
//    private String receiver;
//    private String phone;
//    private String address;
//    private int postalCode;
//    private boolean isPayed;
//    private boolean isNeedInvoices;
//    private boolean isCompanyType;
//    private String status;
//    private String createTime;
//    private String payTime;
//    //获取支付方式
//    private int payId;
//    //以下为产品信息
//    private List<MainProductInfo> mainProductInfos;
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(String buyer) {
//        this.buyer = buyer;
//    }
//
//    public String getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(String receiver) {
//        this.receiver = receiver;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public int getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(int postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public boolean isPayed() {
//        return isPayed;
//    }
//
//    public void setPayed(boolean payed) {
//        isPayed = payed;
//    }
//
//    public boolean isNeedInvoices() {
//        return isNeedInvoices;
//    }
//
//    public void setNeedInvoices(boolean needInvoices) {
//        isNeedInvoices = needInvoices;
//    }
//
//    public boolean isCompanyType() {
//        return isCompanyType;
//    }
//
//    public void setCompanyType(boolean companyType) {
//        isCompanyType = companyType;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getPayTime() {
//        return payTime;
//    }
//
//    public void setPayTime(String payTime) {
//        this.payTime = payTime;
//    }
//
//    public List<MainProductInfo> getMainProductInfos() {
//        return mainProductInfos;
//    }
//
//    public void setMainProductInfos(List<MainProductInfo> mainProductInfos) {
//        this.mainProductInfos = mainProductInfos;
//    }
//
//    public int getPayId() {
//        return payId;
//    }
//
//    public void setPayId(int payId) {
//        this.payId = payId;
//    }
//}

package vip.incolor.dto;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/30
 * @time 12:50
 */
public class OrderInfo {
    //以下是基本信息
    private int orderId;
    private String buyer;
    private String receiver;
    private String phone;
    private String address;
    private int postalCode;
    private boolean isPayed;
    private boolean isNeedInvoices;
    private boolean isCompanyType;
    private String status;
    private String createTime;
    private String payTime;
    private String invoicesName;
    private String invoicesCode;
    //获取支付方式
    private int payId;
    //以下为产品信息
    private List<MainProductInfo> mainProductInfos;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean isNeedInvoices() {
        return isNeedInvoices;
    }

    public void setNeedInvoices(boolean needInvoices) {
        isNeedInvoices = needInvoices;
    }

    public boolean isCompanyType() {
        return isCompanyType;
    }

    public void setCompanyType(boolean companyType) {
        isCompanyType = companyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public List<MainProductInfo> getMainProductInfos() {
        return mainProductInfos;
    }

    public void setMainProductInfos(List<MainProductInfo> mainProductInfos) {
        this.mainProductInfos = mainProductInfos;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getInvoicesName() {
        return invoicesName;
    }

    public void setInvoicesName(String invoicesName) {
        this.invoicesName = invoicesName;
    }

    public String getInvoicesCode() {
        return invoicesCode;
    }

    public void setInvoicesCode(String invoicesCode) {
        this.invoicesCode = invoicesCode;
    }
}
