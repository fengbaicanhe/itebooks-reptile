package com.poet.reptile.site.allitebooks;

import com.poet.reptile.api.SiteReptile;
import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.model.hibernate.Book;
import com.poet.reptile.model.hibernate.Category;
import com.poet.reptile.model.hibernate.Site;
import com.poet.reptile.site.alltiebooks.AllItEbooksSiteReptile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Love0 on 2016/1/10 0010.
 */
public class SiteReptileTest {

    SiteReptile reptile = new AllItEbooksSiteReptile();

    @Test
    public void testFetchCategory(){
        Site site = mockSite();

        List<ICategory> categories = reptile.reptileCategories(site);

        System.out.println("parent categories:");
        for( ICategory c : categories ){
            if( c.getCategoryName().equals(c.getParentCategory().getCategoryName()) ){
                System.out.println(c.getCategoryName());
            }
        }
        System.out.println();
        for( ICategory c : categories ){
            if( !c.getCategoryName().equals(c.getParentCategory().getCategoryName()) ){
                System.out.println(c.getCategoryName());
            }
        }


    }

    @Test
    public void testFetchBooksByCategory(){
        Category category = mockCategory();

        List<IBook> books = reptile.reptileBooksByCategory(category);

        for (IBook b : books)
            System.out.println(b.getBookTitle() + "  " + b.getBookFileFormat() + "  " + b.getBookFileSize());

    }

    @Test
    public void testFetchAllBooksWthSync(){
        Site site = mockSite();

        List<ICategory> categories = reptile.reptileCategories(site);

        System.out.println("before category size:"+categories.size());
        List<ICategory> subCategory = new ArrayList<>();
        for( ICategory c : categories ){
            if( !c.getCategoryName().equals(c.getParentCategory().getCategoryName()) ){
                subCategory.add(c);
            }
        }
        System.out.println("after category size :"+subCategory.size());


        List<IBook> books = new ArrayList<>();

        for( final ICategory c : subCategory ){
            books.addAll(reptile.reptileBooksByCategory(c));
        }

        System.out.println(books.size());
    }

    @Test
    public void testFetchAllBooksWithAsync(){
        Site site = mockSite();

        List<ICategory> categories = reptile.reptileCategories(site);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        List<Future<List<IBook>>> booksFuture = new ArrayList<>();
        for( final ICategory c : categories ){

            Future<List<IBook>> f = executorService.submit(new Callable<List<IBook>>() {
                @Override
                public List<IBook> call() throws Exception {
                    reptile.reptileBooksByCategory(c);
                    return null;
                }
            });
            booksFuture.add(f);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){}

        List<IBook> books = new ArrayList<>();
        for( Future<List<IBook>> f : booksFuture ){
            try {
                books.addAll(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(books.size());
    }


    private Category mockCategory(){
        Site site = mockSite();
        Category category = new Category();
        category.setSite(site);

        category.setCategoryName("java");
        category.setCategoryUrl("http://www.allitebooks.com/programming/java/");

        return category;
    }

    private Site mockSite(){
        Site site = new Site();
        site.setSiteName("all it ebooks");
        site.setSiteUrl("http://www.allitebooks.com/");
        return site;
    }

}
