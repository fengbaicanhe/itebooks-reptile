package com.poet.reptile.api.dao.query;

/**
 * @author 徐成龙
 */
public class ResultLimit {

    private int start;
    private int size;

    private ResultLimit(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    // ===============

    public static ResultLimit limit(int start, int size) {
        return new ResultLimit(start, size);
    }


}
