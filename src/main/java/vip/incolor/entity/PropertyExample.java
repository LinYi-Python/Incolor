package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyExample() {
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

        public Criteria andProperty_nameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }

        public Criteria andProperty_nameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_nameEqualTo(String value) {
            addCriterion("property_name =", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameGreaterThan(String value) {
            addCriterion("property_name >", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameLessThan(String value) {
            addCriterion("property_name <", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameLike(String value) {
            addCriterion("property_name like", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameNotLike(String value) {
            addCriterion("property_name not like", value, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameIn(List<String> values) {
            addCriterion("property_name in", values, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "property_name");
            return (Criteria) this;
        }

        public Criteria andProperty_nameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "property_name");
            return (Criteria) this;
        }

        public Criteria andClassify_idIsNull() {
            addCriterion("classify_id is null");
            return (Criteria) this;
        }

        public Criteria andClassify_idIsNotNull() {
            addCriterion("classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassify_idEqualTo(Integer value) {
            addCriterion("classify_id =", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idNotEqualTo(Integer value) {
            addCriterion("classify_id <>", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idGreaterThan(Integer value) {
            addCriterion("classify_id >", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("classify_id >=", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idLessThan(Integer value) {
            addCriterion("classify_id <", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idLessThanOrEqualTo(Integer value) {
            addCriterion("classify_id <=", value, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idIn(List<Integer> values) {
            addCriterion("classify_id in", values, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idNotIn(List<Integer> values) {
            addCriterion("classify_id not in", values, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idBetween(Integer value1, Integer value2) {
            addCriterion("classify_id between", value1, value2, "classify_id");
            return (Criteria) this;
        }

        public Criteria andClassify_idNotBetween(Integer value1, Integer value2) {
            addCriterion("classify_id not between", value1, value2, "classify_id");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeIsNull() {
            addCriterion("property_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeIsNotNull() {
            addCriterion("property_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeEqualTo(Date value) {
            addCriterion("property_create_time =", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeNotEqualTo(Date value) {
            addCriterion("property_create_time <>", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeGreaterThan(Date value) {
            addCriterion("property_create_time >", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_create_time >=", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeLessThan(Date value) {
            addCriterion("property_create_time <", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("property_create_time <=", value, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeIn(List<Date> values) {
            addCriterion("property_create_time in", values, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeNotIn(List<Date> values) {
            addCriterion("property_create_time not in", values, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeBetween(Date value1, Date value2) {
            addCriterion("property_create_time between", value1, value2, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("property_create_time not between", value1, value2, "property_create_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeIsNull() {
            addCriterion("property_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeIsNotNull() {
            addCriterion("property_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeEqualTo(Date value) {
            addCriterion("property_update_time =", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeNotEqualTo(Date value) {
            addCriterion("property_update_time <>", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeGreaterThan(Date value) {
            addCriterion("property_update_time >", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_update_time >=", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeLessThan(Date value) {
            addCriterion("property_update_time <", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("property_update_time <=", value, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeIn(List<Date> values) {
            addCriterion("property_update_time in", values, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeNotIn(List<Date> values) {
            addCriterion("property_update_time not in", values, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeBetween(Date value1, Date value2) {
            addCriterion("property_update_time between", value1, value2, "property_update_time");
            return (Criteria) this;
        }

        public Criteria andProperty_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("property_update_time not between", value1, value2, "property_update_time");
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