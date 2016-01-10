package com.poet.reptile.service.spring.service;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.builder.ConditionBuilder;
import com.poet.reptile.api.model.IAuthor;
import com.poet.reptile.api.service.AuthorService;
import com.poet.reptile.api.service.support.AbstractGeneralService;

import java.util.List;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class GeneralAuthorService extends AbstractGeneralService<IAuthor> implements AuthorService {
    @Override
    public IAuthor isAuthorExists(IAuthor author) {

        List<Condition> conditions = ConditionBuilder.makeContidions().eq("authorName", author.getAuthorName()).build();

        IAuthor result = this.findOne(conditions);

        return result;
    }

    @Override
    public IAuthor forceGetAuthor(IAuthor author) {

        IAuthor find = this.isAuthorExists(author);

        IAuthor result = find != null ? find : this.save(author);

        return result;
    }
}
