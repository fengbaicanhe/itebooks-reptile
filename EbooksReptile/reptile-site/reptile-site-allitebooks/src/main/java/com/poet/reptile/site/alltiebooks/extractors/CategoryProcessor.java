package com.poet.reptile.site.alltiebooks.extractors;

import com.poet.reptile.api.extractor.support.JsoupElementsProcessor;
import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.model.hibernate.Site;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class CategoryProcessor implements JsoupElementsProcessor<Category> {

    @Override
    public List<Category> process(Elements es, Map dataMap) {

        Site site = (Site)dataMap.get("site");

        List<Category> result = new ArrayList<Category>();

        Elements rootCategories = es.get(0).children();

        Category root = null;
        Category child = null;
        int i = 0;
        for(Element eleRoot : rootCategories){

            Element parentCategory = eleRoot.child(0);

            String categoryName = parentCategory.text();
            String categoryUrl = parentCategory.attr("href");

            root = new Category();
            root.setCategoryName(categoryName);
            root.setCategoryUrl(categoryUrl);
            root.setParentCategory(root);
            root.setSite(site);

            result.add(root);

            if( eleRoot.children().size() > 1 ){
                // there has sub category
                Elements esChidren = rootCategories.select("ul:eq(" + (i++) + ")>li>a");
                for( Element children : esChidren ){
                    categoryName = children.text();
                    categoryUrl = children.attr("href");

                    child = new Category();
                    child.setParentCategory(root);
                    child.setCategoryName(categoryName);
                    child.setCategoryUrl(categoryUrl);
                    child.setSite(site);
                    result.add(child);
                }
            }
        }
        return result;
    }
}
