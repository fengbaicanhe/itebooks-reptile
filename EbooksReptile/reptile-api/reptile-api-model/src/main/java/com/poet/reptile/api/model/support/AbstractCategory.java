package com.poet.reptile.api.model.support;

import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.model.ISite;

import java.io.Serializable;

public abstract class AbstractCategory implements ICategory {

    private Serializable id;
    private String categoryName;
    private String categoryUrl;
    private ICategory parentCategory;
    private ISite site;
    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public ICategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ICategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public ISite getSite() {
        return this.site;
    }

    @Override
    public void setSite(ISite site) {
        this.site = site;
    }
}
