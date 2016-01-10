package com.poet.reptile.site.alltiebooks.extractors;

import com.poet.reptile.api.extractor.support.JsoupElementsProcessor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class BookUrlsByPageExtractor implements JsoupElementsProcessor<String> {
    @Override
    public List<String> process(Elements es, Map dataMap) {

        List<String> result = new ArrayList<String>();

        for(Element e : es){
            result.add(e.attr("href"));
        }

        return result;
    }
}
