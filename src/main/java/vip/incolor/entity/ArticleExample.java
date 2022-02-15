package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticle_idIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticle_idIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_idEqualTo(Integer value) {
            addCriterion("article_id =", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idGreaterThan(Integer value) {
            addCriterion("article_id >", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLessThan(Integer value) {
            addCriterion("article_id <", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idIn(List<Integer> values) {
            addCriterion("article_id in", values, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_lableIsNull() {
            addCriterion("article_lable is null");
            return (Criteria) this;
        }

        public Criteria andArticle_lableIsNotNull() {
            addCriterion("article_lable is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_lableEqualTo(String value) {
            addCriterion("article_lable =", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableNotEqualTo(String value) {
            addCriterion("article_lable <>", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableGreaterThan(String value) {
            addCriterion("article_lable >", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableGreaterThanOrEqualTo(String value) {
            addCriterion("article_lable >=", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableLessThan(String value) {
            addCriterion("article_lable <", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableLessThanOrEqualTo(String value) {
            addCriterion("article_lable <=", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableLike(String value) {
            addCriterion("article_lable like", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableNotLike(String value) {
            addCriterion("article_lable not like", value, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableIn(List<String> values) {
            addCriterion("article_lable in", values, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableNotIn(List<String> values) {
            addCriterion("article_lable not in", values, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableBetween(String value1, String value2) {
            addCriterion("article_lable between", value1, value2, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_lableNotBetween(String value1, String value2) {
            addCriterion("article_lable not between", value1, value2, "article_lable");
            return (Criteria) this;
        }

        public Criteria andArticle_titleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticle_titleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_titleEqualTo(String value) {
            addCriterion("article_title =", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleGreaterThan(String value) {
            addCriterion("article_title >", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLessThan(String value) {
            addCriterion("article_title <", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLike(String value) {
            addCriterion("article_title like", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotLike(String value) {
            addCriterion("article_title not like", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleIn(List<String> values) {
            addCriterion("article_title in", values, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureIsNull() {
            addCriterion("article_picture is null");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureIsNotNull() {
            addCriterion("article_picture is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureEqualTo(String value) {
            addCriterion("article_picture =", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureNotEqualTo(String value) {
            addCriterion("article_picture <>", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureGreaterThan(String value) {
            addCriterion("article_picture >", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureGreaterThanOrEqualTo(String value) {
            addCriterion("article_picture >=", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureLessThan(String value) {
            addCriterion("article_picture <", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureLessThanOrEqualTo(String value) {
            addCriterion("article_picture <=", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureLike(String value) {
            addCriterion("article_picture like", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureNotLike(String value) {
            addCriterion("article_picture not like", value, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureIn(List<String> values) {
            addCriterion("article_picture in", values, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureNotIn(List<String> values) {
            addCriterion("article_picture not in", values, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureBetween(String value1, String value2) {
            addCriterion("article_picture between", value1, value2, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_pictureNotBetween(String value1, String value2) {
            addCriterion("article_picture not between", value1, value2, "article_picture");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeIsNull() {
            addCriterion("article_create_time is null");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeIsNotNull() {
            addCriterion("article_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeEqualTo(Date value) {
            addCriterion("article_create_time =", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeNotEqualTo(Date value) {
            addCriterion("article_create_time <>", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeGreaterThan(Date value) {
            addCriterion("article_create_time >", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_create_time >=", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeLessThan(Date value) {
            addCriterion("article_create_time <", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("article_create_time <=", value, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeIn(List<Date> values) {
            addCriterion("article_create_time in", values, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeNotIn(List<Date> values) {
            addCriterion("article_create_time not in", values, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeBetween(Date value1, Date value2) {
            addCriterion("article_create_time between", value1, value2, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("article_create_time not between", value1, value2, "article_create_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeIsNull() {
            addCriterion("article_update_time is null");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeIsNotNull() {
            addCriterion("article_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeEqualTo(Date value) {
            addCriterion("article_update_time =", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeNotEqualTo(Date value) {
            addCriterion("article_update_time <>", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeGreaterThan(Date value) {
            addCriterion("article_update_time >", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_update_time >=", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeLessThan(Date value) {
            addCriterion("article_update_time <", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("article_update_time <=", value, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeIn(List<Date> values) {
            addCriterion("article_update_time in", values, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeNotIn(List<Date> values) {
            addCriterion("article_update_time not in", values, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeBetween(Date value1, Date value2) {
            addCriterion("article_update_time between", value1, value2, "article_update_time");
            return (Criteria) this;
        }

        public Criteria andArticle_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("article_update_time not between", value1, value2, "article_update_time");
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