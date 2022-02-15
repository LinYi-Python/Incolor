package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingDetailExample() {
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

        public Criteria andShopping_detail_idIsNull() {
            addCriterion("shopping_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idIsNotNull() {
            addCriterion("shopping_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idEqualTo(Integer value) {
            addCriterion("shopping_detail_id =", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idNotEqualTo(Integer value) {
            addCriterion("shopping_detail_id <>", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idGreaterThan(Integer value) {
            addCriterion("shopping_detail_id >", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopping_detail_id >=", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idLessThan(Integer value) {
            addCriterion("shopping_detail_id <", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idLessThanOrEqualTo(Integer value) {
            addCriterion("shopping_detail_id <=", value, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idIn(List<Integer> values) {
            addCriterion("shopping_detail_id in", values, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idNotIn(List<Integer> values) {
            addCriterion("shopping_detail_id not in", values, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idBetween(Integer value1, Integer value2) {
            addCriterion("shopping_detail_id between", value1, value2, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_detail_idNotBetween(Integer value1, Integer value2) {
            addCriterion("shopping_detail_id not between", value1, value2, "shopping_detail_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idIsNull() {
            addCriterion("shopping_property_id is null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idIsNotNull() {
            addCriterion("shopping_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idEqualTo(Integer value) {
            addCriterion("shopping_property_id =", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idNotEqualTo(Integer value) {
            addCriterion("shopping_property_id <>", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idGreaterThan(Integer value) {
            addCriterion("shopping_property_id >", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopping_property_id >=", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idLessThan(Integer value) {
            addCriterion("shopping_property_id <", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idLessThanOrEqualTo(Integer value) {
            addCriterion("shopping_property_id <=", value, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idIn(List<Integer> values) {
            addCriterion("shopping_property_id in", values, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idNotIn(List<Integer> values) {
            addCriterion("shopping_property_id not in", values, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idBetween(Integer value1, Integer value2) {
            addCriterion("shopping_property_id between", value1, value2, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_idNotBetween(Integer value1, Integer value2) {
            addCriterion("shopping_property_id not between", value1, value2, "shopping_property_id");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameIsNull() {
            addCriterion("shopping_property_name is null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameIsNotNull() {
            addCriterion("shopping_property_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameEqualTo(String value) {
            addCriterion("shopping_property_name =", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameNotEqualTo(String value) {
            addCriterion("shopping_property_name <>", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameGreaterThan(String value) {
            addCriterion("shopping_property_name >", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameGreaterThanOrEqualTo(String value) {
            addCriterion("shopping_property_name >=", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameLessThan(String value) {
            addCriterion("shopping_property_name <", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameLessThanOrEqualTo(String value) {
            addCriterion("shopping_property_name <=", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameLike(String value) {
            addCriterion("shopping_property_name like", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameNotLike(String value) {
            addCriterion("shopping_property_name not like", value, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameIn(List<String> values) {
            addCriterion("shopping_property_name in", values, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameNotIn(List<String> values) {
            addCriterion("shopping_property_name not in", values, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameBetween(String value1, String value2) {
            addCriterion("shopping_property_name between", value1, value2, "shopping_property_name");
            return (Criteria) this;
        }

        public Criteria andShopping_property_nameNotBetween(String value1, String value2) {
            addCriterion("shopping_property_name not between", value1, value2, "shopping_property_name");
            return (Criteria) this;
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

        public Criteria andShopping_property_create_timeIsNull() {
            addCriterion("shopping_property_create_time is null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeIsNotNull() {
            addCriterion("shopping_property_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeEqualTo(Date value) {
            addCriterion("shopping_property_create_time =", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeNotEqualTo(Date value) {
            addCriterion("shopping_property_create_time <>", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeGreaterThan(Date value) {
            addCriterion("shopping_property_create_time >", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopping_property_create_time >=", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeLessThan(Date value) {
            addCriterion("shopping_property_create_time <", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("shopping_property_create_time <=", value, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeIn(List<Date> values) {
            addCriterion("shopping_property_create_time in", values, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeNotIn(List<Date> values) {
            addCriterion("shopping_property_create_time not in", values, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeBetween(Date value1, Date value2) {
            addCriterion("shopping_property_create_time between", value1, value2, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("shopping_property_create_time not between", value1, value2, "shopping_property_create_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeIsNull() {
            addCriterion("shopping_property_update_time is null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeIsNotNull() {
            addCriterion("shopping_property_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeEqualTo(Date value) {
            addCriterion("shopping_property_update_time =", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeNotEqualTo(Date value) {
            addCriterion("shopping_property_update_time <>", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeGreaterThan(Date value) {
            addCriterion("shopping_property_update_time >", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopping_property_update_time >=", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeLessThan(Date value) {
            addCriterion("shopping_property_update_time <", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("shopping_property_update_time <=", value, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeIn(List<Date> values) {
            addCriterion("shopping_property_update_time in", values, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeNotIn(List<Date> values) {
            addCriterion("shopping_property_update_time not in", values, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeBetween(Date value1, Date value2) {
            addCriterion("shopping_property_update_time between", value1, value2, "shopping_property_update_time");
            return (Criteria) this;
        }

        public Criteria andShopping_property_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("shopping_property_update_time not between", value1, value2, "shopping_property_update_time");
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