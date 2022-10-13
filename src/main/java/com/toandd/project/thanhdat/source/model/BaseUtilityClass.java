package com.toandd.project.thanhdat.source.model;

import lombok.experimental.UtilityClass;

import javax.persistence.JoinColumn;

@UtilityClass
public class BaseUtilityClass {

    @UtilityClass
    public static class TypeProduct {

        public static final String TABLE_NAME = "T_TYPE_PRODUCT";
        public static final String NAME = "T_NAme";
        public static final String CODE = "T_CODE";
        public static final String DESCRIPTION = "T_DESCRIPTION";

    };
    @UtilityClass
    public static class GroupProduct {

        public static final String TABLE_NAME = "T_GROUP_PRODUCT";
        public static final String NAME = "T_NAME";
        public static final String CODE = "T_CODE";
        public static final String DESCRIPTION = "T_DESCRIPTION";

    };

    @UtilityClass
    public static class OrderMappedProduct {

        public static final String PRODUCT_MAPPED_ORDER = "products";
        public static final String JOIN_TABLE = "T_ORDER_MAPPED_PRODUCT";
        public static final String JOIN_TABLE_ORDER_ID = "T_ORDER_ID";
        public static final String JOIN_TABLE_PRODUCT_ID = "T_PRODUCT_ID";
    };

    @UtilityClass
    public static class Product {

        public static final String TABLE_NAME = "T_PRODUCT";
        public static final String NAME = "T_NAME";
        public static final String CODE = "T_CODE";
        public static final String DESCRIPTION = "T_DESCRIPTION";
        public static final String BUY_PRICE = "T_BUY_PRICE";
        public static final String URL_IMAGE = "T_URL_IMAGE";
        public static final String REGEX ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    };

    @UtilityClass
    public static class Order {

        public static final String TABLE_NAME = "T_ORDER" ;
        public static final String CODE = "T_CODE";

        public static final String DESCRIPTION = "T_DESCRIPTION" ;
        public static final String ORDER_DATE = "T_ORDER_DATE" ;
        public static final String REQUIRED_DATE = "T_REQUIRED_DATE" ;
        public static final String STATUS = "T_STATUS" ;

        public static final String TOTAL_ORDER = "T_TOTAL_ORDER";
        public static final String NAME = "T_NAME";
    };

    @UtilityClass
    public static class Customer {
        public static final String TABLE_NAME = "T_CUSTOMER";
        public static final String NAME = "T_NAME";
        public static final String CODE = "T_CODE";

        public static final String PHONE = "T_PHONE";
        public static final String ADDRESS = "T_ADDRESS";
        public static final String CITY = "T_CITY";
        public static final String COUNTRY = "T_COUNTRY";
    };

}