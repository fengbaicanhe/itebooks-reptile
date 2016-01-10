package com.poet.reptile.site.alltiebooks.extractors;

import com.poet.reptile.api.extractor.support.JsoupElementsProcessor;
import com.poet.reptile.api.model.IAuthor;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.model.hibernate.Author;
import com.poet.reptile.model.hibernate.Book;
import com.poet.reptile.model.hibernate.Category;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class BookDetailProcessor implements JsoupElementsProcessor<Book> {
    @Override
    public List<Book> process(Elements es, Map dataMap) {


        Category category = (Category) dataMap.get("category");

        String bookTitle = es.select("header>.single-title").get(0).text();
        String bookSubtitle = null;
        Elements esSubTitle = es.select("header>h4");
        if( esSubTitle.size() > 0 ) {
            bookSubtitle = esSubTitle.get(0).text();
        }

        String imageUrl = es.select("header>div>div:eq(0)>a>img").attr("src");

        Elements esBookInfos = es.select("header>div>div.book-detail>dl>dd");

        String bookIsbn = esBookInfos.get(1).text().trim();
        String bookYearStr = esBookInfos.get(2).text().trim();
        String bookPages = esBookInfos.get(3).text().trim();
        String bookLanguage = esBookInfos.get(4).text().trim();
        String bookFileSize = esBookInfos.get(5).text().trim();
        String bookFileFormat = esBookInfos.get(6).text().trim();

        Elements esAuthors = esBookInfos.get(0).select("a");

        List<IAuthor> authors = new ArrayList<IAuthor>();
        Author author = null;
        for( Element e : esAuthors) {
            String authorName = e.text();
            String personalUrl = e.attr("href");

            author = new Author();
            author.setAuthorName(authorName);
            author.setAuthorPersonalUrl(personalUrl);

            authors.add(author);
        }

        //String bookDesc = es.select("div:eq(0)");

        Elements esBookDescs = es.select("div.entry-content>p");
        StringBuilder sb = new StringBuilder();
        for( Element e : esBookDescs ){
            sb.append(e.text().trim()).append("\n");
        }
        String bookDesc = sb.toString();

        String downloadUrl = es.select("footer>div>span:eq(0)>a").get(0).attr("href").trim();

        Book book = new Book();

        book.setBookTitle(bookTitle);
        book.setBookSubTitle(bookSubtitle);
        book.setBookAuthors(authors);
        book.setBookDesc(bookDesc);
        book.setBookPubYear(bookYearStr);

        book.setBookIsbn(bookIsbn);
        book.setBookImageUrl(imageUrl);
        book.setBookLanguage(bookLanguage);
        book.setBookFileFormat(bookFileFormat);
        book.setBookFileSize(bookFileSize);
        book.setBookDownloadUrl(downloadUrl);
        try {
            book.setBookPages(Integer.valueOf(bookPages));
        } catch (Exception ex){
            System.err.println("------------------------------------>  set book page failed,"+book.getBookTitle() + "  " + book.getBookDownloadUrl());
        }
        List<ICategory> categories = new ArrayList<ICategory>();
        categories.add(category);

        book.setBookCategories(categories);

        List<Book> result = new ArrayList<Book>(1);
        result.add(book);

        return result;
    }
}
