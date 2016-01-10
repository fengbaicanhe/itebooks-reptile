package com.poet.reptile.model.hibernate;

import com.poet.reptile.api.model.support.AbstractSite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="site")
public class Site extends AbstractSite {

    private List<Category> categories = Collections.emptyList();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    @Column(name = "site_name")
    @Override
    public String getSiteName() {
        return super.getSiteName();
    }

    @Column(name = "site_url")
    @Override
    public String getSiteUrl() {
        return super.getSiteUrl();
    }

    @Column(name = "site_desc")
    @Override
    public String getSiteDesc() {
        return super.getSiteDesc();
    }

    @OneToMany(fetch = FetchType.LAZY,targetEntity = Category.class,mappedBy = "site")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
