package com.poet.reptile.api.dao.test;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.ResultLimit;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;
import com.poet.reptile.api.dao.support.AbstractGeneralDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu on 2016/1/7.
 */
public class TestDaoImpl extends AbstractGeneralDao<User> {
    @Override
    protected String getSelectClause() {
        return EMPTY_STRING;
    }

    @Override
    protected String getFromClause() {
        StringBuilder sb = new StringBuilder();
        sb.append(FROM).append(SPACE).append(entityClass.getName());

        return sb.toString();
    }


    @Override
    public User get(Serializable id) {
        return null;
    }

    @Override
    public User getLazily(Serializable id) {
        return null;
    }

    @Override
    public User save(User model) {
        return null;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public List<User> findAll(Order... orders) {
        return null;
    }

    @Override
    public List<User> findAllWithLimit(ResultLimit limit,Order... orders) {
        return null;
    }

    @Override
    public List<User> findByConditions(List<Condition> conditions, ConditionValueFilter filter, Order... orders) {
        return null;
    }

    @Override
    public List<User> findByConditions(List<Condition> conditions, Order... orders) {
        return null;
    }

    @Override
    public List<User> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, Order... orders) {
        return null;
    }

    @Override
    public List<User> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, ConditionValueFilter filter,Order... orders) {

        String sql = getQueryString(conditions,filter);
        System.out.println(sql);

        Object[] objs = getQueryParams(conditions);

        for( Object o : objs )
            System.out.println(o);

        return null;
    }

    @Override
    public User findOne(List<Condition> conditions) {


        return null;
    }
}
