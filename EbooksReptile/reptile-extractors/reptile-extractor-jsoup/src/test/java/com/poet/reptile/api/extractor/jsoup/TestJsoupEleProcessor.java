package com.poet.reptile.api.extractor.jsoup;

import com.poet.reptile.api.extractor.support.JsoupElementsProcessor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xu on 2016/1/7.
 */
public class TestJsoupEleProcessor implements JsoupElementsProcessor {


    @Override
    public List process(Elements es, Map dataMap) {


        Elements books = es.select("li>a");

            for (Element b : books) {
                System.out.println(String.format("%-30s %s",b.text(),b.attr("href")));
        }


        return new ArrayList();
    }

}
