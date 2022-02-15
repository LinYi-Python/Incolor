package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerExample() {
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

        public Criteria andManager_idIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManager_idIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManager_idEqualTo(Integer value) {
            addCriterion("manager_id =", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idLessThan(Integer value) {
            addCriterion("manager_id <", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idIn(List<Integer> values) {
            addCriterion("manager_id in", values, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_idNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "manager_id");
            return (Criteria) this;
        }

        public Criteria andManager_accountIsNull() {
            addCriterion("manager_account is null");
            return (Criteria) this;
        }

        public Criteria andManager_accountIsNotNull() {
            addCriterion("manager_account is not null");
            return (Criteria) this;
        }

        public Criteria andManager_accountEqualTo(String value) {
            addCriterion("manager_account =", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountNotEqualTo(String value) {
            addCriterion("manager_account <>", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountGreaterThan(String value) {
            addCriterion("manager_account >", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountGreaterThanOrEqualTo(String value) {
            addCriterion("manager_account >=", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountLessThan(String value) {
            addCriterion("manager_account <", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountLessThanOrEqualTo(String value) {
            addCriterion("manager_account <=", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountLike(String value) {
            addCriterion("manager_account like", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountNotLike(String value) {
            addCriterion("manager_account not like", value, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountIn(List<String> values) {
            addCriterion("manager_account in", values, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountNotIn(List<String> values) {
            addCriterion("manager_account not in", values, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountBetween(String value1, String value2) {
            addCriterion("manager_account between", value1, value2, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_accountNotBetween(String value1, String value2) {
            addCriterion("manager_account not between", value1, value2, "manager_account");
            return (Criteria) this;
        }

        public Criteria andManager_passwordIsNull() {
            addCriterion("manager_password is null");
            return (Criteria) this;
        }

        public Criteria andManager_passwordIsNotNull() {
            addCriterion("manager_password is not null");
            return (Criteria) this;
        }

        public Criteria andManager_passwordEqualTo(String value) {
            addCriterion("manager_password =", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordNotEqualTo(String value) {
            addCriterion("manager_password <>", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordGreaterThan(String value) {
            addCriterion("manager_password >", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("manager_password >=", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordLessThan(String value) {
            addCriterion("manager_password <", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordLessThanOrEqualTo(String value) {
            addCriterion("manager_password <=", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordLike(String value) {
            addCriterion("manager_password like", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordNotLike(String value) {
            addCriterion("manager_password not like", value, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordIn(List<String> values) {
            addCriterion("manager_password in", values, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordNotIn(List<String> values) {
            addCriterion("manager_password not in", values, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordBetween(String value1, String value2) {
            addCriterion("manager_password between", value1, value2, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_passwordNotBetween(String value1, String value2) {
            addCriterion("manager_password not between", value1, value2, "manager_password");
            return (Criteria) this;
        }

        public Criteria andManager_levelIsNull() {
            addCriterion("manager_level is null");
            return (Criteria) this;
        }

        public Criteria andManager_levelIsNotNull() {
            addCriterion("manager_level is not null");
            return (Criteria) this;
        }

        public Criteria andManager_levelEqualTo(Byte value) {
            addCriterion("manager_level =", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelNotEqualTo(Byte value) {
            addCriterion("manager_level <>", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelGreaterThan(Byte value) {
            addCriterion("manager_level >", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelGreaterThanOrEqualTo(Byte value) {
            addCriterion("manager_level >=", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelLessThan(Byte value) {
            addCriterion("manager_level <", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelLessThanOrEqualTo(Byte value) {
            addCriterion("manager_level <=", value, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelIn(List<Byte> values) {
            addCriterion("manager_level in", values, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelNotIn(List<Byte> values) {
            addCriterion("manager_level not in", values, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelBetween(Byte value1, Byte value2) {
            addCriterion("manager_level between", value1, value2, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_levelNotBetween(Byte value1, Byte value2) {
            addCriterion("manager_level not between", value1, value2, "manager_level");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeIsNull() {
            addCriterion("manager_create_time is null");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeIsNotNull() {
            addCriterion("manager_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeEqualTo(Date value) {
            addCriterion("manager_create_time =", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeNotEqualTo(Date value) {
            addCriterion("manager_create_time <>", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeGreaterThan(Date value) {
            addCriterion("manager_create_time >", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_create_time >=", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeLessThan(Date value) {
            addCriterion("manager_create_time <", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("manager_create_time <=", value, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeIn(List<Date> values) {
            addCriterion("manager_create_time in", values, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeNotIn(List<Date> values) {
            addCriterion("manager_create_time not in", values, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeBetween(Date value1, Date value2) {
            addCriterion("manager_create_time between", value1, value2, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("manager_create_time not between", value1, value2, "manager_create_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeIsNull() {
            addCriterion("manager_update_time is null");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeIsNotNull() {
            addCriterion("manager_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeEqualTo(Date value) {
            addCriterion("manager_update_time =", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeNotEqualTo(Date value) {
            addCriterion("manager_update_time <>", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeGreaterThan(Date value) {
            addCriterion("manager_update_time >", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_update_time >=", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeLessThan(Date value) {
            addCriterion("manager_update_time <", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("manager_update_time <=", value, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeIn(List<Date> values) {
            addCriterion("manager_update_time in", values, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeNotIn(List<Date> values) {
            addCriterion("manager_update_time not in", values, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeBetween(Date value1, Date value2) {
            addCriterion("manager_update_time between", value1, value2, "manager_update_time");
            return (Criteria) this;
        }

        public Criteria andManager_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("manager_update_time not between", value1, value2, "manager_update_time");
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