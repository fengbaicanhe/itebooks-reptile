package com.poet.reptile.api.extractor.support;

import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * Created by xu on 2016/1/7.
 */
public interface JsoupElementsProcessor<T> {

    List<T> process(Elements es, Map dataMap);

}
