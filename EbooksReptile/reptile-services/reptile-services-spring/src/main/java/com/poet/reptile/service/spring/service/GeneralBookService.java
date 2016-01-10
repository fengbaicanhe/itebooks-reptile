package com.poet.reptile.service.spring.service;

import com.poet.reptile.api.dao.query.Condition;
import com.poet.reptile.api.dao.query.builder.ConditionBuilder;
import com.poet.reptile.api.model.IBook;
import com.poet.reptile.api.service.BookService;
import com.poet.reptile.api.service.support.AbstractGeneralService;

import java.util.List;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public class GeneralBookService extends AbstractGeneralService<IBook> implements BookService {

    @Override
    public IBook isBookExists(IBook book) {
        String bookIsbn = book.getBookIsbn();
        List<Condition> conditions = ConditionBuilder.makeContidions().eq("bookIsbn", bookIsbn).build();
        IBook result = this.findOne(conditions);
        return result;
    }

    @Override
    public IBook forceGetBook(IBook book) {

        IBook find = this.isBookExists(book);

        IBook result = find != null ? find : this.save(book);

        return result;
    }


}
