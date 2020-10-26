package com.example.demo.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;


/**
 * Created by arthonsystechnologiesllp on 03/03/17.
 */

public class Communicator {

//    final CustomResponseListener responseListener

    public void post(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener){
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Content-Type", "application/json");
        client.addHeader("Authorization","Basic ZGNiM2VmNGQ4NDI1NDkyOWEwZTgxZjE0YzNkZGVmYmY6Y2IxMWQ2OTVkMjNlNGE3OGJlZjA0YjkwNTE5YjRiMzA6TTo3Nzcx");
        client.setTimeout(10000);
        client.setResponseTimeout(10000);
        client.post(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                responseListener.onResponse(reqCode, response.trim());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseListener.onFailure(statusCode, error);
            }

        });

    }

    public void postMultipart(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener){
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Content-Type","multipart/form-data");
        client.setTimeout(10000);
        client.setResponseTimeout(10000);
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

    public void get(final int reqCode, final Context context, String url, final CustomResponseListener responseListener){
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(1, 10000);
        client.get(context, url, new AsyncHttpResponseHandler() {
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

    public void get(final int reqCode, final Context context, String url, RequestParams params, final CustomResponseListener responseListener){
        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(2, 10000);
        client.get(context, url, params, new AsyncHttpResponseHandler() {
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

    public void post(final int reqCode, final Context context, String url, StringEntity entity, final CustomResponseListener responseListener){
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60000);
        client.setResponseTimeout(60000);
        client.post(context, url, entity, "application/json", new AsyncHttpResponseHandler() {
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

        Log.e("URL", url);

    }


    public void postJson(final int reqCode, final Context context, String url, StringEntity entity, final CustomResponseListener responseListener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization","Basic ZGNiM2VmNGQ4NDI1NDkyOWEwZTgxZjE0YzNkZGVmYmY6Y2IxMWQ2OTVkMjNlNGE3OGJlZjA0YjkwNTE5YjRiMzA6TTo3Nzcx");
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