package com.czk.domain;

import java.util.ArrayList;
import java.util.List;

public class SchedulerJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulerJobExample() {
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

        public Criteria andJobidIsNull() {
            addCriterion("jobid is null");
            return (Criteria) this;
        }

        public Criteria andJobidIsNotNull() {
            addCriterion("jobid is not null");
            return (Criteria) this;
        }

        public Criteria andJobidEqualTo(Long value) {
            addCriterion("jobid =", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotEqualTo(Long value) {
            addCriterion("jobid <>", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThan(Long value) {
            addCriterion("jobid >", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThanOrEqualTo(Long value) {
            addCriterion("jobid >=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThan(Long value) {
            addCriterion("jobid <", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThanOrEqualTo(Long value) {
            addCriterion("jobid <=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidIn(List<Long> values) {
            addCriterion("jobid in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotIn(List<Long> values) {
            addCriterion("jobid not in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidBetween(Long value1, Long value2) {
            addCriterion("jobid between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotBetween(Long value1, Long value2) {
            addCriterion("jobid not between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNull() {
            addCriterion("jobname is null");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNotNull() {
            addCriterion("jobname is not null");
            return (Criteria) this;
        }

        public Criteria andJobnameEqualTo(String value) {
            addCriterion("jobname =", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotEqualTo(String value) {
            addCriterion("jobname <>", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThan(String value) {
            addCriterion("jobname >", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("jobname >=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThan(String value) {
            addCriterion("jobname <", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThanOrEqualTo(String value) {
            addCriterion("jobname <=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLike(String value) {
            addCriterion("jobname like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotLike(String value) {
            addCriterion("jobname not like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameIn(List<String> values) {
            addCriterion("jobname in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotIn(List<String> values) {
            addCriterion("jobname not in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameBetween(String value1, String value2) {
            addCriterion("jobname between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotBetween(String value1, String value2) {
            addCriterion("jobname not between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobgroupIsNull() {
            addCriterion("jobgroup is null");
            return (Criteria) this;
        }

        public Criteria andJobgroupIsNotNull() {
            addCriterion("jobgroup is not null");
            return (Criteria) this;
        }

        public Criteria andJobgroupEqualTo(String value) {
            addCriterion("jobgroup =", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotEqualTo(String value) {
            addCriterion("jobgroup <>", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupGreaterThan(String value) {
            addCriterion("jobgroup >", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupGreaterThanOrEqualTo(String value) {
            addCriterion("jobgroup >=", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLessThan(String value) {
            addCriterion("jobgroup <", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLessThanOrEqualTo(String value) {
            addCriterion("jobgroup <=", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLike(String value) {
            addCriterion("jobgroup like", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotLike(String value) {
            addCriterion("jobgroup not like", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupIn(List<String> values) {
            addCriterion("jobgroup in", values, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotIn(List<String> values) {
            addCriterion("jobgroup not in", values, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupBetween(String value1, String value2) {
            addCriterion("jobgroup between", value1, value2, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotBetween(String value1, String value2) {
            addCriterion("jobgroup not between", value1, value2, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobstatusIsNull() {
            addCriterion("jobstatus is null");
            return (Criteria) this;
        }

        public Criteria andJobstatusIsNotNull() {
            addCriterion("jobstatus is not null");
            return (Criteria) this;
        }

        public Criteria andJobstatusEqualTo(String value) {
            addCriterion("jobstatus =", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotEqualTo(String value) {
            addCriterion("jobstatus <>", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusGreaterThan(String value) {
            addCriterion("jobstatus >", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusGreaterThanOrEqualTo(String value) {
            addCriterion("jobstatus >=", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLessThan(String value) {
            addCriterion("jobstatus <", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLessThanOrEqualTo(String value) {
            addCriterion("jobstatus <=", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLike(String value) {
            addCriterion("jobstatus like", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotLike(String value) {
            addCriterion("jobstatus not like", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusIn(List<String> values) {
            addCriterion("jobstatus in", values, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotIn(List<String> values) {
            addCriterion("jobstatus not in", values, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusBetween(String value1, String value2) {
            addCriterion("jobstatus between", value1, value2, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotBetween(String value1, String value2) {
            addCriterion("jobstatus not between", value1, value2, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIsNull() {
            addCriterion("cronexpression is null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIsNotNull() {
            addCriterion("cronexpression is not null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionEqualTo(String value) {
            addCriterion("cronexpression =", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotEqualTo(String value) {
            addCriterion("cronexpression <>", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThan(String value) {
            addCriterion("cronexpression >", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cronexpression >=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThan(String value) {
            addCriterion("cronexpression <", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThanOrEqualTo(String value) {
            addCriterion("cronexpression <=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLike(String value) {
            addCriterion("cronexpression like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotLike(String value) {
            addCriterion("cronexpression not like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIn(List<String> values) {
            addCriterion("cronexpression in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotIn(List<String> values) {
            addCriterion("cronexpression not in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionBetween(String value1, String value2) {
            addCriterion("cronexpression between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotBetween(String value1, String value2) {
            addCriterion("cronexpression not between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andQuartzclassIsNull() {
            addCriterion("quartzclass is null");
            return (Criteria) this;
        }

        public Criteria andQuartzclassIsNotNull() {
            addCriterion("quartzclass is not null");
            return (Criteria) this;
        }

        public Criteria andQuartzclassEqualTo(String value) {
            addCriterion("quartzclass =", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassNotEqualTo(String value) {
            addCriterion("quartzclass <>", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassGreaterThan(String value) {
            addCriterion("quartzclass >", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassGreaterThanOrEqualTo(String value) {
            addCriterion("quartzclass >=", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassLessThan(String value) {
            addCriterion("quartzclass <", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassLessThanOrEqualTo(String value) {
            addCriterion("quartzclass <=", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassLike(String value) {
            addCriterion("quartzclass like", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassNotLike(String value) {
            addCriterion("quartzclass not like", value, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassIn(List<String> values) {
            addCriterion("quartzclass in", values, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassNotIn(List<String> values) {
            addCriterion("quartzclass not in", values, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassBetween(String value1, String value2) {
            addCriterion("quartzclass between", value1, value2, "quartzclass");
            return (Criteria) this;
        }

        public Criteria andQuartzclassNotBetween(String value1, String value2) {
            addCriterion("quartzclass not between", value1, value2, "quartzclass");
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