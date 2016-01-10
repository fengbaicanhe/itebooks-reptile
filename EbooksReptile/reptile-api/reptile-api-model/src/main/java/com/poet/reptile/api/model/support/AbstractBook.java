package com.poet.reptile.api.model.support;

import com.poet.reptile.api.model.IAuthor;
import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.model.ICategory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu on 2016/1/7.
 */
public abstract class AbstractBook implements IBook {

    private Serializable id;
    private String bookTitle;
    private String bookSubTitle;
    private String bookIsbn;
    private String bookPubYear;
    private Integer bookPages;
    private String bookLanguage;
    private String bookFileSize;
    private String bookFileFormat;
    private String bookDesc;
    private String bookImageUrl;
    private String bookDownloadUrl;

    private List<ICategory> bookCategories;
    private List<IAuthor> bookAuthors;

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String getBookSubTitle() {
        return bookSubTitle;
    }

    @Override
    public void setBookSubTitle(String bookSubTitle) {
        this.bookSubTitle = bookSubTitle;
    }

    @Override
    public String getBookIsbn() {
        return bookIsbn;
    }

    @Override
    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    @Override
    public String getBookPubYear() {
        return bookPubYear;
    }

    @Override
    public void setBookPubYear(String bookPubYear) {
        this.bookPubYear = bookPubYear;
    }

    @Override
    public Integer getBookPages() {
        return bookPages;
    }

    @Override
    public void setBookPages(Integer bookPages) {
        this.bookPages = bookPages;
    }

    @Override
    public String getBookLanguage() {
        return bookLanguage;
    }

    @Override
    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    @Override
    public String getBookFileSize() {
        return bookFileSize;
    }

    @Override
    public void setBookFileSize(String bookFileSize) {
        this.bookFileSize = bookFileSize;
    }

    @Override
    public String getBookFileFormat() {
        return bookFileFormat;
    }

    @Override
    public void setBookFileFormat(String bookFileFormat) {
        this.bookFileFormat = bookFileFormat;
    }

    @Override
    public String getBookDesc() {
        return bookDesc;
    }

    @Override
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    @Override
    public String getBookImageUrl() {
        return bookImageUrl;
    }

    @Override
    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    @Override
    public String getBookDownloadUrl() {
        return bookDownloadUrl;
    }

    @Override
    public void setBookDownloadUrl(String bookDownloadUrl) {
        this.bookDownloadUrl = bookDownloadUrl;
    }

    @Override
    public List<ICategory> getBookCategories() {
        return bookCategories;
    }

    @Override
    public void setBookCategories(List<ICategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    @Override
    public List<IAuthor> getBookAuthors() {
        return bookAuthors;
    }

    @Override
    public void setBookAuthors(List<IAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
