package com.poet.reptile.service.spring.service;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.builder.ConditionBuilder;
import com.poet.reptile.api.model.ISite;
import com.poet.reptile.api.service.SiteService;
import com.poet.reptile.api.service.support.AbstractGeneralService;

import java.util.List;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class GeneralSiteService extends AbstractGeneralService<ISite> implements SiteService {


    @Override
    public ISite isSiteExists(ISite site) {

        List<Condition> conditions = ConditionBuilder.makeContidions().eq("siteName", site.getSiteName()).build();

        ISite result = this.findOne(conditions);

        return result;
    }

    @Override
    public ISite forceGetSite(ISite site) {

        ISite find = this.isSiteExists(site);

        ISite result = find != null ? find : this.save(site);

        return result;
    }
}
