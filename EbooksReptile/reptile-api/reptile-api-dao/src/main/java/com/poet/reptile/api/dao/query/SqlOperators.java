package com.poet.reptile.api.dao.query;

/**
 * Created by xu on 2016/1/7.
 */
public abstract class SqlOperators {

    private SqlOperators(){}

    public static final String EQ = "=";

    public static final String LIKE = "LIKE";

    public static final String LT = "<";

    public static final String LE = "<=";

    public static final String GT = ">";

    public static final String GE = ">=";

    public static final String NE = "<>";

    public static final String IN = "IN";

    public static final String NOT = "NOT";

    public static final String IS = "IS";

    private static final String SPACE = " ";

    public static final String IS_NOT = "IS" + SPACE + NOT;

    public static final String NOT_IN = NOT + SPACE + IN;

    public static final Object NULL = null;



}
