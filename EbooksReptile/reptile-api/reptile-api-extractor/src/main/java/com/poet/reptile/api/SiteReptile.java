package com.poet.reptile.api;

import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.model.ISite;

import java.util.List;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public interface SiteReptile {

    List<ICategory> reptileCategories(ISite site);

    List<IBook> reptileBooksByCategory(ICategory category);

}
