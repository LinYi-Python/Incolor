package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarouselExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarouselExample() {
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

        public Criteria andCarousel_idIsNull() {
            addCriterion("carousel_id is null");
            return (Criteria) this;
        }

        public Criteria andCarousel_idIsNotNull() {
            addCriterion("carousel_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel_idEqualTo(Integer value) {
            addCriterion("carousel_id =", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idNotEqualTo(Integer value) {
            addCriterion("carousel_id <>", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idGreaterThan(Integer value) {
            addCriterion("carousel_id >", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("carousel_id >=", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idLessThan(Integer value) {
            addCriterion("carousel_id <", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idLessThanOrEqualTo(Integer value) {
            addCriterion("carousel_id <=", value, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idIn(List<Integer> values) {
            addCriterion("carousel_id in", values, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idNotIn(List<Integer> values) {
            addCriterion("carousel_id not in", values, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idBetween(Integer value1, Integer value2) {
            addCriterion("carousel_id between", value1, value2, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_idNotBetween(Integer value1, Integer value2) {
            addCriterion("carousel_id not between", value1, value2, "carousel_id");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleIsNull() {
            addCriterion("carousel_style is null");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleIsNotNull() {
            addCriterion("carousel_style is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleEqualTo(Boolean value) {
            addCriterion("carousel_style =", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleNotEqualTo(Boolean value) {
            addCriterion("carousel_style <>", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleGreaterThan(Boolean value) {
            addCriterion("carousel_style >", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("carousel_style >=", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleLessThan(Boolean value) {
            addCriterion("carousel_style <", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleLessThanOrEqualTo(Boolean value) {
            addCriterion("carousel_style <=", value, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleIn(List<Boolean> values) {
            addCriterion("carousel_style in", values, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleNotIn(List<Boolean> values) {
            addCriterion("carousel_style not in", values, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleBetween(Boolean value1, Boolean value2) {
            addCriterion("carousel_style between", value1, value2, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_styleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("carousel_style not between", value1, value2, "carousel_style");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathIsNull() {
            addCriterion("carousel_path is null");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathIsNotNull() {
            addCriterion("carousel_path is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathEqualTo(String value) {
            addCriterion("carousel_path =", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathNotEqualTo(String value) {
            addCriterion("carousel_path <>", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathGreaterThan(String value) {
            addCriterion("carousel_path >", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathGreaterThanOrEqualTo(String value) {
            addCriterion("carousel_path >=", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathLessThan(String value) {
            addCriterion("carousel_path <", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathLessThanOrEqualTo(String value) {
            addCriterion("carousel_path <=", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathLike(String value) {
            addCriterion("carousel_path like", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathNotLike(String value) {
            addCriterion("carousel_path not like", value, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathIn(List<String> values) {
            addCriterion("carousel_path in", values, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathNotIn(List<String> values) {
            addCriterion("carousel_path not in", values, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathBetween(String value1, String value2) {
            addCriterion("carousel_path between", value1, value2, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_pathNotBetween(String value1, String value2) {
            addCriterion("carousel_path not between", value1, value2, "carousel_path");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeIsNull() {
            addCriterion("carousel_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeIsNotNull() {
            addCriterion("carousel_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeEqualTo(Date value) {
            addCriterion("carousel_create_time =", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeNotEqualTo(Date value) {
            addCriterion("carousel_create_time <>", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeGreaterThan(Date value) {
            addCriterion("carousel_create_time >", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("carousel_create_time >=", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeLessThan(Date value) {
            addCriterion("carousel_create_time <", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("carousel_create_time <=", value, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeIn(List<Date> values) {
            addCriterion("carousel_create_time in", values, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeNotIn(List<Date> values) {
            addCriterion("carousel_create_time not in", values, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeBetween(Date value1, Date value2) {
            addCriterion("carousel_create_time between", value1, value2, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("carousel_create_time not between", value1, value2, "carousel_create_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeIsNull() {
            addCriterion("carousel_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeIsNotNull() {
            addCriterion("carousel_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeEqualTo(Date value) {
            addCriterion("carousel_update_time =", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeNotEqualTo(Date value) {
            addCriterion("carousel_update_time <>", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeGreaterThan(Date value) {
            addCriterion("carousel_update_time >", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("carousel_update_time >=", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeLessThan(Date value) {
            addCriterion("carousel_update_time <", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("carousel_update_time <=", value, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeIn(List<Date> values) {
            addCriterion("carousel_update_time in", values, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeNotIn(List<Date> values) {
            addCriterion("carousel_update_time not in", values, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeBetween(Date value1, Date value2) {
            addCriterion("carousel_update_time between", value1, value2, "carousel_update_time");
            return (Criteria) this;
        }

        public Criteria andCarousel_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("carousel_update_time not between", value1, value2, "carousel_update_time");
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