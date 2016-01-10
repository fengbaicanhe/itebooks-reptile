package com.poet.reptile.api.model;

/**
 * 站点模型接口
 * Created by xu on 2016/1/7.
 */
public interface ISite extends Identification {

    /**
     * 获取站点名称
     * @return
     */
    String getSiteName();

    /**
     * 获取站点URL
     * @return
     */
    String getSiteUrl();

    /**
     * 获取站点描述
     * @return
     */
    String getSiteDesc();

    /**
     * 设置 站点名称
     * @param siteName
     */
    void setSiteName(String siteName);

    /**
     * 设置站点url
     * @param siteUrl
     */
    void setSiteUrl(String siteUrl);

    /**
     * 设置站点描述信息
     * @param siteDesc
     */
    void setSiteDesc(String siteDesc);

}
