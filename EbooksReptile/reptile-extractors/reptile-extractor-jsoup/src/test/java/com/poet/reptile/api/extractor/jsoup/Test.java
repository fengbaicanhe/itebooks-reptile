package com.poet.reptile.api.extractor.jsoup;

import com.poet.reptile.api.extractor.support.JsoupExtractorBuilder;
import com.poet.reptile.api.extractor.support.JsoupExtractor;

/**
 * Created by xu on 2016/1/7.
 */
public class Test {


    @org.junit.Test
    public void testBuilder(){



        JsoupExtractor categoryExtractor =
                JsoupExtractorBuilder.startBuild(new TestJsoupEleProcessor())
                .cssQuery("#menu-item-65>ul").build();

        categoryExtractor.extractFromUrl("http://www.allitebooks.com/");


    }

}
