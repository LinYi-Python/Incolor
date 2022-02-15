package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPictureExample() {
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

        public Criteria andProduct_picture_idIsNull() {
            addCriterion("product_picture_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idIsNotNull() {
            addCriterion("product_picture_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idEqualTo(Integer value) {
            addCriterion("product_picture_id =", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotEqualTo(Integer value) {
            addCriterion("product_picture_id <>", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idGreaterThan(Integer value) {
            addCriterion("product_picture_id >", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_picture_id >=", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idLessThan(Integer value) {
            addCriterion("product_picture_id <", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_picture_id <=", value, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idIn(List<Integer> values) {
            addCriterion("product_picture_id in", values, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotIn(List<Integer> values) {
            addCriterion("product_picture_id not in", values, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idBetween(Integer value1, Integer value2) {
            addCriterion("product_picture_id between", value1, value2, "product_picture_id");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_picture_id not between", value1, value2, "product_picture_id");
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

        public Criteria andProduct_picture_typeIsNull() {
            addCriterion("product_picture_type is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeIsNotNull() {
            addCriterion("product_picture_type is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeEqualTo(Boolean value) {
            addCriterion("product_picture_type =", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeNotEqualTo(Boolean value) {
            addCriterion("product_picture_type <>", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeGreaterThan(Boolean value) {
            addCriterion("product_picture_type >", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("product_picture_type >=", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeLessThan(Boolean value) {
            addCriterion("product_picture_type <", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeLessThanOrEqualTo(Boolean value) {
            addCriterion("product_picture_type <=", value, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeIn(List<Boolean> values) {
            addCriterion("product_picture_type in", values, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeNotIn(List<Boolean> values) {
            addCriterion("product_picture_type not in", values, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeBetween(Boolean value1, Boolean value2) {
            addCriterion("product_picture_type between", value1, value2, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_typeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("product_picture_type not between", value1, value2, "product_picture_type");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathIsNull() {
            addCriterion("product_picture_path is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathIsNotNull() {
            addCriterion("product_picture_path is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathEqualTo(String value) {
            addCriterion("product_picture_path =", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathNotEqualTo(String value) {
            addCriterion("product_picture_path <>", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathGreaterThan(String value) {
            addCriterion("product_picture_path >", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathGreaterThanOrEqualTo(String value) {
            addCriterion("product_picture_path >=", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathLessThan(String value) {
            addCriterion("product_picture_path <", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathLessThanOrEqualTo(String value) {
            addCriterion("product_picture_path <=", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathLike(String value) {
            addCriterion("product_picture_path like", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathNotLike(String value) {
            addCriterion("product_picture_path not like", value, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathIn(List<String> values) {
            addCriterion("product_picture_path in", values, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathNotIn(List<String> values) {
            addCriterion("product_picture_path not in", values, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathBetween(String value1, String value2) {
            addCriterion("product_picture_path between", value1, value2, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_pathNotBetween(String value1, String value2) {
            addCriterion("product_picture_path not between", value1, value2, "product_picture_path");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeIsNull() {
            addCriterion("product_picture_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeIsNotNull() {
            addCriterion("product_picture_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeEqualTo(Date value) {
            addCriterion("product_picture_create_time =", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeNotEqualTo(Date value) {
            addCriterion("product_picture_create_time <>", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeGreaterThan(Date value) {
            addCriterion("product_picture_create_time >", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_picture_create_time >=", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeLessThan(Date value) {
            addCriterion("product_picture_create_time <", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("product_picture_create_time <=", value, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeIn(List<Date> values) {
            addCriterion("product_picture_create_time in", values, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeNotIn(List<Date> values) {
            addCriterion("product_picture_create_time not in", values, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeBetween(Date value1, Date value2) {
            addCriterion("product_picture_create_time between", value1, value2, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("product_picture_create_time not between", value1, value2, "product_picture_create_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeIsNull() {
            addCriterion("product_picture_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeIsNotNull() {
            addCriterion("product_picture_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeEqualTo(Date value) {
            addCriterion("product_picture_update_time =", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeNotEqualTo(Date value) {
            addCriterion("product_picture_update_time <>", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeGreaterThan(Date value) {
            addCriterion("product_picture_update_time >", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_picture_update_time >=", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeLessThan(Date value) {
            addCriterion("product_picture_update_time <", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("product_picture_update_time <=", value, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeIn(List<Date> values) {
            addCriterion("product_picture_update_time in", values, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeNotIn(List<Date> values) {
            addCriterion("product_picture_update_time not in", values, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeBetween(Date value1, Date value2) {
            addCriterion("product_picture_update_time between", value1, value2, "product_picture_update_time");
            return (Criteria) this;
        }

        public Criteria andProduct_picture_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("product_picture_update_time not between", value1, value2, "product_picture_update_time");
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