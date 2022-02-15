package vip.incolor.entity;

import java.util.Date;

public class Address {
    private Integer address_id;

    private Integer user_id;

    private String province;

    private String city;

    private String district;

    private String town;

    private String detailed_address;

    private Boolean is_default_address;

    private String order_fmaily_name;

    private String order_given_name;

    private Boolean order_gender;

    private String order_phone;

    private Date address_create_time;

    private Date address_update_time;

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getDetailed_address() {
        return detailed_address;
    }

    public void setDetailed_address(String detailed_address) {
        this.detailed_address = detailed_address == null ? null : detailed_address.trim();
    }

    public Boolean getIs_default_address() {
        return is_default_address;
    }

    public void setIs_default_address(Boolean is_default_address) {
        this.is_default_address = is_default_address;
    }

    public String getOrder_fmaily_name() {
        return order_fmaily_name;
    }

    public void setOrder_fmaily_name(String order_fmaily_name) {
        this.order_fmaily_name = order_fmaily_name == null ? null : order_fmaily_name.trim();
    }

    public String getOrder_given_name() {
        return order_given_name;
    }

    public void setOrder_given_name(String order_given_name) {
        this.order_given_name = order_given_name == null ? null : order_given_name.trim();
    }

    public Boolean getOrder_gender() {
        return order_gender;
    }

    public void setOrder_gender(Boolean order_gender) {
        this.order_gender = order_gender;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone == null ? null : order_phone.trim();
    }

    public Date getAddress_create_time() {
        return address_create_time;
    }

    public void setAddress_create_time(Date address_create_time) {
        this.address_create_time = address_create_time;
    }

    public Date getAddress_update_time() {
        return address_update_time;
    }

    public void setAddress_update_time(Date address_update_time) {
        this.address_update_time = address_update_time;
    }
}