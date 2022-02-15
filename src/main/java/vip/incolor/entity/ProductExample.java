package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProduct_idIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_sizeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }
        public Criteria andProduct_nameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("product_name =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("product_name >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("product_name <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("product_name like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("product_name not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("product_name in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_tagIsNull() {
            addCriterion("product_tag is null");
            return (Criteria) this;
        }

        public Criteria andProduct_tagIsNotNull() {
            addCriterion("product_tag is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_tagEqualTo(String value) {
            addCriterion("product_tag =", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagNotEqualTo(String value) {
            addCriterion("product_tag <>", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagGreaterThan(String value) {
            addCriterion("product_tag >", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagGreaterThanOrEqualTo(String value) {
            addCriterion("product_tag >=", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagLessThan(String value) {
            addCriterion("product_tag <", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagLessThanOrEqualTo(String value) {
            addCriterion("product_tag <=", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagLike(String value) {
            addCriterion("product_tag like", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagNotLike(String value) {
            addCriterion("product_tag not like", value, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagIn(List<String> values) {
            addCriterion("product_tag in", values, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagNotIn(List<String> values) {
            addCriterion("product_tag not in", values, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagBetween(String value1, String value2) {
            addCriterion("product_tag between", value1, value2, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_tagNotBetween(String value1, String value2) {
            addCriterion("product_tag not between", value1, value2, "product_tag");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idIsNull() {
            addCriterion("product_class_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idIsNotNull() {
            addCriterion("product_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idEqualTo(Integer value) {
            addCriterion("product_class_id =", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idNotEqualTo(Integer value) {
            addCriterion("product_class_id <>", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idGreaterThan(Integer value) {
            addCriterion("product_class_id >", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_class_id >=", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idLessThan(Integer value) {
            addCriterion("product_class_id <", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_class_id <=", value, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idIn(List<Integer> values) {
            addCriterion("product_class_id in", values, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idNotIn(List<Integer> values) {
            addCriterion("product_class_id not in", values, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idBetween(Integer value1, Integer value2) {
            addCriterion("product_class_id between", value1, value2, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_class_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_class_id not between", value1, value2, "product_class_id");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_priceEqualTo(Integer value) {
            addCriterion("product_price =", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotEqualTo(Integer value) {
            addCriterion("product_price <>", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThan(Integer value) {
            addCriterion("product_price >", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_price >=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThan(Integer value) {
            addCriterion("product_price <", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceLessThanOrEqualTo(Integer value) {
            addCriterion("product_price <=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceIn(List<Integer> values) {
            addCriterion("product_price in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotIn(List<Integer> values) {
            addCriterion("product_price not in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceBetween(Integer value1, Integer value2) {
            addCriterion("product_price between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("product_price not between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableIsNull() {
            addCriterion("product_marketable is null");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableIsNotNull() {
            addCriterion("product_marketable is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableEqualTo(Boolean value) {
            addCriterion("product_marketable =", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableNotEqualTo(Boolean value) {
            addCriterion("product_marketable <>", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableGreaterThan(Boolean value) {
            addCriterion("product_marketable >", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("product_marketable >=", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableLessThan(Boolean value) {
            addCriterion("product_marketable <", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableLessThanOrEqualTo(Boolean value) {
            addCriterion("product_marketable <=", value, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableIn(List<Boolean> values) {
            addCriterion("product_marketable in", values, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableNotIn(List<Boolean> values) {
            addCriterion("product_marketable not in", values, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableBetween(Boolean value1, Boolean value2) {
            addCriterion("product_marketable between", value1, value2, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_marketableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("product_marketable not between", value1, value2, "product_marketable");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idIsNull() {
            addCriterion("product_attach_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idIsNotNull() {
            addCriterion("product_attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idEqualTo(Integer value) {
            addCriterion("product_attach_id =", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idNotEqualTo(Integer value) {
            addCriterion("product_attach_id <>", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idGreaterThan(Integer value) {
            addCriterion("product_attach_id >", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_attach_id >=", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idLessThan(Integer value) {
            addCriterion("product_attach_id <", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_attach_id <=", value, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idIn(List<Integer> values) {
            addCriterion("product_attach_id in", values, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idNotIn(List<Integer> values) {
            addCriterion("product_attach_id not in", values, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idBetween(Integer value1, Integer value2) {
            addCriterion("product_attach_id between", value1, value2, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_attach_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_attach_id not between", value1, value2, "product_attach_id");
            return (Criteria) this;
        }

        public Criteria andProduct_numberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProduct_numberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_numberEqualTo(Integer value) {
            addCriterion("product_number =", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotEqualTo(Integer value) {
            addCriterion("product_number <>", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberGreaterThan(Integer value) {
            addCriterion("product_number >", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_number >=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberLessThan(Integer value) {
            addCriterion("product_number <", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberLessThanOrEqualTo(Integer value) {
            addCriterion("product_number <=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberIn(List<Integer> values) {
            addCriterion("product_number in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotIn(List<Integer> values) {
            addCriterion("product_number not in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberBetween(Integer value1, Integer value2) {
            addCriterion("product_number between", value1, value2, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("product_number not between", value1, value2, "product_number");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idIsNull() {
            addCriterion("product_picture_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idIsNotNull() {
            addCriterion("product_picture_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idEqualTo(Integer value) {
            addCriterion("product_picture_id =", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotEqualTo(Integer value) {
            addCriterion("product_picture_id <>", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idGreaterThan(Integer value) {
            addCriterion("product_picture_id >", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_picture_id >=", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idLessThan(Integer value) {
            addCriterion("product_picture_id <", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_picture_id <=", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idIn(List<Integer> values) {
            addCriterion("product_picture_id in", values, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotIn(List<Integer> values) {
            addCriterion("product_picture_id not in", values, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idBetween(Integer value1, Integer value2) {
            addCriterion("product_picture_id between", value1, value2, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_picture_id not between", value1, value2, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeIsNull() {
            addCriterion("product_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeIsNotNull() {
            addCriterion("product_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeEqualTo(Date value) {
            addCriterion("product_create_time =", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeNotEqualTo(Date value) {
            addCriterion("product_create_time <>", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeGreaterThan(Date value) {
            addCriterion("product_create_time >", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_create_time >=", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeLessThan(Date value) {
            addCriterion("product_create_time <", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("product_create_time <=", value, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeIn(List<Date> values) {
            addCriterion("product_create_time in", values, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeNotIn(List<Date> values) {
            addCriterion("product_create_time not in", values, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeBetween(Date value1, Date value2) {
            addCriterion("product_create_time between", value1, value2, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("product_create_time not between", value1, value2, "product_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeIsNull() {
            addCriterion("product_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeIsNotNull() {
            addCriterion("product_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeEqualTo(Date value) {
            addCriterion("product_update_time =", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeNotEqualTo(Date value) {
            addCriterion("product_update_time <>", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeGreaterThan(Date value) {
            addCriterion("product_update_time >", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_update_time >=", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeLessThan(Date value) {
            addCriterion("product_update_time <", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("product_update_time <=", value, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeIn(List<Date> values) {
            addCriterion("product_update_time in", values, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeNotIn(List<Date> values) {
            addCriterion("product_update_time not in", values, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeBetween(Date value1, Date value2) {
            addCriterion("product_update_time between", value1, value2, "product_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("product_update_time not between", value1, value2, "product_update_time");
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