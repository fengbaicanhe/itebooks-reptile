package com.poet.reptile.api.service;

import com.poet.reptile.api.model.IBook;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public interface BookService extends GeneralService<IBook> {

    /**
     * 根据图书isbn判断，图书是否存在
     * @param book
     * @return 图书信息，null表示图书不存在
     */
    IBook isBookExists(IBook book);

    /**
     * 通过给定的图书中isbn信息，如果数据库中存在，则查询数据，否则写入数据，并返回数据库中的数据
     *
     * @param book
     * @return
     */
    IBook forceGetBook(IBook book);





}
