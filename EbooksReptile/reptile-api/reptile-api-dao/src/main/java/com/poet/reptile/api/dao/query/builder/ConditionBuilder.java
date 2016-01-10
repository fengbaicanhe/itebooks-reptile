package com.poet.reptile.api.dao.query.builder;


import com.poet.reptile.api.dao.query.Condition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ConditionBuilder {

    private ConditionBuilder(){}

    private List<Condition> conditions = new ArrayList<>(0);

    public ConditionBuilder eq(String propertyName, Object value) {
        Condition con = Condition.eq(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder like(String propertyName, Object value) {
        Condition con = Condition.like(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder lt(String propertyName, Object value) {
        Condition con = Condition.lt(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder le(String propertyName, Object value) {
        Condition con = Condition.le(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder gt(String propertyName, Object value) {
        Condition con = Condition.gt(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder ge(String propertyName, Object value) {
        Condition con = Condition.ge(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder ne(String propertyName, Object value) {
        Condition con = Condition.ne(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder in(String propertyName, Collection<?> value) {
        Condition con = Condition.in(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder notIn(String propertyName, Collection<?> value) {
        Condition con = Condition.notIn(propertyName,value);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder isNull(String propertyName) {
        Condition con = Condition.isNull(propertyName);
        conditions.add(con);
        return this;
    }

    public ConditionBuilder isNotNull(String propertyName) {
        Condition con = Condition.isNotNull(propertyName);
        conditions.add(con);
        return this;
    }

    public List<Condition> build(){
        return this.conditions;
    }

    public static ConditionBuilder makeContidions(){
        return new ConditionBuilder();
    }
}
