package com.poet.reptile.site.allitebooks.extractors;

import com.poet.reptile.api.extractor.Extractor;
import com.poet.reptile.api.extractor.support.JsoupExtractorBuilder;
import com.poet.reptile.model.hibernate.Book;
import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.site.alltiebooks.extractors.BookProcessor;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class BookProcessorTest {

    String cssQuery = "#main-content>div";
    @Test
    public void testCategoryWithNoBook(){
        Category category = new Category();
        category.setCategoryName("3d-max");
        category.setCategoryUrl("http://www.allitebooks.com/graphics-design/3d-max/");

        Map dataMap = new HashMap();
        dataMap.put("category", category);

        Extractor<Book> bookExtractor = JsoupExtractorBuilder.startBuild(new BookProcessor())
                .cssQuery(cssQuery)
                .dataMap(dataMap)
                .build(Book.class);

        List<Book> result = bookExtractor.extractFromUrl(category.getCategoryUrl());

    }

    @Test
    public void testCategoryWithBooks(){

        Category category = new Category();
        category.setCategoryName("java");
        category.setCategoryUrl("http://www.allitebooks.com/programming/java/");

        Map dataMap = new HashMap();
        dataMap.put("category", category);

        Extractor<Book> bookExtractor = JsoupExtractorBuilder.startBuild(new BookProcessor())
                .cssQuery(cssQuery)
                .dataMap(dataMap)
                .build(Book.class);

        List<Book> result = bookExtractor.extractFromUrl(category.getCategoryUrl());

        for( Book b : result )
            System.out.println(b.getBookDownloadUrl());

        System.out.println(result.size());

    }

}
