package com.poet.reptile.dao.hs;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.ResultLimit;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;
import com.poet.reptile.api.dao.support.AbstractGeneralDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AbstractHiberanteDao<T> extends AbstractGeneralDao<T> {


    private HibernateTemplate hibernateTemplate;

    private String fromClauseCache = null;
    private final Object fromCacheMonitor = new Object();

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    protected String getSelectClause() {
        return SPACE;
    }

    @Override
    protected String getFromClause() {

        if (fromClauseCache == null) {
            synchronized (fromCacheMonitor) {
                if (fromClauseCache == null)
                    fromClauseCache = new StringBuilder().append(FROM).append(SPACE).append(entityClass.getName()).toString();
            }
        }

        return fromClauseCache;
    }

    @Override
    public T get(Serializable id) {
        T result = null;
        try {
            result = hibernateTemplate.get(entityClass, id);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public T getLazily(Serializable id) {

        T result = null;
        try {
            result = hibernateTemplate.load(entityClass, id);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public T save(T model) {

        try {
            hibernateTemplate.save(model);
        } catch (DataAccessException ex){
            ex.printStackTrace();
        }

        return model;
    }

    @Override
    public boolean delete(T model) {
        boolean deleteFlag = false;
        try {
            hibernateTemplate.delete(model);
            deleteFlag = true;
        } catch (DataAccessException ex){
            ex.printStackTrace();
        }

        return deleteFlag;
    }

    @Override
    public boolean update(T model) {
        boolean updateFlag = false;
        try {
            hibernateTemplate.update(model);
            updateFlag = true;
        } catch (DataAccessException ex){
            ex.printStackTrace();
        }

        return updateFlag;
    }

    @Override
    public List<T> findAll(Order... orders) {
        String hql = getQueryString(orders);

        List<T> result = Collections.emptyList();

        try {
            result = (List<T>) hibernateTemplate.find(hql);
        } catch (DataAccessException ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<T> findAllWithLimit(ResultLimit limit, Order... orders) {
        String hql = getQueryString(orders);
        return queryList(limit,hql);
    }

    @Override
    public List<T> findByConditions(List<Condition> conditions, ConditionValueFilter filter, Order... orders) {
        String hql = getQueryString(conditions, filter, orders);
        Object[] params = getQueryParams(conditions);

        return executeQuery(hql,params);
    }

    @Override
    public List<T> findByConditions(List<Condition> conditions, Order... orders) {
        String hql = getQueryString(conditions, orders);
        Object[] params = getQueryParams(conditions);

        return executeQuery(hql,params);
    }

    @Override
    public List<T> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, Order... orders) {

        String hql = getQueryString(conditions, orders);
        Object[] params = getQueryParams(conditions);

        return queryList(limit,hql,params);
    }

    @Override
    public List<T> findByConditionsWithLimit(ResultLimit limit, List<Condition> conditions, ConditionValueFilter filter, Order... orders) {
        String hql = getQueryString(conditions,filter,orders);
        Object[] params = getQueryParams(conditions);

        return queryList(limit,hql,params);
    }

    @Override
    public T findOne(List<Condition> conditions) {
        String hql = getQueryString(conditions);
        Object[] params = getQueryParams(conditions);
        return queryOne(hql,params);
    }


    //========
    // private methods
    //=======

    private Query prepareQuery(final ResultLimit limit,final String hql,final Object... params){
        Query query = null;
        query = hibernateTemplate.execute(new HibernateCallback<Query>() {
            @Override
            public Query doInHibernate(Session session) throws HibernateException {

                Query query = session.createQuery(hql);

                if (limit != null) {
                    query.setFirstResult(limit.getStart());
                    query.setMaxResults(limit.getSize());
                }

                int i = 0;
                if( null != params ) {
                    for( Object o : params ){
                        query.setParameter(i++,o);
                    }
                }

                return query;
            }
        });
        return query;
    }

    private T queryOne(final String hql,final Object... params) {
        Query query = prepareQuery(null, hql, params);
        return (T) query.uniqueResult();
    }

    private List<T> queryList(final ResultLimit limit,final String hql,final Object... params){
        Query query = prepareQuery(limit, hql, params);
        return (List<T>)query.list();
    }


    private List<T> executeQuery(String hql,Object[] params){
        List<T> result = Collections.emptyList();
        try {
            result = (List<T>) hibernateTemplate.find(hql, params);
        } catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return result;
    }

}
