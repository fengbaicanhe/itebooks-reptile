package com.poet.reptile.model.hibernate;

import com.poet.reptile.api.model.IAuthor;
import com.poet.reptile.api.model.ICategory;
import com.poet.reptile.api.model.support.AbstractBook;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="book")
public class Book extends AbstractBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    @Column(name="book_title")
    @Override
    public String getBookTitle() {
        return super.getBookTitle();
    }

    @Column(name="book_subtitle")
    @Override
    public String getBookSubTitle() {
        return super.getBookSubTitle();
    }

    @Column(name="book_isbn")
    @Override
    public String getBookIsbn() {
        return super.getBookIsbn();
    }

    @Column(name="book_pub_year")
    @Override
    public String getBookPubYear() {
        return super.getBookPubYear();
    }

    @Column(name="book_pages")
    @Override
    public Integer getBookPages() {
        return super.getBookPages();
    }

    @Column(name="book_language")
    @Override
    public String getBookLanguage() {
        return super.getBookLanguage();
    }

    @Column(name="book_file_size")
    @Override
    public String getBookFileSize() {
        return super.getBookFileSize();
    }

    @Column(name="book_file_format")
    @Override
    public String getBookFileFormat() {
        return super.getBookFileFormat();
    }

    @Column(name="book_desc")
    @Override
    public String getBookDesc() {
        return super.getBookDesc();
    }

    @Column(name="book_image_url")
    @Override
    public String getBookImageUrl() {
        return super.getBookImageUrl();
    }

    @Column(name="book_download_url")
    @Override
    public String getBookDownloadUrl() {
        return super.getBookDownloadUrl();
    }

    @ManyToMany(targetEntity = Category.class,fetch = FetchType.LAZY)
    @JoinTable(name = "book_category_asso",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    @Override
    public List<ICategory> getBookCategories() {
        return super.getBookCategories();
    }

    @ManyToMany(targetEntity = Author.class,fetch = FetchType.LAZY)
    @JoinTable(name = "book_author_asso",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    @Override
    public List<IAuthor> getBookAuthors() {
        return super.getBookAuthors();
    }

}
