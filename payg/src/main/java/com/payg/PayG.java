package com.payg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.payg.api.Communicator;
import com.payg.api.Constants;
import com.payg.api.CustomResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import cz.msebera.android.httpclient.entity.StringEntity;

public class PayG extends Activity {

    private static String AuthenticationKey = "dcb3ef4d84254929a0e81f14c3ddefbf";
    /**
     * @var string AuthenticationToken For Payment Provided By Gateway
     */
    private static String AuthenticationToken = "cb11d695d23e4a78bef04b90519b4b30";
    /**
     * @var string SecureHashKey For Payment Provided By Gateway
     */
    private static String SecureHashKey = "b29cd704083442e2ac2e73f903167da4";
    /**
     * @var string MerchantKeyId For Payment Provided By Gateway.
     */

    private static String UniqueRequestId = "EWHDK1h34D";
    private static String Merchantkeyid = "7771";

    private static final int REQUEST_CODE_PAYMENT = 1;
    private static final int REQUEST_CODE_FUTURE_PAYMENT = 2;

    private static android.app.Activity Activity;

    EditText etDetailsAmount;
    EditText etOrderType;
    EditText etAmountDiscount;
    EditText etAmount;
    EditText etCustomerNote;
    EditText etFirstName;
    EditText etLastName;
    EditText etMobileNo;
    EditText etEmail;
    EditText etEmailReceipt;
    EditText etBillingAddress;
    EditText etBillingCity;
    EditText etBillingState;
    EditText etBillingCountry;
    EditText etBillingZipCode;
    EditText etShippingFirstName;
    EditText etShippingLastName;
    EditText etShippingAddress;
    EditText etShippingCity;
    EditText etShippingState;
    EditText etShippingCountry;
    EditText etShippingZipCode;
    EditText etShippingMobileNo;
    EditText etUserName;
    EditText etSource;
    EditText etIntegrationType;
    EditText etHashData;
    EditText etPlatformId;
    EditText etRequestTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createOrder("7771","34dfsf345","24","https://a2zfame.com");

       /* List<String>orderAmountData = new ArrayList<>();
        orderAmountData.add(0,"AmountTypeDesc");
        orderAmountData.add(1,"Amount");

        List<String>transactionData = new ArrayList<>();
        transactionData.add(0,"AcceptedPaymentTypes");
        transactionData.add(1,"PaymentType");
        transactionData.add(2,"SurchargeType");
        transactionData.add(3,"SurchargeValue");
        transactionData.add(4,"RefTransactionId");
        transactionData.add(5,"IndustrySpecificationCode");
        transactionData.add(6,"PartialPaymentOption");

        List<String>customerData = new ArrayList<>();
        customerData.add(0,"CustomerId");
        customerData.add(1,"CustomerNotes");
        customerData.add(2,"FirstName");
        customerData.add(3,"LastName");
        customerData.add(4,"MobileNo");
        customerData.add(5,"Email");
        customerData.add(6,"EmailReceipt");
        customerData.add(7,"BillingAddress");
        customerData.add(8,"BillingCity");
        customerData.add(9,"BillingState");
        customerData.add(10,"BillingCountry");
        customerData.add(11,"BillingZipCode");
        customerData.add(12,"ShippingFirstName");
        customerData.add(13,"ShippingLastName");
        customerData.add(14,"ShippingAddress");
        customerData.add(15,"ShippingCity");
        customerData.add(16,"ShippingState");
        customerData.add(17,"ShippingCountry");
        customerData.add(18,"ShippingZipCode");
        customerData.add(19,"ShippingMobileNo");

        List<String>userDefinedData = new ArrayList<>();
        userDefinedData.add(0,"UserDefined1");
        userDefinedData.add(1,"UserDefined2");
        userDefinedData.add(2,"UserDefined3");
        userDefinedData.add(3,"UserDefined4");
        userDefinedData.add(4,"UserDefined5");

        List<String>integrationData = new ArrayList<>();
        integrationData.add(0,"UserName");
        integrationData.add(1,"Source");
        integrationData.add(2,"IntegrationType");
        integrationData.add(3,"HashData");
        integrationData.add(4,"PlatformId");*/

        init();
    }

    private void init() {


        etDetailsAmount    = findViewById(R.id.etDetailsAmount);
        etOrderType        = findViewById(R.id.etOrderType);
        etAmountDiscount   = findViewById(R.id.etAmountDiscount);
        etAmount           = findViewById(R.id.etAmount);
        etCustomerNote     = findViewById(R.id.etCustomerNote);
        etFirstName        = findViewById(R.id.etFirstName);
        etLastName         = findViewById(R.id.etLastName);
        etMobileNo         = findViewById(R.id.etMobileNo);
        etEmail            = findViewById(R.id.etEmail);
        etEmailReceipt     = findViewById(R.id.etEmailReceipt);
        etBillingAddress   = findViewById(R.id.etBillingAddress);
        etBillingCity      = findViewById(R.id.etBillingCity);
        etBillingState     = findViewById(R.id.etBillingState);
        etBillingCountry   = findViewById(R.id.etBillingCountry);
        etBillingZipCode   = findViewById(R.id.etBillingZipCode);
        etShippingFirstName= findViewById(R.id.etShippingFirstName);
        etShippingLastName = findViewById(R.id.etShippingLastName);
        etShippingAddress  = findViewById(R.id.etShippingAddress);
        etShippingCity     = findViewById(R.id.etShippingCity);
        etShippingState    = findViewById(R.id.etShippingState);
        etShippingCountry  = findViewById(R.id.etShippingCountry);
        etShippingZipCode  = findViewById(R.id.etShippingZipCode);
        etShippingMobileNo = findViewById(R.id.etShippingMobileNo);
        etUserName         = findViewById(R.id.etUserName);
        etSource           = findViewById(R.id.etSource);
        etIntegrationType  = findViewById(R.id.etIntegrationType);
        etHashData         = findViewById(R.id.etHashData);
        etPlatformId       = findViewById(R.id.etPlatformId);
        etRequestTime      = findViewById(R.id.etRequestTime);

    }

    public static String generateRandomString() {
        int length = 10;
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(length);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

//    public static void initializeSSLContext(Context mContext){
//        try {
//            SSLContext.getInstance("TLSv1.2");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            ProviderInstaller.installIfNeeded(mContext.getApplicationContext());
//        } catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
//    }


    public static void createOrder(String Merchantkeyid,String UniqueRequestId,String OrderAmount,String RedirectUrl) {
        /*jsonParams.put("Merchantkeyid", Merchantkeyid);
        jsonParams.put("UniqueRequestId", UniqueRequestId);
        jsonParams.put("OrderAmount", 10);
        jsonParams.put("OrderType", null);
        jsonParams.put("OrderId", null);
        jsonParams.put("OrderStatus", null);
        jsonParams.put("OrderAmountData", orderAmountData);//array
        jsonParams.put("ProductData", null);//json
        jsonParams.put("NextStepFlowData", null);
        jsonParams.put("TransactionData", transactionData);
        jsonParams.put("RedirectUrl", "https://test.com");
        jsonParams.put("CustomerData", customerData);
        jsonParams.put("UserDefinedData", userDefinedData);
        jsonParams.put("IntegrationData", integrationData);
        jsonParams.put("ShipmentData", null);
        jsonParams.put("RequestDateTime", 10282020);*/

        //progress bar show
        JSONObject jsonParams = new JSONObject();
        StringEntity entity = null;
        try {
            jsonParams.put("Merchantkeyid", "7771");
            jsonParams.put("UniqueRequestId", "34dfsf345");
            jsonParams.put("OrderAmount", "24");
            jsonParams.put("RedirectUrl", "https://a2zfame.com");

            entity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("Params", jsonParams.toString());
        Communicator communicator = new Communicator();
        communicator.post(1, Activity, Constants.Apis.CREATE_ORDER, entity, new CustomResponseListener() {
            @Override
            public void onResponse(int requestCode, String response) {
                Log.d("RESPONSE", response.toString());
            }

            @Override
            public void onFailure(int statusCode, Throwable error) {
                Log.d("Error", error.toString());
            }
        });
    }


    public static void updateOrder() {
    }
    public static void detailOrder() {
    }

}
