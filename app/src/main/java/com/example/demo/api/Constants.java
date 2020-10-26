package com.example.demo.api;


/**
 * Created by admin on 14-Oct-17.
 */

public class Constants {
    private static String BASE_URL = "https://uatapi.payg.in/payment/api/order";

    public static class Apis {
        public static final String CREATE_ORDER = BASE_URL + "create";
        public static final String UPDATE_ORDER = BASE_URL + "Update";
        public static final String DETAIL_ORDER = BASE_URL + "Detail";
    }

    public static class Params {
        public static final String USERNAME = "username";

    }
}
