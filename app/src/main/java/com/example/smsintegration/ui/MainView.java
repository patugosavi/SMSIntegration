package com.example.smsintegration.ui;

import okhttp3.ResponseBody;

public interface MainView {
    void showProgressBar();
    void hideProgressBar();
    void onSuccess(ResponseBody a);
    void onFailure(String s);
}
