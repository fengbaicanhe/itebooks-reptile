package com.poet.reptile.api.extractor.support;

import com.poet.reptile.api.exception.ExtractException;
import com.poet.reptile.api.extractor.Extractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by xu on 2016/1/7.
 */
public final class JsoupExtractor<T> implements Extractor<T> {

    /**
     * 默认 超时时间，5s
     */
    public static final Integer DEFAULT_TIMEOUT = 10 * 1000;
    /**
     * 默认字符编码  UTF-8
     */
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";

    String baseUrl;
    int timeout = DEFAULT_TIMEOUT;
    String cssQuery;
    String charsetName = DEFAULT_CHARSET_NAME;
    Map dataMap = Collections.emptyMap();

    JsoupElementsProcessor<T> processor;

    @Override
    public List<T> extractFromUrl(String url) throws ExtractException {
        URL u = null;
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            throw new ExtractException("url is invalid: " + url);
        }
        return extractFromUrl(u);
    }

    @Override
    public List<T> extractFromUrl(URL url) throws ExtractException {

        Document doc = getDocument(url);

        ensureDocument(doc);

        return processResult(doc);
    }

    @Override
    public List<T> extractFromHtml(String html) throws ExtractException {

        Document doc = getDocument(html);
        ensureDocument(doc);

        return processResult(doc);
    }

    @Override
    public List<T> extractFromXml(String xml) throws ExtractException {
        Document doc = getDocument(xml);
        ensureDocument(doc);

        return processResult(doc);
    }

    @Override
    public List<T> extractFromInputStream(InputStream is) throws ExtractException {
        Document doc = getDocument(is);
        ensureDocument(doc);

        return processResult(doc);
    }

    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public Map getDataMap() {
        return dataMap;
    }

    // private methods

    private List<T> processResult(Document doc){
        Elements es = doc.select(cssQuery);
        return processor.process(es,dataMap);
    }

    private Document getDocument(URL url){
        Document doc = null;
        try {
            doc = Jsoup.parse(url, timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private Document getDocument(String html){
        Document doc = null;
        doc = Jsoup.parse(html, baseUrl);
        return doc;
    }

    private Document getDocument(InputStream is){
        Document doc = null;
        try {
            doc = Jsoup.parse(is, charsetName, baseUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private void ensureDocument(Document doc) throws ExtractException {
        if( null == doc ){
            throw new ExtractException("can not parse Document with provide url");
        }
    }


}
