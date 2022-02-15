package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderPayExample() {
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

        public Criteria andOrder_pay_idIsNull() {
            addCriterion("order_pay_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idIsNotNull() {
            addCriterion("order_pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idEqualTo(Integer value) {
            addCriterion("order_pay_id =", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idNotEqualTo(Integer value) {
            addCriterion("order_pay_id <>", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idGreaterThan(Integer value) {
            addCriterion("order_pay_id >", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_pay_id >=", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idLessThan(Integer value) {
            addCriterion("order_pay_id <", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_pay_id <=", value, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idIn(List<Integer> values) {
            addCriterion("order_pay_id in", values, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idNotIn(List<Integer> values) {
            addCriterion("order_pay_id not in", values, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_id between", value1, value2, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_pay_id not between", value1, value2, "order_pay_id");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameIsNull() {
            addCriterion("order_pay_name is null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameIsNotNull() {
            addCriterion("order_pay_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameEqualTo(String value) {
            addCriterion("order_pay_name =", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameNotEqualTo(String value) {
            addCriterion("order_pay_name <>", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameGreaterThan(String value) {
            addCriterion("order_pay_name >", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameGreaterThanOrEqualTo(String value) {
            addCriterion("order_pay_name >=", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameLessThan(String value) {
            addCriterion("order_pay_name <", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameLessThanOrEqualTo(String value) {
            addCriterion("order_pay_name <=", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameLike(String value) {
            addCriterion("order_pay_name like", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameNotLike(String value) {
            addCriterion("order_pay_name not like", value, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameIn(List<String> values) {
            addCriterion("order_pay_name in", values, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameNotIn(List<String> values) {
            addCriterion("order_pay_name not in", values, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameBetween(String value1, String value2) {
            addCriterion("order_pay_name between", value1, value2, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_nameNotBetween(String value1, String value2) {
            addCriterion("order_pay_name not between", value1, value2, "order_pay_name");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeIsNull() {
            addCriterion("order_pay_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeIsNotNull() {
            addCriterion("order_pay_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeEqualTo(Date value) {
            addCriterion("order_pay_create_time =", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeNotEqualTo(Date value) {
            addCriterion("order_pay_create_time <>", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeGreaterThan(Date value) {
            addCriterion("order_pay_create_time >", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_create_time >=", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeLessThan(Date value) {
            addCriterion("order_pay_create_time <", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_create_time <=", value, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeIn(List<Date> values) {
            addCriterion("order_pay_create_time in", values, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeNotIn(List<Date> values) {
            addCriterion("order_pay_create_time not in", values, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeBetween(Date value1, Date value2) {
            addCriterion("order_pay_create_time between", value1, value2, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_create_time not between", value1, value2, "order_pay_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeIsNull() {
            addCriterion("order_pay_update_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeIsNotNull() {
            addCriterion("order_pay_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeEqualTo(Date value) {
            addCriterion("order_pay_update_time =", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeNotEqualTo(Date value) {
            addCriterion("order_pay_update_time <>", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeGreaterThan(Date value) {
            addCriterion("order_pay_update_time >", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_update_time >=", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeLessThan(Date value) {
            addCriterion("order_pay_update_time <", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_update_time <=", value, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeIn(List<Date> values) {
            addCriterion("order_pay_update_time in", values, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeNotIn(List<Date> values) {
            addCriterion("order_pay_update_time not in", values, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeBetween(Date value1, Date value2) {
            addCriterion("order_pay_update_time between", value1, value2, "order_pay_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_update_time not between", value1, value2, "order_pay_update_time");
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