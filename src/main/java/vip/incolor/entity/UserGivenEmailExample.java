package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserGivenEmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserGivenEmailExample() {
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

        public Criteria andUser_given_email_idIsNull() {
            addCriterion("user_given_email_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idIsNotNull() {
            addCriterion("user_given_email_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idEqualTo(Integer value) {
            addCriterion("user_given_email_id =", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idNotEqualTo(Integer value) {
            addCriterion("user_given_email_id <>", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idGreaterThan(Integer value) {
            addCriterion("user_given_email_id >", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_given_email_id >=", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idLessThan(Integer value) {
            addCriterion("user_given_email_id <", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_given_email_id <=", value, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idIn(List<Integer> values) {
            addCriterion("user_given_email_id in", values, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idNotIn(List<Integer> values) {
            addCriterion("user_given_email_id not in", values, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idBetween(Integer value1, Integer value2) {
            addCriterion("user_given_email_id between", value1, value2, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_given_email_id not between", value1, value2, "user_given_email_id");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailIsNull() {
            addCriterion("user_given_email is null");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailIsNotNull() {
            addCriterion("user_given_email is not null");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailEqualTo(String value) {
            addCriterion("user_given_email =", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailNotEqualTo(String value) {
            addCriterion("user_given_email <>", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailGreaterThan(String value) {
            addCriterion("user_given_email >", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailGreaterThanOrEqualTo(String value) {
            addCriterion("user_given_email >=", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailLessThan(String value) {
            addCriterion("user_given_email <", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailLessThanOrEqualTo(String value) {
            addCriterion("user_given_email <=", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailLike(String value) {
            addCriterion("user_given_email like", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailNotLike(String value) {
            addCriterion("user_given_email not like", value, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailIn(List<String> values) {
            addCriterion("user_given_email in", values, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailNotIn(List<String> values) {
            addCriterion("user_given_email not in", values, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailBetween(String value1, String value2) {
            addCriterion("user_given_email between", value1, value2, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_emailNotBetween(String value1, String value2) {
            addCriterion("user_given_email not between", value1, value2, "user_given_email");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeIsNull() {
            addCriterion("user_given_email_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeIsNotNull() {
            addCriterion("user_given_email_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeEqualTo(Date value) {
            addCriterion("user_given_email_create_time =", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeNotEqualTo(Date value) {
            addCriterion("user_given_email_create_time <>", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeGreaterThan(Date value) {
            addCriterion("user_given_email_create_time >", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_given_email_create_time >=", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeLessThan(Date value) {
            addCriterion("user_given_email_create_time <", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("user_given_email_create_time <=", value, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeIn(List<Date> values) {
            addCriterion("user_given_email_create_time in", values, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeNotIn(List<Date> values) {
            addCriterion("user_given_email_create_time not in", values, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeBetween(Date value1, Date value2) {
            addCriterion("user_given_email_create_time between", value1, value2, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("user_given_email_create_time not between", value1, value2, "user_given_email_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeIsNull() {
            addCriterion("user_given_email_update_time is null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeIsNotNull() {
            addCriterion("user_given_email_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeEqualTo(Date value) {
            addCriterion("user_given_email_update_time =", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeNotEqualTo(Date value) {
            addCriterion("user_given_email_update_time <>", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeGreaterThan(Date value) {
            addCriterion("user_given_email_update_time >", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_given_email_update_time >=", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeLessThan(Date value) {
            addCriterion("user_given_email_update_time <", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("user_given_email_update_time <=", value, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeIn(List<Date> values) {
            addCriterion("user_given_email_update_time in", values, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeNotIn(List<Date> values) {
            addCriterion("user_given_email_update_time not in", values, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeBetween(Date value1, Date value2) {
            addCriterion("user_given_email_update_time between", value1, value2, "user_given_email_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_given_email_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("user_given_email_update_time not between", value1, value2, "user_given_email_update_time");
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