package com.poet.reptile.service.spring.factory;

import com.poet.reptile.api.dao.GeneralDao;
import com.poet.reptile.api.dao.support.AbstractGeneralDao;
import com.poet.reptile.api.service.GeneralService;
import com.poet.reptile.api.service.support.AbstractGeneralService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by xu on 2016/1/8.
 */
public class GeneralServiceFactoryBean implements MethodInterceptor {

    Enhancer enhancer = new Enhancer();

    public <T> GeneralService<T> getEnhancedGeneralService(GeneralDao<T> generalDao){
        enhancer.setSuperclass(AbstractGeneralService.class);
        enhancer.setCallback(this);
        AbstractGeneralService<T> service = (AbstractGeneralService<T>)enhancer.create();
        service.setGeneralDao(generalDao);
        return service;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }
}
