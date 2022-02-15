package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingExample() {
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

        public Criteria andShopping_idIsNull() {
            addCriterion("shopping_id is null");
            return (Criteria) this;
        }

        public Criteria andShopping_idIsNotNull() {
            addCriterion("shopping_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_idEqualTo(Integer value) {
            addCriterion("shopping_id =", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idNotEqualTo(Integer value) {
            addCriterion("shopping_id <>", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idGreaterThan(Integer value) {
            addCriterion("shopping_id >", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopping_id >=", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idLessThan(Integer value) {
            addCriterion("shopping_id <", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idLessThanOrEqualTo(Integer value) {
            addCriterion("shopping_id <=", value, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idIn(List<Integer> values) {
            addCriterion("shopping_id in", values, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idNotIn(List<Integer> values) {
            addCriterion("shopping_id not in", values, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idBetween(Integer value1, Integer value2) {
            addCriterion("shopping_id between", value1, value2, "shopping_id");
            return (Criteria) this;
        }

        public Criteria andShopping_idNotBetween(Integer value1, Integer value2) {
            addCriterion("shopping_id not between", value1, value2, "shopping_id");
            return (Criteria) this;
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

        public Criteria andIs_payedIsNull() {
            addCriterion("is_payed is null");
            return (Criteria) this;
        }

        public Criteria andIs_payedIsNotNull() {
            addCriterion("is_payed is not null");
            return (Criteria) this;
        }

        public Criteria andIs_payedEqualTo(Boolean value) {
            addCriterion("is_payed =", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedNotEqualTo(Boolean value) {
            addCriterion("is_payed <>", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedGreaterThan(Boolean value) {
            addCriterion("is_payed >", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_payed >=", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedLessThan(Boolean value) {
            addCriterion("is_payed <", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_payed <=", value, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedIn(List<Boolean> values) {
            addCriterion("is_payed in", values, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedNotIn(List<Boolean> values) {
            addCriterion("is_payed not in", values, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_payed between", value1, value2, "is_payed");
            return (Criteria) this;
        }

        public Criteria andIs_payedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_payed not between", value1, value2, "is_payed");
            return (Criteria) this;
        }

        public Criteria andShooping_numberIsNull() {
            addCriterion("shooping_number is null");
            return (Criteria) this;
        }

        public Criteria andShooping_numberIsNotNull() {
            addCriterion("shooping_number is not null");
            return (Criteria) this;
        }

        public Criteria andShooping_numberEqualTo(Integer value) {
            addCriterion("shooping_number =", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberNotEqualTo(Integer value) {
            addCriterion("shooping_number <>", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberGreaterThan(Integer value) {
            addCriterion("shooping_number >", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("shooping_number >=", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberLessThan(Integer value) {
            addCriterion("shooping_number <", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberLessThanOrEqualTo(Integer value) {
            addCriterion("shooping_number <=", value, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberIn(List<Integer> values) {
            addCriterion("shooping_number in", values, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberNotIn(List<Integer> values) {
            addCriterion("shooping_number not in", values, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberBetween(Integer value1, Integer value2) {
            addCriterion("shooping_number between", value1, value2, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShooping_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("shooping_number not between", value1, value2, "shooping_number");
            return (Criteria) this;
        }

        public Criteria andShopping_priceIsNull() {
            addCriterion("shopping_price is null");
            return (Criteria) this;
        }

        public Criteria andShopping_priceIsNotNull() {
            addCriterion("shopping_price is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_priceEqualTo(Integer value) {
            addCriterion("shopping_price =", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceNotEqualTo(Integer value) {
            addCriterion("shopping_price <>", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceGreaterThan(Integer value) {
            addCriterion("shopping_price >", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopping_price >=", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceLessThan(Integer value) {
            addCriterion("shopping_price <", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceLessThanOrEqualTo(Integer value) {
            addCriterion("shopping_price <=", value, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceIn(List<Integer> values) {
            addCriterion("shopping_price in", values, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceNotIn(List<Integer> values) {
            addCriterion("shopping_price not in", values, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceBetween(Integer value1, Integer value2) {
            addCriterion("shopping_price between", value1, value2, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_priceNotBetween(Integer value1, Integer value2) {
            addCriterion("shopping_price not between", value1, value2, "shopping_price");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeIsNull() {
            addCriterion("shopping_create_time is null");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeIsNotNull() {
            addCriterion("shopping_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeEqualTo(Date value) {
            addCriterion("shopping_create_time =", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeNotEqualTo(Date value) {
            addCriterion("shopping_create_time <>", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeGreaterThan(Date value) {
            addCriterion("shopping_create_time >", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopping_create_time >=", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeLessThan(Date value) {
            addCriterion("shopping_create_time <", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("shopping_create_time <=", value, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeIn(List<Date> values) {
            addCriterion("shopping_create_time in", values, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeNotIn(List<Date> values) {
            addCriterion("shopping_create_time not in", values, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeBetween(Date value1, Date value2) {
            addCriterion("shopping_create_time between", value1, value2, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("shopping_create_time not between", value1, value2, "shopping_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeIsNull() {
            addCriterion("shopping_update_time is null");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeIsNotNull() {
            addCriterion("shopping_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeEqualTo(Date value) {
            addCriterion("shopping_update_time =", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeNotEqualTo(Date value) {
            addCriterion("shopping_update_time <>", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeGreaterThan(Date value) {
            addCriterion("shopping_update_time >", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopping_update_time >=", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeLessThan(Date value) {
            addCriterion("shopping_update_time <", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("shopping_update_time <=", value, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeIn(List<Date> values) {
            addCriterion("shopping_update_time in", values, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeNotIn(List<Date> values) {
            addCriterion("shopping_update_time not in", values, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeBetween(Date value1, Date value2) {
            addCriterion("shopping_update_time between", value1, value2, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("shopping_update_time not between", value1, value2, "shopping_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
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