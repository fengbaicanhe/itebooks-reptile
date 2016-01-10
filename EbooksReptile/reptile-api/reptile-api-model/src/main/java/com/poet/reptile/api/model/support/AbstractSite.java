package com.poet.reptile.api.model.support;


import com.poet.reptile.api.model.ISite;

import java.io.Serializable;

/**
 * Created by xu on 2016/1/7.
 */
public abstract class AbstractSite implements ISite {

    private Serializable id;
    private String siteName;
    private String siteUrl;
    private String siteDesc;

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public String getSiteName() {
        return siteName;
    }

    @Override
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public String getSiteUrl() {
        return siteUrl;
    }

    @Override
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    public String getSiteDesc() {
        return siteDesc;
    }

    @Override
    public void setSiteDesc(String siteDesc) {
        this.siteDesc = siteDesc;
    }
}
