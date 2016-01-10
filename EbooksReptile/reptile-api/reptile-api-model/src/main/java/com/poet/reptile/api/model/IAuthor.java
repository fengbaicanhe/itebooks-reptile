package com.poet.reptile.api.model;

/**
 * Created by xu on 2016/1/7.
 */
public interface IAuthor extends Identification {

    String getAuthorName();

    String getAuthorPersonalUrl();

    String getAuthorDesc();

    void setAuthorName(String authorName);

    void setAuthorPersonalUrl(String authorPersonalUrl);

    void setAuthorDesc(String authorDesc);

}
