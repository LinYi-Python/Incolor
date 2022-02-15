package vip.incolor.entity;

import java.util.Date;

public class Invoices {
    private Integer invoices_id;

    private Integer user_id;

    private Boolean is_invoices;

    private String invoices_personal_name;

    private String invoices_company_name;

    private String invoices_company_number;

    private Date invoices_create_time;

    private Date invoices_update_time;

    public Integer getInvoices_id() {
        return invoices_id;
    }

    public void setInvoices_id(Integer invoices_id) {
        this.invoices_id = invoices_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getIs_invoices() {
        return is_invoices;
    }

    public void setIs_invoices(Boolean is_invoices) {
        this.is_invoices = is_invoices;
    }

    public String getInvoices_personal_name() {
        return invoices_personal_name;
    }

    public void setInvoices_personal_name(String invoices_personal_name) {
        this.invoices_personal_name = invoices_personal_name == null ? null : invoices_personal_name.trim();
    }

    public String getInvoices_company_name() {
        return invoices_company_name;
    }

    public void setInvoices_company_name(String invoices_company_name) {
        this.invoices_company_name = invoices_company_name == null ? null : invoices_company_name.trim();
    }

    public String getInvoices_company_number() {
        return invoices_company_number;
    }

    public void setInvoices_company_number(String invoices_company_number) {
        this.invoices_company_number = invoices_company_number == null ? null : invoices_company_number.trim();
    }

    public Date getInvoices_create_time() {
        return invoices_create_time;
    }

    public void setInvoices_create_time(Date invoices_create_time) {
        this.invoices_create_time = invoices_create_time;
    }

    public Date getInvoices_update_time() {
        return invoices_update_time;
    }

    public void setInvoices_update_time(Date invoices_update_time) {
        this.invoices_update_time = invoices_update_time;
    }
}