package com.poet.reptile.api.service;

import com.poet.reptile.api.model.IAuthor;
import com.poet.reptile.api.model.ISite;

/**
 * Created by Love0 on 2016/1/9 0009.
 */
public interface AuthorService extends GeneralService<IAuthor> {

    IAuthor isAuthorExists(IAuthor author);

    IAuthor forceGetAuthor(IAuthor author);

}
