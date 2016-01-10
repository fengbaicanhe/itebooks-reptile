package com.poet.reptile.api.model.support;

import com.poet.reptile.api.model.IAuthor;

import java.io.Serializable;

/**
 * Created by xu on 2016/1/7.
 */
public abstract class AbstractAuthor implements IAuthor {

    private Serializable id;
    private String authorName;
    private String authorPersonalUrl;
    private String authorDesc;

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public String getAuthorName() {
        return authorName;
    }

    @Override
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String getAuthorPersonalUrl() {
        return authorPersonalUrl;
    }

    @Override
    public void setAuthorPersonalUrl(String authorPersonalUrl) {
        this.authorPersonalUrl = authorPersonalUrl;
    }

    @Override
    public String getAuthorDesc() {
        return authorDesc;
    }

    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }
}
