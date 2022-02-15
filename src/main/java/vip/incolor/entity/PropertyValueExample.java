package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyValueExample() {
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

        public Criteria andProperty_value_idIsNull() {
            addCriterion("property_value_id is null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idIsNotNull() {
            addCriterion("property_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idEqualTo(Integer value) {
            addCriterion("property_value_id =", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idNotEqualTo(Integer value) {
            addCriterion("property_value_id <>", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idGreaterThan(Integer value) {
            addCriterion("property_value_id >", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_value_id >=", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idLessThan(Integer value) {
            addCriterion("property_value_id <", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idLessThanOrEqualTo(Integer value) {
            addCriterion("property_value_id <=", value, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idIn(List<Integer> values) {
            addCriterion("property_value_id in", values, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idNotIn(List<Integer> values) {
            addCriterion("property_value_id not in", values, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id between", value1, value2, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_value_idNotBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id not between", value1, value2, "property_value_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idIsNull() {
            addCriterion("property_id is null");
            return (Criteria) this;
        }

        public Criteria andProperty_idIsNotNull() {
            addCriterion("property_id is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_idEqualTo(Integer value) {
            addCriterion("property_id =", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotEqualTo(Integer value) {
            addCriterion("property_id <>", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idGreaterThan(Integer value) {
            addCriterion("property_id >", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_id >=", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idLessThan(Integer value) {
            addCriterion("property_id <", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idLessThanOrEqualTo(Integer value) {
            addCriterion("property_id <=", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idIn(List<Integer> values) {
            addCriterion("property_id in", values, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotIn(List<Integer> values) {
            addCriterion("property_id not in", values, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idBetween(Integer value1, Integer value2) {
            addCriterion("property_id between", value1, value2, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotBetween(Integer value1, Integer value2) {
            addCriterion("property_id not between", value1, value2, "property_id");
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

        public Criteria andProperty_valueIsNull() {
            addCriterion("property_value is null");
            return (Criteria) this;
        }

        public Criteria andProperty_valueIsNotNull() {
            addCriterion("property_value is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_valueEqualTo(String value) {
            addCriterion("property_value =", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueNotEqualTo(String value) {
            addCriterion("property_value <>", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueGreaterThan(String value) {
            addCriterion("property_value >", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueGreaterThanOrEqualTo(String value) {
            addCriterion("property_value >=", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueLessThan(String value) {
            addCriterion("property_value <", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueLessThanOrEqualTo(String value) {
            addCriterion("property_value <=", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueLike(String value) {
            addCriterion("property_value like", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueNotLike(String value) {
            addCriterion("property_value not like", value, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueIn(List<String> values) {
            addCriterion("property_value in", values, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueNotIn(List<String> values) {
            addCriterion("property_value not in", values, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueBetween(String value1, String value2) {
            addCriterion("property_value between", value1, value2, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_valueNotBetween(String value1, String value2) {
            addCriterion("property_value not between", value1, value2, "property_value");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeIsNull() {
            addCriterion("property_value_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeIsNotNull() {
            addCriterion("property_value_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeEqualTo(Date value) {
            addCriterion("property_value_create_time =", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeNotEqualTo(Date value) {
            addCriterion("property_value_create_time <>", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeGreaterThan(Date value) {
            addCriterion("property_value_create_time >", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_value_create_time >=", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeLessThan(Date value) {
            addCriterion("property_value_create_time <", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("property_value_create_time <=", value, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeIn(List<Date> values) {
            addCriterion("property_value_create_time in", values, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeNotIn(List<Date> values) {
            addCriterion("property_value_create_time not in", values, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeBetween(Date value1, Date value2) {
            addCriterion("property_value_create_time between", value1, value2, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("property_value_create_time not between", value1, value2, "property_value_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeIsNull() {
            addCriterion("property_value_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeIsNotNull() {
            addCriterion("property_value_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeEqualTo(Date value) {
            addCriterion("property_value_update_time =", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeNotEqualTo(Date value) {
            addCriterion("property_value_update_time <>", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeGreaterThan(Date value) {
            addCriterion("property_value_update_time >", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_value_update_time >=", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeLessThan(Date value) {
            addCriterion("property_value_update_time <", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("property_value_update_time <=", value, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeIn(List<Date> values) {
            addCriterion("property_value_update_time in", values, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeNotIn(List<Date> values) {
            addCriterion("property_value_update_time not in", values, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeBetween(Date value1, Date value2) {
            addCriterion("property_value_update_time between", value1, value2, "property_value_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_value_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("property_value_update_time not between", value1, value2, "property_value_update_time");
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