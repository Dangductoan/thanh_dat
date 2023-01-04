package com.toandd.project.thanhdat.source.model;

import lombok.experimental.UtilityClass;


@UtilityClass
public class BaseUtilityClass {

    @UtilityClass
    public static class ProductOrder {

        public static final String TABLE_NAME = "T_PRODUCT_ORDER" ;

        public static final String QUANTITY = "T_QUANTITY";
        public static final String LAST_PRICE = "T_LAST_PRICE";
    };

    @UtilityClass
    public static class TypeProduct {

        public static final String TABLE_NAME = "T_TYPE_PRODUCT";
        public static final String NAME = "T_NAme";
        public static final String CODE = "T_CODE";
        public static final String DESCRIPTION = "T_DESCRIPTION";

        public static final String GROUP_PRODUCT = "T_GROUP_PRODUCT";
    };


    @UtilityClass
    public static class Product {

        public static final String TABLE_NAME = "T_PRODUCT";
        public static final String NAME = "T_NAME";
        public static final String CODE = "T_CODE";
        public static final String DESCRIPTION = "T_DESCRIPTION";
        public static final String BUY_PRICE = "T_BUY_PRICE";
        public static final String FIRST_PRICE = "T_FIRST_PRICE";
        public static final String URL_IMAGE = "T_URL_IMAGE";

        public static final String SELF_PRICE = "SELF_PRICE" ;
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
        public static final String DESCRIPTION = "T_DESCRIPTION" ;
    };

}
