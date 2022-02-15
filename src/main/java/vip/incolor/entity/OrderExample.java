package vip.incolor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverIsNull() {
            addCriterion("order_receiver is null");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverIsNotNull() {
            addCriterion("order_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverEqualTo(String value) {
            addCriterion("order_receiver =", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverNotEqualTo(String value) {
            addCriterion("order_receiver <>", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverGreaterThan(String value) {
            addCriterion("order_receiver >", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverGreaterThanOrEqualTo(String value) {
            addCriterion("order_receiver >=", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverLessThan(String value) {
            addCriterion("order_receiver <", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverLessThanOrEqualTo(String value) {
            addCriterion("order_receiver <=", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverLike(String value) {
            addCriterion("order_receiver like", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverNotLike(String value) {
            addCriterion("order_receiver not like", value, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverIn(List<String> values) {
            addCriterion("order_receiver in", values, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverNotIn(List<String> values) {
            addCriterion("order_receiver not in", values, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverBetween(String value1, String value2) {
            addCriterion("order_receiver between", value1, value2, "order_receiver");
            return (Criteria) this;
        }

        public Criteria andOrder_receiverNotBetween(String value1, String value2) {
            addCriterion("order_receiver not between", value1, value2, "order_receiver");
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

        public Criteria andOrder_phoneIsNull() {
            addCriterion("order_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneIsNotNull() {
            addCriterion("order_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneEqualTo(String value) {
            addCriterion("order_phone =", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotEqualTo(String value) {
            addCriterion("order_phone <>", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneGreaterThan(String value) {
            addCriterion("order_phone >", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_phone >=", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLessThan(String value) {
            addCriterion("order_phone <", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLessThanOrEqualTo(String value) {
            addCriterion("order_phone <=", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneLike(String value) {
            addCriterion("order_phone like", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotLike(String value) {
            addCriterion("order_phone not like", value, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneIn(List<String> values) {
            addCriterion("order_phone in", values, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotIn(List<String> values) {
            addCriterion("order_phone not in", values, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneBetween(String value1, String value2) {
            addCriterion("order_phone between", value1, value2, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_phoneNotBetween(String value1, String value2) {
            addCriterion("order_phone not between", value1, value2, "order_phone");
            return (Criteria) this;
        }

        public Criteria andOrder_addressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrder_addressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_addressEqualTo(String value) {
            addCriterion("order_address =", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressGreaterThan(String value) {
            addCriterion("order_address >", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressLessThan(String value) {
            addCriterion("order_address <", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressLike(String value) {
            addCriterion("order_address like", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressNotLike(String value) {
            addCriterion("order_address not like", value, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressIn(List<String> values) {
            addCriterion("order_address in", values, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_addressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "order_address");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeIsNull() {
            addCriterion("order_postalcode is null");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeIsNotNull() {
            addCriterion("order_postalcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeEqualTo(Integer value) {
            addCriterion("order_postalcode =", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeNotEqualTo(Integer value) {
            addCriterion("order_postalcode <>", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeGreaterThan(Integer value) {
            addCriterion("order_postalcode >", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_postalcode >=", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeLessThan(Integer value) {
            addCriterion("order_postalcode <", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeLessThanOrEqualTo(Integer value) {
            addCriterion("order_postalcode <=", value, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeIn(List<Integer> values) {
            addCriterion("order_postalcode in", values, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeNotIn(List<Integer> values) {
            addCriterion("order_postalcode not in", values, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeBetween(Integer value1, Integer value2) {
            addCriterion("order_postalcode between", value1, value2, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_postalcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_postalcode not between", value1, value2, "order_postalcode");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesIsNull() {
            addCriterion("order_create_times is null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesIsNotNull() {
            addCriterion("order_create_times is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesEqualTo(Date value) {
            addCriterion("order_create_times =", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesNotEqualTo(Date value) {
            addCriterion("order_create_times <>", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesGreaterThan(Date value) {
            addCriterion("order_create_times >", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_times >=", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesLessThan(Date value) {
            addCriterion("order_create_times <", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesLessThanOrEqualTo(Date value) {
            addCriterion("order_create_times <=", value, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesIn(List<Date> values) {
            addCriterion("order_create_times in", values, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesNotIn(List<Date> values) {
            addCriterion("order_create_times not in", values, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesBetween(Date value1, Date value2) {
            addCriterion("order_create_times between", value1, value2, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timesNotBetween(Date value1, Date value2) {
            addCriterion("order_create_times not between", value1, value2, "order_create_times");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeIsNull() {
            addCriterion("order_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeIsNotNull() {
            addCriterion("order_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeEqualTo(Date value) {
            addCriterion("order_pay_time =", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeNotEqualTo(Date value) {
            addCriterion("order_pay_time <>", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeGreaterThan(Date value) {
            addCriterion("order_pay_time >", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_time >=", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeLessThan(Date value) {
            addCriterion("order_pay_time <", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_time <=", value, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeIn(List<Date> values) {
            addCriterion("order_pay_time in", values, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeNotIn(List<Date> values) {
            addCriterion("order_pay_time not in", values, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeBetween(Date value1, Date value2) {
            addCriterion("order_pay_time between", value1, value2, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_pay_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_time not between", value1, value2, "order_pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeIsNull() {
            addCriterion("order_estimate_deliver_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeIsNotNull() {
            addCriterion("order_estimate_deliver_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeEqualTo(Date value) {
            addCriterion("order_estimate_deliver_time =", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeNotEqualTo(Date value) {
            addCriterion("order_estimate_deliver_time <>", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeGreaterThan(Date value) {
            addCriterion("order_estimate_deliver_time >", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_estimate_deliver_time >=", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeLessThan(Date value) {
            addCriterion("order_estimate_deliver_time <", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_estimate_deliver_time <=", value, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeIn(List<Date> values) {
            addCriterion("order_estimate_deliver_time in", values, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeNotIn(List<Date> values) {
            addCriterion("order_estimate_deliver_time not in", values, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeBetween(Date value1, Date value2) {
            addCriterion("order_estimate_deliver_time between", value1, value2, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_estimate_deliver_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_estimate_deliver_time not between", value1, value2, "order_estimate_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeIsNull() {
            addCriterion("order_real_deliver_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeIsNotNull() {
            addCriterion("order_real_deliver_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeEqualTo(Date value) {
            addCriterion("order_real_deliver_time =", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeNotEqualTo(Date value) {
            addCriterion("order_real_deliver_time <>", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeGreaterThan(Date value) {
            addCriterion("order_real_deliver_time >", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_real_deliver_time >=", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeLessThan(Date value) {
            addCriterion("order_real_deliver_time <", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_real_deliver_time <=", value, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeIn(List<Date> values) {
            addCriterion("order_real_deliver_time in", values, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeNotIn(List<Date> values) {
            addCriterion("order_real_deliver_time not in", values, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeBetween(Date value1, Date value2) {
            addCriterion("order_real_deliver_time between", value1, value2, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_real_deliver_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_real_deliver_time not between", value1, value2, "order_real_deliver_time");
            return (Criteria) this;
        }

        public Criteria andOrder_stateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrder_stateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_stateEqualTo(Boolean value) {
            addCriterion("order_state =", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateNotEqualTo(Boolean value) {
            addCriterion("order_state <>", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateGreaterThan(Boolean value) {
            addCriterion("order_state >", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_state >=", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateLessThan(Boolean value) {
            addCriterion("order_state <", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateLessThanOrEqualTo(Boolean value) {
            addCriterion("order_state <=", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateIn(List<Boolean> values) {
            addCriterion("order_state in", values, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateNotIn(List<Boolean> values) {
            addCriterion("order_state not in", values, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateBetween(Boolean value1, Boolean value2) {
            addCriterion("order_state between", value1, value2, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_stateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_state not between", value1, value2, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(String value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(String value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(String value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLike(String value) {
            addCriterion("order_status like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotLike(String value) {
            addCriterion("order_status not like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<String> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThan(Date value) {
            addCriterion("order_create_time <", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIsNull() {
            addCriterion("order_update_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIsNotNull() {
            addCriterion("order_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeEqualTo(Date value) {
            addCriterion("order_update_time =", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotEqualTo(Date value) {
            addCriterion("order_update_time <>", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeGreaterThan(Date value) {
            addCriterion("order_update_time >", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_update_time >=", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeLessThan(Date value) {
            addCriterion("order_update_time <", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_update_time <=", value, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeIn(List<Date> values) {
            addCriterion("order_update_time in", values, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotIn(List<Date> values) {
            addCriterion("order_update_time not in", values, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeBetween(Date value1, Date value2) {
            addCriterion("order_update_time between", value1, value2, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andOrder_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_update_time not between", value1, value2, "order_update_time");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesIsNull() {
            addCriterion("is_need_invoices is null");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesIsNotNull() {
            addCriterion("is_need_invoices is not null");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesEqualTo(Boolean value) {
            addCriterion("is_need_invoices =", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesNotEqualTo(Boolean value) {
            addCriterion("is_need_invoices <>", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesGreaterThan(Boolean value) {
            addCriterion("is_need_invoices >", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_need_invoices >=", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesLessThan(Boolean value) {
            addCriterion("is_need_invoices <", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesLessThanOrEqualTo(Boolean value) {
            addCriterion("is_need_invoices <=", value, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesIn(List<Boolean> values) {
            addCriterion("is_need_invoices in", values, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesNotIn(List<Boolean> values) {
            addCriterion("is_need_invoices not in", values, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesBetween(Boolean value1, Boolean value2) {
            addCriterion("is_need_invoices between", value1, value2, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andIs_need_invoicesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_need_invoices not between", value1, value2, "is_need_invoices");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeIsNull() {
            addCriterion("invoices_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeIsNotNull() {
            addCriterion("invoices_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeEqualTo(Boolean value) {
            addCriterion("invoices_type =", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeNotEqualTo(Boolean value) {
            addCriterion("invoices_type <>", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeGreaterThan(Boolean value) {
            addCriterion("invoices_type >", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("invoices_type >=", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeLessThan(Boolean value) {
            addCriterion("invoices_type <", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeLessThanOrEqualTo(Boolean value) {
            addCriterion("invoices_type <=", value, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeIn(List<Boolean> values) {
            addCriterion("invoices_type in", values, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeNotIn(List<Boolean> values) {
            addCriterion("invoices_type not in", values, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeBetween(Boolean value1, Boolean value2) {
            addCriterion("invoices_type between", value1, value2, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andInvoices_typeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("invoices_type not between", value1, value2, "invoices_type");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberIsNull() {
            addCriterion("order_express_number is null");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberIsNotNull() {
            addCriterion("order_express_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberEqualTo(Integer value) {
            addCriterion("order_express_number =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberNotEqualTo(Integer value) {
            addCriterion("order_express_number <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberGreaterThan(Integer value) {
            addCriterion("order_express_number >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_express_number >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberLessThan(Integer value) {
            addCriterion("order_express_number <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberLessThanOrEqualTo(Integer value) {
            addCriterion("order_express_number <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberIn(List<Integer> values) {
            addCriterion("order_express_number in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberNotIn(List<Integer> values) {
            addCriterion("order_express_number not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberBetween(Integer value1, Integer value2) {
            addCriterion("order_express_number between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_express_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_express_number not between", value1, value2, "order_id");
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
