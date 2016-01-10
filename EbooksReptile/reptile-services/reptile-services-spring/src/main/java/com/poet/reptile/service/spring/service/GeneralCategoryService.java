package com.poet.reptile.service.spring.service;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.builder.ConditionBuilder;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.service.CategoryService;
import com.poet.reptile.api.service.support.AbstractGeneralService;

import java.util.List;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class GeneralCategoryService extends AbstractGeneralService<ICategory> implements CategoryService {
    @Override
    public ICategory isCategoryExists(ICategory category) {

        List<Condition> conditions = ConditionBuilder.makeContidions()
                .eq("categoryName", category.getCategoryName())
                .eq("site.id", category.getSite().getId()).build();

        ICategory result = this.findOne(conditions);

        return result;
    }

    @Override
    public ICategory forceGetCategory(ICategory category) {
        ICategory find = this.isCategoryExists(category);

        ICategory result = find != null ? find : this.save(category);

        return result;
    }
}
