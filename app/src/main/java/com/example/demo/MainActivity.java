package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demo.api.Communicator;
import com.example.demo.api.Constants;
import com.example.demo.api.CustomResponseListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.payg.LogDebug;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity implements CustomResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogDebug.d("Lokesh library");
        try {
            loginUser();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public void createOrder() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("Merchantkeyid", "7771");
        requestParams.put("UniqueRequestId", "34dfsf340");
        requestParams.put("OrderAmount", "24");
        requestParams.put("RedirectUrl", "https://a2zfame.com");

        Log.e("Params", requestParams.toString());
        Log.e("URL", Constants.Apis.CREATE_ORDER);
        Communicator communicator = new Communicator();
        communicator.post(1, this, Constants.Apis.CREATE_ORDER, requestParams, this);
    }

    @Override
    public void onResponse(int requestCode, String response) {
        Log.e("Response", response);
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(response);
//            String success = jsonObject.getString("success");
//            String message = jsonObject.getString("message");
//            int status = jsonObject.getInt("status");
//            if (success.equals("true")) {
//                if (status == 200) {
//                    JSONObject obj = jsonObject.getJSONObject("data");
//                    String _id          = obj.getString("_id");
//                } else {
//                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//                }
//            }else {
//                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onFailure(int statusCode, Throwable error) {
        Log.e("error", error.toString());

    }


    private void  loginUser() throws JSONException, UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
            jsonObject.put("Merchantkeyid", "7771");
            jsonObject.put("UniqueRequestId", "34dfsf342");
            jsonObject.put("OrderAmount", "24");
            jsonObject.put("RedirectUrl", "https://a2zfame.com");
            invokeWS(jsonObject);
    }

    private void invokeWS(JSONObject jsonObject) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(jsonObject.toString());
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization","Basic ZGNiM2VmNGQ4NDI1NDkyOWEwZTgxZjE0YzNkZGVmYmY6Y2IxMWQ2OTVkMjNlNGE3OGJlZjA0YjkwNTE5YjRiMzA6TTo3Nzcx");
        client.post(getApplicationContext(), "https://uatapi.payg.in/payment/api/order/create", entity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject obj) {
                Log.e("Response", obj.toString());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.e("Response", errorResponse.toString());
            }
        });
    }
}
