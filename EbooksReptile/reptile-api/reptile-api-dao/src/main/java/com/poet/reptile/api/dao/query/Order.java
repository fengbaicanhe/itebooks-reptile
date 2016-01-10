package com.poet.reptile.api.dao.query;

/**
 * @author 徐成龙
 */
public class Order {

    private static final String ASC = "asc";
    private static final String DESC = "desc";

    private String orderProperty;

    private String orderType;

    private Order(String orderProperty, String orderType) {
        this.orderProperty = orderProperty;
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderProperty() {
        return orderProperty;
    }

    public void setOrderProperty(String orderProperty) {
        this.orderProperty = orderProperty;
    }


    // =====  factory methods
    public static Order desc(String propertyName) {
        return new Order(propertyName, DESC);
    }

    public static Order asc(String propertyName) {
        return new Order(propertyName, ASC);
    }


}
