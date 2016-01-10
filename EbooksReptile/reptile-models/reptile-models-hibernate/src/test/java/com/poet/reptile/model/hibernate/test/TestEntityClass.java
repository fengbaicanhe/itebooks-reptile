package com.poet.reptile.model.hibernate.test;

import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.model.hibernate.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class TestEntityClass {

    @Test
    public void test(){
//        Configuration cfg = new Configuration().configure();
//        ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//
//        SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
//
//
//        Session session = sf.openSession();
//
//        session.beginTransaction();
//
//
//
//        Site site = new Site();
//
//
//        site.setSiteName("asss");
//        session.save(site);
//
//        Category c = new Category();
//        c.setSite(site);
//        c.setParentCategory(c);
//        c.setCategoryName("aaaaaaaa");
//        session.save(c);
//
//
//        session.save(site);
//        session.getTransaction().commit();


    }

}
