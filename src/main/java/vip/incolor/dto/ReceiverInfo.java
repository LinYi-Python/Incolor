package vip.incolor.dto;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 前端根据userId查询得到的信息，显示一个预生成的确认订单信息，然后用户修改后再提交改动过的PreOrder信息
 * @date 2018/4/15
 * @time 10:27
 */
public class ReceiverInfo {
    private String name;
    private String phone;
    private String address;
    private String postalCode;
    private boolean needInvoices;
    private boolean isCompanyInvoices;
    private int payWayId;
    private int expressWayId;
    private List<Integer> shoppingId;
    private List<OrderItem> products;
    private int test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(int payWayId) {
        this.payWayId = payWayId;
    }

    public int getExpressWayId() {
        return expressWayId;
    }

    public void setExpressWayId(int expressWayId) {
        this.expressWayId = expressWayId;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }

    public List<Integer> getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(List<Integer> shoppingId) {
        this.shoppingId = shoppingId;
    }

    public boolean isNeedInvoices() {
        return needInvoices;
    }

    public void setNeedInvoices(boolean needInvoices) {
        this.needInvoices = needInvoices;
    }

    public boolean isCompanyInvoices() {
        return isCompanyInvoices;
    }

    public void setCompanyInvoices(boolean companyInvoices) {
        isCompanyInvoices = companyInvoices;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
