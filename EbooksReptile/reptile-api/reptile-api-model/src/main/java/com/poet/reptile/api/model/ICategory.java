package com.poet.reptile.api.model;

/**
 * Created by xu on 2016/1/7.
 */
public interface ICategory extends Identification {

    String getCategoryName();

    String getCategoryUrl();

    ICategory getParentCategory();

    ISite getSite();

    void setCategoryName(String categoryName);

    void setCategoryUrl(String categoryUrl);

    void setParentCategory(ICategory parentCategory);

    void setSite(ISite site);

}
