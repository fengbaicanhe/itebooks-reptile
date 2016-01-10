package com.poet.reptile.model.hibernate;

import com.poet.reptile.api.model.support.AbstractAuthor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="author")
public class Author extends AbstractAuthor {

    private List<Book> books = Collections.emptyList();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    @Override
    public Integer getId() {
        return (Integer)super.getId();
    }

    @Column(name="author_name")
    @Override
    public String getAuthorName() {
        return super.getAuthorName();
    }

    @Column(name="author_personal_url")
    @Override
    public String getAuthorPersonalUrl() {
        return super.getAuthorPersonalUrl();
    }

    @Column(name="author_desc")
    @Override
    public String getAuthorDesc() {
        return super.getAuthorDesc();
    }

    @ManyToMany(mappedBy = "bookAuthors",targetEntity = Book.class)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
