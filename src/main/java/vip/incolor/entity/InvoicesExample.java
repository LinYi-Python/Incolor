package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoicesExample() {
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

        public Criteria andInvoices_idIsNull() {
            addCriterion("invoices_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_idIsNotNull() {
            addCriterion("invoices_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_idEqualTo(Integer value) {
            addCriterion("invoices_id =", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idNotEqualTo(Integer value) {
            addCriterion("invoices_id <>", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idGreaterThan(Integer value) {
            addCriterion("invoices_id >", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoices_id >=", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idLessThan(Integer value) {
            addCriterion("invoices_id <", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idLessThanOrEqualTo(Integer value) {
            addCriterion("invoices_id <=", value, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idIn(List<Integer> values) {
            addCriterion("invoices_id in", values, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idNotIn(List<Integer> values) {
            addCriterion("invoices_id not in", values, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idBetween(Integer value1, Integer value2) {
            addCriterion("invoices_id between", value1, value2, "invoices_id");
            return (Criteria) this;
        }

        public Criteria andInvoices_idNotBetween(Integer value1, Integer value2) {
            addCriterion("invoices_id not between", value1, value2, "invoices_id");
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

        public Criteria andIs_invoicesIsNull() {
            addCriterion("is_invoices is null");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesIsNotNull() {
            addCriterion("is_invoices is not null");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesEqualTo(Boolean value) {
            addCriterion("is_invoices =", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesNotEqualTo(Boolean value) {
            addCriterion("is_invoices <>", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesGreaterThan(Boolean value) {
            addCriterion("is_invoices >", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_invoices >=", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesLessThan(Boolean value) {
            addCriterion("is_invoices <", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesLessThanOrEqualTo(Boolean value) {
            addCriterion("is_invoices <=", value, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesIn(List<Boolean> values) {
            addCriterion("is_invoices in", values, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesNotIn(List<Boolean> values) {
            addCriterion("is_invoices not in", values, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesBetween(Boolean value1, Boolean value2) {
            addCriterion("is_invoices between", value1, value2, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_invoicesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_invoices not between", value1, value2, "is_invoices");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameIsNull() {
            addCriterion("invoices_personal_name is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameIsNotNull() {
            addCriterion("invoices_personal_name is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameEqualTo(String value) {
            addCriterion("invoices_personal_name =", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameNotEqualTo(String value) {
            addCriterion("invoices_personal_name <>", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameGreaterThan(String value) {
            addCriterion("invoices_personal_name >", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("invoices_personal_name >=", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameLessThan(String value) {
            addCriterion("invoices_personal_name <", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameLessThanOrEqualTo(String value) {
            addCriterion("invoices_personal_name <=", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameLike(String value) {
            addCriterion("invoices_personal_name like", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameNotLike(String value) {
            addCriterion("invoices_personal_name not like", value, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameIn(List<String> values) {
            addCriterion("invoices_personal_name in", values, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameNotIn(List<String> values) {
            addCriterion("invoices_personal_name not in", values, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameBetween(String value1, String value2) {
            addCriterion("invoices_personal_name between", value1, value2, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_personal_nameNotBetween(String value1, String value2) {
            addCriterion("invoices_personal_name not between", value1, value2, "invoices_personal_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameIsNull() {
            addCriterion("invoices_company_name is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameIsNotNull() {
            addCriterion("invoices_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameEqualTo(String value) {
            addCriterion("invoices_company_name =", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameNotEqualTo(String value) {
            addCriterion("invoices_company_name <>", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameGreaterThan(String value) {
            addCriterion("invoices_company_name >", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameGreaterThanOrEqualTo(String value) {
            addCriterion("invoices_company_name >=", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameLessThan(String value) {
            addCriterion("invoices_company_name <", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameLessThanOrEqualTo(String value) {
            addCriterion("invoices_company_name <=", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameLike(String value) {
            addCriterion("invoices_company_name like", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameNotLike(String value) {
            addCriterion("invoices_company_name not like", value, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameIn(List<String> values) {
            addCriterion("invoices_company_name in", values, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameNotIn(List<String> values) {
            addCriterion("invoices_company_name not in", values, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameBetween(String value1, String value2) {
            addCriterion("invoices_company_name between", value1, value2, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_nameNotBetween(String value1, String value2) {
            addCriterion("invoices_company_name not between", value1, value2, "invoices_company_name");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberIsNull() {
            addCriterion("invoices_company_number is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberIsNotNull() {
            addCriterion("invoices_company_number is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberEqualTo(String value) {
            addCriterion("invoices_company_number =", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberNotEqualTo(String value) {
            addCriterion("invoices_company_number <>", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberGreaterThan(String value) {
            addCriterion("invoices_company_number >", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberGreaterThanOrEqualTo(String value) {
            addCriterion("invoices_company_number >=", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberLessThan(String value) {
            addCriterion("invoices_company_number <", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberLessThanOrEqualTo(String value) {
            addCriterion("invoices_company_number <=", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberLike(String value) {
            addCriterion("invoices_company_number like", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberNotLike(String value) {
            addCriterion("invoices_company_number not like", value, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberIn(List<String> values) {
            addCriterion("invoices_company_number in", values, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberNotIn(List<String> values) {
            addCriterion("invoices_company_number not in", values, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberBetween(String value1, String value2) {
            addCriterion("invoices_company_number between", value1, value2, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_company_numberNotBetween(String value1, String value2) {
            addCriterion("invoices_company_number not between", value1, value2, "invoices_company_number");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeIsNull() {
            addCriterion("invoices_create_time is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeIsNotNull() {
            addCriterion("invoices_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeEqualTo(Date value) {
            addCriterion("invoices_create_time =", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeNotEqualTo(Date value) {
            addCriterion("invoices_create_time <>", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeGreaterThan(Date value) {
            addCriterion("invoices_create_time >", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("invoices_create_time >=", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeLessThan(Date value) {
            addCriterion("invoices_create_time <", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("invoices_create_time <=", value, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeIn(List<Date> values) {
            addCriterion("invoices_create_time in", values, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeNotIn(List<Date> values) {
            addCriterion("invoices_create_time not in", values, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeBetween(Date value1, Date value2) {
            addCriterion("invoices_create_time between", value1, value2, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("invoices_create_time not between", value1, value2, "invoices_create_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeIsNull() {
            addCriterion("invoices_update_time is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeIsNotNull() {
            addCriterion("invoices_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeEqualTo(Date value) {
            addCriterion("invoices_update_time =", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeNotEqualTo(Date value) {
            addCriterion("invoices_update_time <>", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeGreaterThan(Date value) {
            addCriterion("invoices_update_time >", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("invoices_update_time >=", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeLessThan(Date value) {
            addCriterion("invoices_update_time <", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("invoices_update_time <=", value, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeIn(List<Date> values) {
            addCriterion("invoices_update_time in", values, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeNotIn(List<Date> values) {
            addCriterion("invoices_update_time not in", values, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeBetween(Date value1, Date value2) {
            addCriterion("invoices_update_time between", value1, value2, "invoices_update_time");
            return (Criteria) this;
        }

        public Criteria andInvoices_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("invoices_update_time not between", value1, value2, "invoices_update_time");
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