package com.poet.reptile.model.hibernate;

import com.poet.reptile.api.model.*;
import com.poet.reptile.api.model.ISite;
import com.poet.reptile.api.model.support.AbstractCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name="category")
public class Category extends AbstractCategory {

    private List<Book> books = Collections.emptyList();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    @Column(name="category_name")
    @Override
    public String getCategoryName() {
        return super.getCategoryName();
    }

    @Column(name="category_url")
    @Override
    public String getCategoryUrl() {
        return super.getCategoryUrl();
    }

    @ManyToOne(targetEntity = Site.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    @Override
    public Site getSite() {
        return (Site)super.getSite();
    }

    @ManyToOne(targetEntity = Category.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    @Override
    public Category getParentCategory() {
        return (Category) super.getParentCategory();
    }



}
