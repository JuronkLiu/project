package com.lzr.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZhangWuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhangWuExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andZwidIsNull() {
            addCriterion("zwid is null");
            return (Criteria) this;
        }

        public Criteria andZwidIsNotNull() {
            addCriterion("zwid is not null");
            return (Criteria) this;
        }

        public Criteria andZwidEqualTo(Integer value) {
            addCriterion("zwid =", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidNotEqualTo(Integer value) {
            addCriterion("zwid <>", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidGreaterThan(Integer value) {
            addCriterion("zwid >", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zwid >=", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidLessThan(Integer value) {
            addCriterion("zwid <", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidLessThanOrEqualTo(Integer value) {
            addCriterion("zwid <=", value, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidIn(List<Integer> values) {
            addCriterion("zwid in", values, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidNotIn(List<Integer> values) {
            addCriterion("zwid not in", values, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidBetween(Integer value1, Integer value2) {
            addCriterion("zwid between", value1, value2, "zwid");
            return (Criteria) this;
        }

        public Criteria andZwidNotBetween(Integer value1, Integer value2) {
            addCriterion("zwid not between", value1, value2, "zwid");
            return (Criteria) this;
        }

        public Criteria andFlnameIsNull() {
            addCriterion("flname is null");
            return (Criteria) this;
        }

        public Criteria andFlnameIsNotNull() {
            addCriterion("flname is not null");
            return (Criteria) this;
        }

        public Criteria andFlnameEqualTo(String value) {
            addCriterion("flname =", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotEqualTo(String value) {
            addCriterion("flname <>", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameGreaterThan(String value) {
            addCriterion("flname >", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameGreaterThanOrEqualTo(String value) {
            addCriterion("flname >=", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLessThan(String value) {
            addCriterion("flname <", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLessThanOrEqualTo(String value) {
            addCriterion("flname <=", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameLike(String value) {
            addCriterion("flname like", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotLike(String value) {
            addCriterion("flname not like", value, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameIn(List<String> values) {
            addCriterion("flname in", values, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotIn(List<String> values) {
            addCriterion("flname not in", values, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameBetween(String value1, String value2) {
            addCriterion("flname between", value1, value2, "flname");
            return (Criteria) this;
        }

        public Criteria andFlnameNotBetween(String value1, String value2) {
            addCriterion("flname not between", value1, value2, "flname");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andZhanghuIsNull() {
            addCriterion("zhangHu is null");
            return (Criteria) this;
        }

        public Criteria andZhanghuIsNotNull() {
            addCriterion("zhangHu is not null");
            return (Criteria) this;
        }

        public Criteria andZhanghuEqualTo(String value) {
            addCriterion("zhangHu =", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotEqualTo(String value) {
            addCriterion("zhangHu <>", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuGreaterThan(String value) {
            addCriterion("zhangHu >", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuGreaterThanOrEqualTo(String value) {
            addCriterion("zhangHu >=", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLessThan(String value) {
            addCriterion("zhangHu <", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLessThanOrEqualTo(String value) {
            addCriterion("zhangHu <=", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLike(String value) {
            addCriterion("zhangHu like", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotLike(String value) {
            addCriterion("zhangHu not like", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuIn(List<String> values) {
            addCriterion("zhangHu in", values, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotIn(List<String> values) {
            addCriterion("zhangHu not in", values, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuBetween(String value1, String value2) {
            addCriterion("zhangHu between", value1, value2, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotBetween(String value1, String value2) {
            addCriterion("zhangHu not between", value1, value2, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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