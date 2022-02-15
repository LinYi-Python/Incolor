package vip.incolor.entity;

import java.util.Date;

public class Order {
    private Integer order_id;

    private String order_receiver;

    private Integer user_id;

    private String order_phone;

    private String order_address;

    private Integer order_postalcode;

    private String order_express_number;

    private Date order_create_times;

    private Date order_pay_time;

    private Date order_estimate_deliver_time;

    private Date order_real_deliver_time;

    private Boolean order_state;

    private String order_status;

    private Date order_create_time;

    private Date order_update_time;

    private Boolean is_need_invoices;

    private Boolean invoices_type;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_receiver() {
        return order_receiver;
    }

    public void setOrder_receiver(String order_receiver) {
        this.order_receiver = order_receiver == null ? null : order_receiver.trim();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone == null ? null : order_phone.trim();
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address == null ? null : order_address.trim();
    }

    public Integer getOrder_postalcode() {
        return order_postalcode;
    }

    public void setOrder_postalcode(Integer order_postalcode) {
        this.order_postalcode = order_postalcode;
    }

    public Date getOrder_create_times() {
        return order_create_times;
    }

    public void setOrder_create_times(Date order_create_times) {
        this.order_create_times = order_create_times;
    }

    public Date getOrder_pay_time() {
        return order_pay_time;
    }

    public void setOrder_pay_time(Date order_pay_time) {
        this.order_pay_time = order_pay_time;
    }

    public Date getOrder_estimate_deliver_time() {
        return order_estimate_deliver_time;
    }

    public void setOrder_estimate_deliver_time(Date order_estimate_deliver_time) {
        this.order_estimate_deliver_time = order_estimate_deliver_time;
    }

    public Date getOrder_real_deliver_time() {
        return order_real_deliver_time;
    }

    public void setOrder_real_deliver_time(Date order_real_deliver_time) {
        this.order_real_deliver_time = order_real_deliver_time;
    }

    public Boolean getOrder_state() {
        return order_state;
    }

    public void setOrder_state(Boolean order_state) {
        this.order_state = order_state;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status == null ? null : order_status.trim();
    }

    public Date getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Date order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Date getOrder_update_time() {
        return order_update_time;
    }

    public void setOrder_update_time(Date order_update_time) {
        this.order_update_time = order_update_time;
    }

    public Boolean getIs_need_invoices() {
        return is_need_invoices;
    }

    public void setIs_need_invoices(Boolean is_need_invoices) {
        this.is_need_invoices = is_need_invoices;
    }

    public Boolean getInvoices_type() {
        return invoices_type;
    }

    public void setInvoices_type(Boolean invoices_type) {
        this.invoices_type = invoices_type;
    }

    public String getOrder_express_number() {
        return order_express_number;
    }

    public void setOrder_express_number(String order_express_number) {
        this.order_express_number = order_express_number;
    }

}
