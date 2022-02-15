package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAddress_idIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_idEqualTo(Integer value) {
            addCriterion("address_id =", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThan(Integer value) {
            addCriterion("address_id >", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThan(Integer value) {
            addCriterion("address_id <", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idIn(List<Integer> values) {
            addCriterion("address_id in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressLike(String value) {
            addCriterion("detailed_address like", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andDetailed_addressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailed_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressIsNull() {
            addCriterion("is_default_address is null");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressIsNotNull() {
            addCriterion("is_default_address is not null");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressEqualTo(Boolean value) {
            addCriterion("is_default_address =", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressNotEqualTo(Boolean value) {
            addCriterion("is_default_address <>", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressGreaterThan(Boolean value) {
            addCriterion("is_default_address >", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default_address >=", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressLessThan(Boolean value) {
            addCriterion("is_default_address <", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default_address <=", value, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressIn(List<Boolean> values) {
            addCriterion("is_default_address in", values, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressNotIn(List<Boolean> values) {
            addCriterion("is_default_address not in", values, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default_address between", value1, value2, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andIs_default_addressNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default_address not between", value1, value2, "is_default_address");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameIsNull() {
            addCriterion("order_fmaily_name is null");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameIsNotNull() {
            addCriterion("order_fmaily_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameEqualTo(String value) {
            addCriterion("order_fmaily_name =", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameNotEqualTo(String value) {
            addCriterion("order_fmaily_name <>", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameGreaterThan(String value) {
            addCriterion("order_fmaily_name >", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameGreaterThanOrEqualTo(String value) {
            addCriterion("order_fmaily_name >=", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameLessThan(String value) {
            addCriterion("order_fmaily_name <", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameLessThanOrEqualTo(String value) {
            addCriterion("order_fmaily_name <=", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameLike(String value) {
            addCriterion("order_fmaily_name like", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameNotLike(String value) {
            addCriterion("order_fmaily_name not like", value, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameIn(List<String> values) {
            addCriterion("order_fmaily_name in", values, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameNotIn(List<String> values) {
            addCriterion("order_fmaily_name not in", values, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameBetween(String value1, String value2) {
            addCriterion("order_fmaily_name between", value1, value2, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_fmaily_nameNotBetween(String value1, String value2) {
            addCriterion("order_fmaily_name not between", value1, value2, "order_fmaily_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameIsNull() {
            addCriterion("order_given_name is null");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameIsNotNull() {
            addCriterion("order_given_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameEqualTo(String value) {
            addCriterion("order_given_name =", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameNotEqualTo(String value) {
            addCriterion("order_given_name <>", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameGreaterThan(String value) {
            addCriterion("order_given_name >", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameGreaterThanOrEqualTo(String value) {
            addCriterion("order_given_name >=", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameLessThan(String value) {
            addCriterion("order_given_name <", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameLessThanOrEqualTo(String value) {
            addCriterion("order_given_name <=", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameLike(String value) {
            addCriterion("order_given_name like", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameNotLike(String value) {
            addCriterion("order_given_name not like", value, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameIn(List<String> values) {
            addCriterion("order_given_name in", values, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameNotIn(List<String> values) {
            addCriterion("order_given_name not in", values, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameBetween(String value1, String value2) {
            addCriterion("order_given_name between", value1, value2, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_given_nameNotBetween(String value1, String value2) {
            addCriterion("order_given_name not between", value1, value2, "order_given_name");
            return (Criteria) this;
        }

        public Criteria andOrder_genderIsNull() {
            addCriterion("order_gender is null");
            return (Criteria) this;
        }

        public Criteria andOrder_genderIsNotNull() {
            addCriterion("order_gender is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_genderEqualTo(Boolean value) {
            addCriterion("order_gender =", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderNotEqualTo(Boolean value) {
            addCriterion("order_gender <>", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderGreaterThan(Boolean value) {
            addCriterion("order_gender >", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_gender >=", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderLessThan(Boolean value) {
            addCriterion("order_gender <", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderLessThanOrEqualTo(Boolean value) {
            addCriterion("order_gender <=", value, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderIn(List<Boolean> values) {
            addCriterion("order_gender in", values, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderNotIn(List<Boolean> values) {
            addCriterion("order_gender not in", values, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderBetween(Boolean value1, Boolean value2) {
            addCriterion("order_gender between", value1, value2, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_genderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_gender not between", value1, value2, "order_gender");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneIsNull() {
            addCriterion("order_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneIsNotNull() {
            addCriterion("order_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneEqualTo(String value) {
            addCriterion("order_phone =", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotEqualTo(String value) {
            addCriterion("order_phone <>", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneGreaterThan(String value) {
            addCriterion("order_phone >", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_phone >=", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLessThan(String value) {
            addCriterion("order_phone <", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLessThanOrEqualTo(String value) {
            addCriterion("order_phone <=", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLike(String value) {
            addCriterion("order_phone like", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotLike(String value) {
            addCriterion("order_phone not like", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneIn(List<String> values) {
            addCriterion("order_phone in", values, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotIn(List<String> values) {
            addCriterion("order_phone not in", values, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneBetween(String value1, String value2) {
            addCriterion("order_phone between", value1, value2, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotBetween(String value1, String value2) {
            addCriterion("order_phone not between", value1, value2, "order_phone");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeIsNull() {
            addCriterion("address_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeIsNotNull() {
            addCriterion("address_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeEqualTo(Date value) {
            addCriterion("address_create_time =", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeNotEqualTo(Date value) {
            addCriterion("address_create_time <>", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeGreaterThan(Date value) {
            addCriterion("address_create_time >", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("address_create_time >=", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeLessThan(Date value) {
            addCriterion("address_create_time <", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("address_create_time <=", value, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeIn(List<Date> values) {
            addCriterion("address_create_time in", values, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeNotIn(List<Date> values) {
            addCriterion("address_create_time not in", values, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeBetween(Date value1, Date value2) {
            addCriterion("address_create_time between", value1, value2, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("address_create_time not between", value1, value2, "address_create_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeIsNull() {
            addCriterion("address_update_time is null");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeIsNotNull() {
            addCriterion("address_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeEqualTo(Date value) {
            addCriterion("address_update_time =", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeNotEqualTo(Date value) {
            addCriterion("address_update_time <>", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeGreaterThan(Date value) {
            addCriterion("address_update_time >", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("address_update_time >=", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeLessThan(Date value) {
            addCriterion("address_update_time <", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("address_update_time <=", value, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeIn(List<Date> values) {
            addCriterion("address_update_time in", values, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeNotIn(List<Date> values) {
            addCriterion("address_update_time not in", values, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeBetween(Date value1, Date value2) {
            addCriterion("address_update_time between", value1, value2, "address_update_time");
            return (Criteria) this;
        }

        public Criteria andAddress_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("address_update_time not between", value1, value2, "address_update_time");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}