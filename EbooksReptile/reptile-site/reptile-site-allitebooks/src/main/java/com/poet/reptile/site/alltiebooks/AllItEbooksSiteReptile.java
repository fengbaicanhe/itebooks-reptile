package com.poet.reptile.site.alltiebooks;

import com.poet.reptile.api.SiteReptile;
import com.poet.reptile.api.extractor.Extractor;
import com.poet.reptile.api.extractor.support.JsoupExtractor;
import com.poet.reptile.api.extractor.support.JsoupExtractorBuilder;
import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.model.ISite;
import com.poet.reptile.model.hibernate.Book;
import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.site.alltiebooks.extractors.BookProcessor;
import com.poet.reptile.site.alltiebooks.extractors.CategoryProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class AllItEbooksSiteReptile implements SiteReptile {
    @Override
    public List<ICategory> reptileCategories(ISite site) {
        JsoupExtractor<Category> categoryExtractor = JsoupExtractorBuilder.startBuild(new CategoryProcessor())
                .cssQuery("#menu-item-65>ul")
                .build(Category.class);

        List categories = categoryExtractor.extractFromUrl(site.getSiteUrl());

        return categories;
    }

    @Override
    public List<IBook> reptileBooksByCategory(ICategory category) {
        String cssQuery = "#main-content>div";

        Map dataMap = new HashMap();
        dataMap.put("category", category);

        Extractor<Book> bookExtractor = JsoupExtractorBuilder.startBuild(new BookProcessor())
                .cssQuery(cssQuery)
                .dataMap(dataMap)
                .build(Book.class);

        List result = bookExtractor.extractFromUrl(category.getCategoryUrl());

        return result;
    }
}
