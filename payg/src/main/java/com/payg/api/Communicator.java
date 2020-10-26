package com.payg.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;


public class Communicator {

    public void post(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();

//        client.addHeader("api_access_key", "945]Y3x[aRJS}DxE");
//        client.addHeader("jwt_token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjYiLCJleHBpcmVzIjoxNTM2MTI3NzM3fQ.vOLG2Ez_N9UGqBstdLe4pWNj_N2vI9Ou8UhPDrSgDLs");
        client.addHeader("Content-Type", "application/json");
        client.addHeader("","");
        client.setTimeout(5*60000);
        client.setResponseTimeout(5*60000);
        client.post(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.d("Response", response);
                responseListener.onResponse(reqCode, response.trim());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Error", error.toString());
//                Utils.hideProgressBar();
                responseListener.onFailure(reqCode, error);
            }

        });

        Log.d("URL", url);


    }

    public void postMultipart(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Content-Type", "multipart/form-data");
        client.setTimeout(5*60000);
        client.setResponseTimeout(5*60000);
        client.post(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                responseListener.onResponse(reqCode, response.trim());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseListener.onFailure(reqCode, error);
            }

        });

    }

    public void get(final int reqCode, final Context context, String url, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(1, 60000);
        client.get(context, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.d("Response", response);
                responseListener.onResponse(reqCode, response.trim());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                Utils.hideProgressBar();
                Log.d("Error", error.toString());
                responseListener.onFailure(reqCode, error);
            }

        });
        Log.d("URL", url);

    }

    public void get(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(2, 5*60000);
        client.get(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.d("Response", response);
                responseListener.onResponse(reqCode, response.trim());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Error", error.toString());
//                Utils.hideProgressBar();
                responseListener.onFailure(reqCode, error);
            }
        });
        Log.d("URL", url);

    }


    public void post(final int reqCode, final Context context, String url, StringEntity entity, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();

        client.addHeader("Authorization","Basic ZGNiM2VmNGQ4NDI1NDkyOWEwZTgxZjE0YzNkZGVmYmY6Y2IxMWQ2OTVkMjNlNGE3OGJlZjA0YjkwNTE5YjRiMzA6TTo3Nzcx");
//        client.addHeader("Content-Type", "application/json");
        client.setTimeout(5 * 60000);
        client.post(context, url, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.d("Response", response);
                responseListener.onResponse(reqCode, response.trim());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Error", error.toString());
//                Utils.hideProgressBar();
                responseListener.onFailure(reqCode, error);
            }

        });

        Log.d("URL", url);

    }


}