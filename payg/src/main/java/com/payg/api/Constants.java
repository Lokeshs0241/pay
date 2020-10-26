package com.payg.api;

public class Constants {
    /** @var string This Request URL */
    private static String paymentURL = "https://uatapi.payg.in/payment/api/order";
    /** @var string AuthenticationKey For Payment Provided By Gateway */

    private static String BASE_URL = "https://uatapi.payg.in/payment/api/order";

    public static class Params {
//        public static final String DEVICE_TYPE = "Merchantkeyid";
//        public static final String DEVICE_TYPE_VALUE = "UniqueRequestId";
//        public static final String DEVICE_TOKEN = "OrderAmount";
//        public static final String DEVICE_TOKEN = "OrderAmount";

    }

    public static class Apis {
        public static final String CREATE_ORDER = paymentURL + "create";
        public static final String UPDATE_ORDER = paymentURL + "Update";
        public static final String DETAIL_ORDER = paymentURL + "Detail";

    }

}
