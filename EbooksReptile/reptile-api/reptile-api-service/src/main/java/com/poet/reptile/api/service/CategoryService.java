package com.poet.reptile.api.service;

import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.model.ISite;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public interface CategoryService extends GeneralService<ICategory> {

    /**
     * 根据分类名称和站点编号确定分类是否存在
     * @param category
     * @return
     */
    ICategory isCategoryExists(ICategory category);

    /**
     * 根据站点名称，查询站点，查询不到则将给定站点对象存入数据库然后进行查询
     * @param category
     * @return
     */
    ICategory forceGetCategory(ICategory category);

}
