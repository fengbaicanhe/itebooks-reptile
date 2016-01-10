package com.poet.reptile.api.dao.query;

import java.util.Collection;

/**
 * @author 徐成龙
 */
public class Condition {

    private String propertyName;
    private Object value;
    private String operator;

    private Condition(String propertyName, Object value, String operator) {
        this.propertyName = propertyName;
        this.value = value;
        this.operator = operator;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getValue() {
        return value;
    }

    public String getOperator() {
        return operator;
    }

    // ==================================================

    public static Condition eq(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.EQ);
    }

    public static Condition like(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.LIKE);
    }

    public static Condition lt(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.LT);
    }

    public static Condition le(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.LE);
    }

    public static Condition gt(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.GT);
    }

    public static Condition ge(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.GE);
    }

    public static Condition ne(String propertyName, Object value) {
        return new Condition(propertyName, value, SqlOperators.NE);
    }

    public static Condition in(String propertyName, Collection<?> value) {
        return new Condition(propertyName, value, SqlOperators.IN);
    }

    public static Condition notIn(String propertyName, Collection<?> value) {
        return new Condition(propertyName, value, SqlOperators.NOT_IN);
    }

    public static Condition isNull(String propertyName) {
        return new Condition(propertyName, SqlOperators.NULL, SqlOperators.IS);
    }

    public static Condition isNotNull(String propertyName) {
        return new Condition(propertyName, SqlOperators.NULL, SqlOperators.IS_NOT);
    }

}
