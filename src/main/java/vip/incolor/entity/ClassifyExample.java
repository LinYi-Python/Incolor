package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassifyExample() {
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

        public Criteria andClass_idIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClass_idIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClass_idEqualTo(Integer value) {
            addCriterion("class_id =", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idGreaterThan(Integer value) {
            addCriterion("class_id >", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idLessThan(Integer value) {
            addCriterion("class_id <", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idIn(List<Integer> values) {
            addCriterion("class_id in", values, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_idNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "class_id");
            return (Criteria) this;
        }

        public Criteria andClass_nameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClass_nameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClass_nameEqualTo(String value) {
            addCriterion("class_name =", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameGreaterThan(String value) {
            addCriterion("class_name >", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLessThan(String value) {
            addCriterion("class_name <", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLike(String value) {
            addCriterion("class_name like", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotLike(String value) {
            addCriterion("class_name not like", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameIn(List<String> values) {
            addCriterion("class_name in", values, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "class_name");
            return (Criteria) this;
        }

        public Criteria andIs_parentIsNull() {
            addCriterion("is_parent is null");
            return (Criteria) this;
        }

        public Criteria andIs_parentIsNotNull() {
            addCriterion("is_parent is not null");
            return (Criteria) this;
        }

        public Criteria andIs_parentEqualTo(Boolean value) {
            addCriterion("is_parent =", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentNotEqualTo(Boolean value) {
            addCriterion("is_parent <>", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentGreaterThan(Boolean value) {
            addCriterion("is_parent >", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_parent >=", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentLessThan(Boolean value) {
            addCriterion("is_parent <", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_parent <=", value, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentIn(List<Boolean> values) {
            addCriterion("is_parent in", values, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentNotIn(List<Boolean> values) {
            addCriterion("is_parent not in", values, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_parent between", value1, value2, "is_parent");
            return (Criteria) this;
        }

        public Criteria andIs_parentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_parent not between", value1, value2, "is_parent");
            return (Criteria) this;
        }

        public Criteria andParent_idIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParent_idIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParent_idEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idLessThan(Integer value) {
            addCriterion("parent_id <", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parent_id");
            return (Criteria) this;
        }

        public Criteria andParent_idNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parent_id");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeIsNull() {
            addCriterion("class_create_time is null");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeIsNotNull() {
            addCriterion("class_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeEqualTo(Date value) {
            addCriterion("class_create_time =", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeNotEqualTo(Date value) {
            addCriterion("class_create_time <>", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeGreaterThan(Date value) {
            addCriterion("class_create_time >", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("class_create_time >=", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeLessThan(Date value) {
            addCriterion("class_create_time <", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("class_create_time <=", value, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeIn(List<Date> values) {
            addCriterion("class_create_time in", values, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeNotIn(List<Date> values) {
            addCriterion("class_create_time not in", values, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeBetween(Date value1, Date value2) {
            addCriterion("class_create_time between", value1, value2, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("class_create_time not between", value1, value2, "class_create_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeIsNull() {
            addCriterion("class_update_time is null");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeIsNotNull() {
            addCriterion("class_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeEqualTo(Date value) {
            addCriterion("class_update_time =", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeNotEqualTo(Date value) {
            addCriterion("class_update_time <>", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeGreaterThan(Date value) {
            addCriterion("class_update_time >", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("class_update_time >=", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeLessThan(Date value) {
            addCriterion("class_update_time <", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("class_update_time <=", value, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeIn(List<Date> values) {
            addCriterion("class_update_time in", values, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeNotIn(List<Date> values) {
            addCriterion("class_update_time not in", values, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeBetween(Date value1, Date value2) {
            addCriterion("class_update_time between", value1, value2, "class_update_time");
            return (Criteria) this;
        }

        public Criteria andClass_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("class_update_time not between", value1, value2, "class_update_time");
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