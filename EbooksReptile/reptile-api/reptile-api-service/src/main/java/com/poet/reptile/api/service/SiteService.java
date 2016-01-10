package com.poet.reptile.api.service;

import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.model.ISite;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public interface SiteService extends GeneralService<ISite> {

    ISite isSiteExists(ISite site);

    /**
     * 根据站点名称，查询站点，查询不到则将给定站点对象存入数据库然后进行查询
     * @param site
     * @return
     */
    ISite forceGetSite(ISite site);

}
