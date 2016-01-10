package com.poet.reptile.api.extractor.support;


import com.poet.reptile.api.exception.ExtractException;

import java.util.Collections;
import java.util.Map;

public class JsoupExtractorBuilder {

    private JsoupElementsProcessor processor;
    private String cssQuery;
    private Integer timeout = JsoupExtractor.DEFAULT_TIMEOUT;
    private String baseUrl;
    private String charsetName = JsoupExtractor.DEFAULT_CHARSET_NAME;
    private Map dataMap = Collections.emptyMap();

    private JsoupExtractorBuilder(JsoupElementsProcessor processor){
        this.processor = processor;
    }

    public JsoupExtractorBuilder cssQuery(String cssQuery){
        this.cssQuery = cssQuery;
        return this;
    }

    public JsoupExtractorBuilder dataMap(Map dataMap){
        this.dataMap = dataMap;
        return this;
    }

    public JsoupExtractorBuilder timeout(int timeout){
        this.timeout = timeout;
        return this;
    }

    public JsoupExtractorBuilder baseUrl(String baseUrl){
        this.baseUrl = baseUrl;
        return this;
    }

    public JsoupExtractorBuilder useCharset(String charsetName){
        this.charsetName = charsetName;
        return this;
    }

    public JsoupExtractor build(){
        JsoupExtractor extractor = new JsoupExtractor();
        fillProperty(extractor);
        return extractor;
    }

    public <T> JsoupExtractor<T> build(Class<T> clazz){
        JsoupExtractor<T> extractor = new JsoupExtractor<T>();
        fillProperty(extractor);
        return extractor;
    }

//    public <T extends JsoupExtractor> T build(Class<T> clazz){
//        T result = null;
//        try {
//            result = clazz.newInstance();
//            fillProperty(result);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }



    public static <T> JsoupExtractorBuilder startBuild(JsoupElementsProcessor<T> processor){
        if ( null == processor ){
            throw new ExtractException("provide processor can not be null!");
        }
        return new JsoupExtractorBuilder(processor);
    }


    // ==== private methods

    private void fillProperty(JsoupExtractor extractor){
        extractor.baseUrl = this.baseUrl;
        extractor.timeout = this.timeout;
        extractor.charsetName = this.charsetName;
        extractor.cssQuery = this.cssQuery;
        extractor.processor = this.processor;
        extractor.dataMap = this.dataMap;
    }


}
