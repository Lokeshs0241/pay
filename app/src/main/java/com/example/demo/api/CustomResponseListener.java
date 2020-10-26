package com.example.demo.api;

/**
 * Created by admin on 21-Aug-17.
 */

public interface CustomResponseListener {
    void onResponse(int requestCode, String response);
    void onFailure(int statusCode, Throwable error);
}
