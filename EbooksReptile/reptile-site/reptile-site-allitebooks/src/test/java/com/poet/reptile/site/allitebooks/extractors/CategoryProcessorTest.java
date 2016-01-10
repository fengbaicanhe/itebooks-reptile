package com.poet.reptile.site.allitebooks.extractors;

import com.poet.reptile.api.extractor.support.JsoupExtractor;
import com.poet.reptile.api.extractor.support.JsoupExtractorBuilder;
import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.model.hibernate.Site;
import com.poet.reptile.site.alltiebooks.extractors.CategoryProcessor;
import org.junit.Test;

import java.util.List;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class CategoryProcessorTest {

    @Test
    public void test() {

        Site site = new Site();
        site.setSiteName("allitebooks");
        site.setSiteUrl("http://www.allitebooks.com/");



    }

}
