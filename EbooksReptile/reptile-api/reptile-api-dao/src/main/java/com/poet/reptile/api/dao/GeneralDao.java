package com.poet.reptile.api.dao;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.ResultLimit;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;

import java.io.Serializable;
import java.util.List;

public interface GeneralDao<T> {

    T get(Serializable id);

    T getLazily(Serializable id);

    T save(T model);

    boolean delete(T model);

    boolean update(T model);

    List<T> findAll(Order... orders);

    List<T> findAllWithLimit(ResultLimit limit,Order... orders);

    List<T> findByConditions(List<Condition> conditions, ConditionValueFilter filter,Order... orders);

    List<T> findByConditions(List<Condition> conditions,Order... orders);

    List<T> findByConditionsWithLimit(ResultLimit limit,List<Condition> conditions,Order... orders);

    List<T> findByConditionsWithLimit(ResultLimit limit,List<Condition> conditions,ConditionValueFilter filter,Order... orders);

    T findOne(List<Condition> conditions);
}
