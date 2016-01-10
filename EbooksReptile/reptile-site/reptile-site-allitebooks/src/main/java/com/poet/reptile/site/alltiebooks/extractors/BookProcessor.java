package com.poet.reptile.site.alltiebooks.extractors;

import com.poet.reptile.api.extractor.Extractor;
import com.poet.reptile.api.extractor.support.JsoupElementsProcessor;
import com.poet.reptile.api.extractor.support.JsoupExtractorBuilder;
import com.poet.reptile.model.hibernate.Book;
import com.poet.reptile.model.hibernate.Category;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class BookProcessor implements JsoupElementsProcessor<Book> {

    ExecutorService pageUrlExecutorService = Executors.newFixedThreadPool(30);
    ExecutorService bookDetailExecutorService = Executors.newFixedThreadPool(30);


    @Override
    public List<Book> process(Elements es, Map dataMap) {

        List<Book> result = new ArrayList<Book>();

        Elements esBooks = es.select("article>div:eq(0)>a");

        // 判断是否有图书数据
        if( esBooks.size() == 0 )
            return result;

        Category category = (Category) dataMap.get("category");

        // 解析 此分类下数据的总页数
        // 默认添加第一页
        List<String> urlsByPage = new ArrayList<String>();
        urlsByPage.add(category.getCategoryUrl());
        Elements pages = es.select("div.pagination>a");
        if( pages.size() > 0 ){
            String maxPage = pages.get(pages.size()-1).text().trim();

            String categoryUrl = category.getCategoryUrl();
            categoryUrl = categoryUrl.endsWith("/") ? categoryUrl : categoryUrl + "/";

            for( int i = 2;i<=Integer.valueOf(maxPage);i++ ){
                String pageUrl = categoryUrl + "page" + "/" + i + "/";
                urlsByPage.add(pageUrl);
            }

        }



        // 获取所有图书详情连接url
        List<String> bookDetailUrls = new ArrayList<String>();

        Extractor<String> bookUrlsByPageExtractor = JsoupExtractorBuilder.startBuild(new BookUrlsByPageExtractor())
                .cssQuery("#main-content>div>article>div:eq(0)>a")
                .timeout(10 * 60 * 1000)
                .build(String.class);


        List<Future<List<String>>> futures = new ArrayList<Future<List<String>>>();
        for( String pageUrl : urlsByPage ){
            Future<List<String>> future = pageUrlExecutorService.submit(new PageUrlCallable(bookUrlsByPageExtractor,pageUrl));
            futures.add(future);
        }

        pageUrlExecutorService.shutdown();
        while( !pageUrlExecutorService.isTerminated() ){}

        for( Future<List<String>> f : futures ){
            try {
                bookDetailUrls.addAll(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        // 抓取每页的图书数据
        Extractor<Book> bookDetailExtractor = JsoupExtractorBuilder.startBuild(new BookDetailProcessor())
                .cssQuery("#main-content>div>article")
                .dataMap(dataMap)
                .timeout(10 * 60 * 1000)
                .build(Book.class);


        List<Future<List<Book>>> bookFutures = new ArrayList<Future<List<Book>>>();
        for( String bookDetailUrl : bookDetailUrls ){
            Future<List<Book>> f = this.bookDetailExecutorService.submit(new BookDetailCallable(bookDetailExtractor,bookDetailUrl));
            bookFutures.add(f);
        }

        this.bookDetailExecutorService.shutdown();
        while (!this.bookDetailExecutorService.isTerminated()){}

        for( Future<List<Book>> f : bookFutures ){
            try {
                result.addAll(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }



    class BookDetailCallable implements Callable<List<Book>>{
        private final Extractor<Book> extractor;
        private final String extractorUrl;

        BookDetailCallable(Extractor<Book> extractor, String extractorUrl) {
            this.extractor = extractor;
            this.extractorUrl = extractorUrl;
        }

        @Override
        public List<Book> call() throws Exception {
            System.out.println("starting extract book from :" + extractorUrl);
            return extractor.extractFromUrl(extractorUrl);
        }
    }

    class PageUrlCallable implements Callable<List<String>>{

        private final Extractor<String> extractor;
        private final String extractorUrl ;

        PageUrlCallable(Extractor<String> extractor,String url) {
            this.extractor = extractor;
            this.extractorUrl = url;
        }

        @Override
        public List<String> call() throws Exception {
            System.out.println("starting extract page url : " + this.extractorUrl);
            return extractor.extractFromUrl(this.extractorUrl);
        }
    }

}



