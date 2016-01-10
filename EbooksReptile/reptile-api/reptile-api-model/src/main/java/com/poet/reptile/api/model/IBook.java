package com.poet.reptile.api.model;


import java.util.List;

/**
 * Created by xu on 2016/1/7.
 */
public interface IBook extends Identification {

    String getBookTitle();

    void setBookTitle(String bookTitle);

    String getBookSubTitle();

    void setBookSubTitle(String bookSubTitle);

    List<IAuthor> getBookAuthors();

    void setBookAuthors(List<IAuthor> bookAuthors);

    String getBookIsbn();

    void setBookIsbn(String bookIsbn);

    String getBookPubYear();

    void setBookPubYear(String bookPubYear);

    Integer getBookPages();

    void setBookPages(Integer bookPages);

    String getBookLanguage();

    void setBookLanguage(String bookLanguage);

    String getBookFileSize();

    void setBookFileSize(String bookFileSize);

    String getBookFileFormat();

    void setBookFileFormat(String bookFileFormat);

    List<ICategory> getBookCategories();

    void setBookCategories(List<ICategory> bookCategories);

    String getBookDesc();

    void setBookDesc(String bookDesc);

    String getBookImageUrl();

    void setBookImageUrl(String bookImageUrl);

    String getBookDownloadUrl();

    void setBookDownloadUrl(String bookDownloadUrl);

}
