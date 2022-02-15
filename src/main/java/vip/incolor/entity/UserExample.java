package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUser_accountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUser_accountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUser_accountEqualTo(String value) {
            addCriterion("user_account =", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountGreaterThan(String value) {
            addCriterion("user_account >", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountLessThan(String value) {
            addCriterion("user_account <", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountLike(String value) {
            addCriterion("user_account like", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountNotLike(String value) {
            addCriterion("user_account not like", value, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountIn(List<String> values) {
            addCriterion("user_account in", values, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_accountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "user_account");
            return (Criteria) this;
        }

        public Criteria andUser_passwordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUser_passwordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUser_passwordEqualTo(String value) {
            addCriterion("user_password =", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordGreaterThan(String value) {
            addCriterion("user_password >", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordLessThan(String value) {
            addCriterion("user_password <", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordLike(String value) {
            addCriterion("user_password like", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordNotLike(String value) {
            addCriterion("user_password not like", value, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordIn(List<String> values) {
            addCriterion("user_password in", values, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_passwordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "user_password");
            return (Criteria) this;
        }

        public Criteria andUser_phoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUser_phoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUser_phoneEqualTo(String value) {
            addCriterion("user_phone =", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneLessThan(String value) {
            addCriterion("user_phone <", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneLike(String value) {
            addCriterion("user_phone like", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneNotLike(String value) {
            addCriterion("user_phone not like", value, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneIn(List<String> values) {
            addCriterion("user_phone in", values, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_phoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "user_phone");
            return (Criteria) this;
        }

        public Criteria andUser_mailIsNull() {
            addCriterion("user_mail is null");
            return (Criteria) this;
        }

        public Criteria andUser_mailIsNotNull() {
            addCriterion("user_mail is not null");
            return (Criteria) this;
        }

        public Criteria andUser_mailEqualTo(String value) {
            addCriterion("user_mail =", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailNotEqualTo(String value) {
            addCriterion("user_mail <>", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailGreaterThan(String value) {
            addCriterion("user_mail >", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailGreaterThanOrEqualTo(String value) {
            addCriterion("user_mail >=", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailLessThan(String value) {
            addCriterion("user_mail <", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailLessThanOrEqualTo(String value) {
            addCriterion("user_mail <=", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailLike(String value) {
            addCriterion("user_mail like", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailNotLike(String value) {
            addCriterion("user_mail not like", value, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailIn(List<String> values) {
            addCriterion("user_mail in", values, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailNotIn(List<String> values) {
            addCriterion("user_mail not in", values, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailBetween(String value1, String value2) {
            addCriterion("user_mail between", value1, value2, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_mailNotBetween(String value1, String value2) {
            addCriterion("user_mail not between", value1, value2, "user_mail");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameIsNull() {
            addCriterion("user_family_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameIsNotNull() {
            addCriterion("user_family_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameEqualTo(String value) {
            addCriterion("user_family_name =", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameNotEqualTo(String value) {
            addCriterion("user_family_name <>", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameGreaterThan(String value) {
            addCriterion("user_family_name >", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_family_name >=", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameLessThan(String value) {
            addCriterion("user_family_name <", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameLessThanOrEqualTo(String value) {
            addCriterion("user_family_name <=", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameLike(String value) {
            addCriterion("user_family_name like", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameNotLike(String value) {
            addCriterion("user_family_name not like", value, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameIn(List<String> values) {
            addCriterion("user_family_name in", values, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameNotIn(List<String> values) {
            addCriterion("user_family_name not in", values, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameBetween(String value1, String value2) {
            addCriterion("user_family_name between", value1, value2, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_family_nameNotBetween(String value1, String value2) {
            addCriterion("user_family_name not between", value1, value2, "user_family_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameIsNull() {
            addCriterion("user_given_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameIsNotNull() {
            addCriterion("user_given_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameEqualTo(String value) {
            addCriterion("user_given_name =", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameNotEqualTo(String value) {
            addCriterion("user_given_name <>", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameGreaterThan(String value) {
            addCriterion("user_given_name >", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_given_name >=", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameLessThan(String value) {
            addCriterion("user_given_name <", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameLessThanOrEqualTo(String value) {
            addCriterion("user_given_name <=", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameLike(String value) {
            addCriterion("user_given_name like", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameNotLike(String value) {
            addCriterion("user_given_name not like", value, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameIn(List<String> values) {
            addCriterion("user_given_name in", values, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameNotIn(List<String> values) {
            addCriterion("user_given_name not in", values, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameBetween(String value1, String value2) {
            addCriterion("user_given_name between", value1, value2, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_given_nameNotBetween(String value1, String value2) {
            addCriterion("user_given_name not between", value1, value2, "user_given_name");
            return (Criteria) this;
        }

        public Criteria andUser_genderIsNull() {
            addCriterion("user_gender is null");
            return (Criteria) this;
        }

        public Criteria andUser_genderIsNotNull() {
            addCriterion("user_gender is not null");
            return (Criteria) this;
        }

        public Criteria andUser_genderEqualTo(Boolean value) {
            addCriterion("user_gender =", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotEqualTo(Boolean value) {
            addCriterion("user_gender <>", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderGreaterThan(Boolean value) {
            addCriterion("user_gender >", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_gender >=", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderLessThan(Boolean value) {
            addCriterion("user_gender <", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderLessThanOrEqualTo(Boolean value) {
            addCriterion("user_gender <=", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderIn(List<Boolean> values) {
            addCriterion("user_gender in", values, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotIn(List<Boolean> values) {
            addCriterion("user_gender not in", values, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderBetween(Boolean value1, Boolean value2) {
            addCriterion("user_gender between", value1, value2, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_gender not between", value1, value2, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_passIsNull() {
            addCriterion("user_pass is null");
            return (Criteria) this;
        }

        public Criteria andUser_passIsNotNull() {
            addCriterion("user_pass is not null");
            return (Criteria) this;
        }

        public Criteria andUser_passEqualTo(Boolean value) {
            addCriterion("user_pass =", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passNotEqualTo(Boolean value) {
            addCriterion("user_pass <>", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passGreaterThan(Boolean value) {
            addCriterion("user_pass >", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_pass >=", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passLessThan(Boolean value) {
            addCriterion("user_pass <", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passLessThanOrEqualTo(Boolean value) {
            addCriterion("user_pass <=", value, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passIn(List<Boolean> values) {
            addCriterion("user_pass in", values, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passNotIn(List<Boolean> values) {
            addCriterion("user_pass not in", values, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passBetween(Boolean value1, Boolean value2) {
            addCriterion("user_pass between", value1, value2, "user_pass");
            return (Criteria) this;
        }

        public Criteria andUser_passNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_pass not between", value1, value2, "user_pass");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeIsNull() {
            addCriterion("out_dated_time is null");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeIsNotNull() {
            addCriterion("out_dated_time is not null");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeEqualTo(Date value) {
            addCriterion("out_dated_time =", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeNotEqualTo(Date value) {
            addCriterion("out_dated_time <>", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeGreaterThan(Date value) {
            addCriterion("out_dated_time >", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_dated_time >=", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeLessThan(Date value) {
            addCriterion("out_dated_time <", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeLessThanOrEqualTo(Date value) {
            addCriterion("out_dated_time <=", value, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeIn(List<Date> values) {
            addCriterion("out_dated_time in", values, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeNotIn(List<Date> values) {
            addCriterion("out_dated_time not in", values, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeBetween(Date value1, Date value2) {
            addCriterion("out_dated_time between", value1, value2, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andOut_dated_timeNotBetween(Date value1, Date value2) {
            addCriterion("out_dated_time not between", value1, value2, "out_dated_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeIsNull() {
            addCriterion("user_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeIsNotNull() {
            addCriterion("user_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeEqualTo(Date value) {
            addCriterion("user_create_time =", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeNotEqualTo(Date value) {
            addCriterion("user_create_time <>", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeGreaterThan(Date value) {
            addCriterion("user_create_time >", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_create_time >=", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeLessThan(Date value) {
            addCriterion("user_create_time <", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("user_create_time <=", value, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeIn(List<Date> values) {
            addCriterion("user_create_time in", values, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeNotIn(List<Date> values) {
            addCriterion("user_create_time not in", values, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeBetween(Date value1, Date value2) {
            addCriterion("user_create_time between", value1, value2, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("user_create_time not between", value1, value2, "user_create_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeIsNull() {
            addCriterion("user_update_time is null");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeIsNotNull() {
            addCriterion("user_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeEqualTo(Date value) {
            addCriterion("user_update_time =", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeNotEqualTo(Date value) {
            addCriterion("user_update_time <>", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeGreaterThan(Date value) {
            addCriterion("user_update_time >", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_update_time >=", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeLessThan(Date value) {
            addCriterion("user_update_time <", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("user_update_time <=", value, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeIn(List<Date> values) {
            addCriterion("user_update_time in", values, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeNotIn(List<Date> values) {
            addCriterion("user_update_time not in", values, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeBetween(Date value1, Date value2) {
            addCriterion("user_update_time between", value1, value2, "user_update_time");
            return (Criteria) this;
        }

        public Criteria andUser_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("user_update_time not between", value1, value2, "user_update_time");
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