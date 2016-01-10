package com.poet.reptile.api.extractor;

import com.poet.reptile.api.exception.ExtractException;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 抓取数据接口
 */
public interface Extractor<T> {


    Map getDataMap();

    void setDataMap(Map dataMap);

    /**
     * 给定url，抓取数据
     * @param url
     * @return
     * @throws ExtractException
     */
    List<T> extractFromUrl(String url) throws ExtractException;

    List<T> extractFromUrl(URL url) throws ExtractException;

    /**
     * 给定html文本抓取数据
     * @param html
     * @return
     * @throws ExtractException
     */
    List<T> extractFromHtml(String html) throws ExtractException;

    List<T> extractFromXml(String xml) throws ExtractException;

    /**
     * 给定inputstream 抓取数据
     * @param is
     * @return
     * @throws ExtractException
     */
    List<T> extractFromInputStream(InputStream is) throws ExtractException;

}
