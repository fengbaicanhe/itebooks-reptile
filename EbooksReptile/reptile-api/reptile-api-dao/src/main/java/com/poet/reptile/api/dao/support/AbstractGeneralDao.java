package com.poet.reptile.api.dao.support;

import com.poet.reptile.api.dao.GeneralDao;
import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 2016/1/7.
 */
public abstract class AbstractGeneralDao<T> implements GeneralDao<T> {

    protected static final String EMPTY_STRING = "";
    protected static final String SPACE = " ";
    protected static final String FROM = "FROM";

    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractGeneralDao() {
        // cglib proxy,do nothing
        if (this.getClass().getName().contains("$$EnhancerByCGLIB$$"))
            return;
        ParameterizedType superType = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) superType.getActualTypeArguments()[0];
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    //
    // protected methods
    //

    // todo add group by,having spring

    protected final String getQueryString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getSelectClause());
        sb.append(SPACE);
        sb.append(getFromClause());
        return sb.toString();
    }

    protected final String getQueryString(Order... orders){
        StringBuilder sb = new StringBuilder();
        sb.append(getSelectClause());
        sb.append(SPACE);
        sb.append(getFromClause());
        sb.append(SPACE);
        sb.append(getOrderClause(orders));
        return sb.toString();
    }

    protected final String getQueryString(List<Condition> conditions,Order... orders){
        StringBuilder sb = new StringBuilder();
        sb.append(getSelectClause());
        sb.append(SPACE);
        sb.append(getFromClause());
        sb.append(SPACE);
        sb.append(getWhereClause(conditions));
        sb.append(SPACE);
        sb.append(getOrderClause(orders));
        return sb.toString();
    }

    protected final String getQueryString(List<Condition> conditions,ConditionValueFilter filter,Order... orders){
        this.filterConditions(conditions,filter);
        return getQueryString(conditions,orders);
    }

    /**
     * 获取select 语句
     * @return
     */
    protected abstract String getSelectClause();

    /**
     * 获取 from 语句
     * @return
     */
    protected abstract String getFromClause();

    /**
     * 获取排序sql语句
     * @param orders
     * @return
     */
    protected final String getOrderClause(Order... orders) {

        if (orders == null || orders.length == 0)
            return EMPTY_STRING;

        StringBuilder result = new StringBuilder();

        result.append("ORDER BY ");

        for (Order o : orders) {
            result.append(o.getOrderProperty()).append(EMPTY_STRING).append(o.getOrderType()).append(",");
        }

        String orderClause = result.toString();

        orderClause = orderClause.substring(0, orderClause.length() - 1);

        return orderClause;
    }

    /**
     * 获取where条件sql
     * // TODO 重构，支持 in 查询
     * @param conditions
     * @return
     */
    protected String getWhereClause(List<Condition> conditions) {

        if (conditions.size() == 0) {
            return EMPTY_STRING;
        }

        StringBuilder result = new StringBuilder();

        result.append("WHERE");

        List<Condition> willRemoved = new ArrayList<Condition>();
        for (Condition c : conditions) {
            result.append(SPACE);
            result.append(c.getPropertyName());
            result.append(SPACE);
            result.append(c.getOperator());
            result.append(SPACE);

            if (c.getValue() == null) {
                result.append("NULL");
                willRemoved.add(c);
            } else {
                result.append("?");
            }

            result.append(SPACE);
            result.append("AND");
        }
        conditions.removeAll(willRemoved);
        String resultStr = result.toString();
        resultStr = resultStr.substring(0, resultStr.length() - 3);
        return resultStr;

    }

    protected void filterConditions(List<Condition> conditions, ConditionValueFilter filter) {

        if (conditions.size() == 0)
            return;

        List<Condition> willRemoved = new ArrayList<Condition>();

        for (Condition c : conditions) {
            Object value = c.getValue();

            boolean isApply = filter.apply(value);

            if (!isApply)
                willRemoved.add(c);

        }

        conditions.removeAll(willRemoved);
    }

    protected final Object[] getQueryParams(List<Condition> conditions) {
        Object[] args = new Object[conditions.size()];
        if (conditions.size() == 0)
            return args;

        int i = 0;
        for (Condition c : conditions) {
            args[i] = c.getValue();
            i++;
        }

        return args;
    }

}
