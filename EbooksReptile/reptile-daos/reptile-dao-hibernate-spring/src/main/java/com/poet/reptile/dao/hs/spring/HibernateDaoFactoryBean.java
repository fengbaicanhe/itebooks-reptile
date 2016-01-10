package com.poet.reptile.dao.hs.spring;

import com.poet.reptile.api.dao.GeneralDao;
import com.poet.reptile.dao.hs.AbstractHiberanteDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.lang.reflect.Method;

/**
 * Created by Love0 on 2016/1/7 0007.
 */
public class HibernateDaoFactoryBean implements MethodInterceptor {

    private final HibernateTemplate hibernateTemplate;

    private Enhancer enhancer = new Enhancer();

    public HibernateDaoFactoryBean(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public <T> GeneralDao<T> getEnhancedHibernateDao(Class<T> entityClass){
        enhancer.setSuperclass(AbstractHiberanteDao.class);
        enhancer.setCallback(this);
        AbstractHiberanteDao<T> hibernateDao = (AbstractHiberanteDao<T>)enhancer.create();
        hibernateDao.setEntityClass(entityClass);
        hibernateDao.setHibernateTemplate(hibernateTemplate);
        return hibernateDao;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }
}
