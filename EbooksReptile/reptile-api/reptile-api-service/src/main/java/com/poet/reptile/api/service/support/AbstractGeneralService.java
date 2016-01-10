package com.poet.reptile.api.service.support;

import com.poet.reptile.api.dao.GeneralDao;
import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.ResultLimit;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;
import com.poet.reptile.api.service.GeneralService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu on 2016/1/8.
 */
public class AbstractGeneralService<T> implements GeneralService<T> {

    protected GeneralDao<T> generalDao;

    public void setGeneralDao(GeneralDao<T> generalDao) {
        this.generalDao = generalDao;
    }

    @Override
    public T get(Serializable id) {
        return generalDao.get(id);
    }

    @Override
    public T getLazily(Serializable id) {
        return generalDao.getLazily(id);
    }

    @Override
    public T save(T model) {
        return generalDao.save(model);
    }

    @Override
    public boolean delete(T model) {
        return generalDao.delete(model);
    }

    @Override
    public boolean update(T model) {
        return generalDao.update(model);
    }

    @Override
    public List<T> findAll(Order... orders) {
        return generalDao.findAll(orders);
    }

    @Override
    public List<T> findAllWithLimit(ResultLimit limit, Order... orders) {
        return generalDao.findAllWithLimit(limit, orders);
    }

    @Override
    public List<T> findByConditions(List<Condition> conditions, ConditionValueFilter filter, Order... orders) {
        return generalDao.findByConditions(conditions,filter,orders);
    }

    @Override
    public List<T> findByConditions(List<Condition> conditions, Order... orders) {
        return generalDao.findByConditions(conditions, orders);
    }

    @Override
    public List<T> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, Order... orders) {
        return generalDao.findByConditionsWithLimit(limit,conditions,orders);
    }

    @Override
    public List<T> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, ConditionValueFilter filter, Order... orders) {
        return generalDao.findByConditionsWithLimit(limit,conditions,filter,orders);
    }

    @Override
    public T findOne(List<Condition> conditions) {
        return generalDao.findOne(conditions);
    }
}
