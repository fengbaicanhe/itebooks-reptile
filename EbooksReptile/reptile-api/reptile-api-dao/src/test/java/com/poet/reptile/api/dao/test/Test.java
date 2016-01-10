package com.poet.reptile.api.dao.test;

import com.poet.reptile.api.dao.GeneralDao;
import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.Order;
import com.poet.reptile.api.dao.query.builder.ConditionBuilder;
import com.poet.reptile.api.dao.query.filter.ConditionValueFilter;

import java.util.List;

/**
 * Created by xu on 2016/1/7.
 */
public class Test {


    public static void main(String[] args) {

        GeneralDao<User> userDao = new TestDaoImpl();

        ConditionValueFilter filter = new ConditionValueFilter() {
            @Override
            public boolean apply(Object value) {
                return value != null;
            }
        };

        List<Condition> conditions = ConditionBuilder.makeContidions().eq("id",111)
                .like("name","%sss")
                .gt("id",null)
                .eq("password","admin")
                .lt("id",null)
                .build();

        userDao.findByConditionsWithLimit(null,conditions,filter,Order.asc("id"), Order.desc("name"));

    }

}
