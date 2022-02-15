package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyOrderDetailExample() {
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

        public Criteria andOrder_detail_idIsNull() {
            addCriterion("order_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idIsNotNull() {
            addCriterion("order_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idEqualTo(Integer value) {
            addCriterion("order_detail_id =", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idNotEqualTo(Integer value) {
            addCriterion("order_detail_id <>", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idGreaterThan(Integer value) {
            addCriterion("order_detail_id >", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_detail_id >=", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idLessThan(Integer value) {
            addCriterion("order_detail_id <", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_detail_id <=", value, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idIn(List<Integer> values) {
            addCriterion("order_detail_id in", values, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idNotIn(List<Integer> values) {
            addCriterion("order_detail_id not in", values, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idBetween(Integer value1, Integer value2) {
            addCriterion("order_detail_id between", value1, value2, "order_detail_id");
            return (Criteria) this;
        }

        public Criteria andOrder_detail_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_detail_id not between", value1, value2, "order_detail_id");
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

        public Criteria andOrder_create_timeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThan(Date value) {
            addCriterion("order_create_time <", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIsNull() {
            addCriterion("order_update_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIsNotNull() {
            addCriterion("order_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeEqualTo(Date value) {
            addCriterion("order_update_time =", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotEqualTo(Date value) {
            addCriterion("order_update_time <>", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeGreaterThan(Date value) {
            addCriterion("order_update_time >", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_update_time >=", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeLessThan(Date value) {
            addCriterion("order_update_time <", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_update_time <=", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIn(List<Date> values) {
            addCriterion("order_update_time in", values, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotIn(List<Date> values) {
            addCriterion("order_update_time not in", values, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeBetween(Date value1, Date value2) {
            addCriterion("order_update_time between", value1, value2, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_update_time not between", value1, value2, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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