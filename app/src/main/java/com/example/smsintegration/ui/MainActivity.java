package com.example.smsintegration.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.smsintegration.R;
import com.example.smsintegration.baseclass.BaseActivity;
import com.example.smsintegration.di.component.ApplicationComponent;
import com.example.smsintegration.network_service.ApiInterface;
import com.example.smsintegration.utils.BaseApp;
import com.example.smsintegration.utils.SmsOperations;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity implements MainView{

    String number="9565856525";

    @Inject
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Inject
    ApiInterface apiInterface;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter=new MainPresenter(this,apiInterface);

        createSmsLink(number);
    }

    @Override
    protected void injectDependencies(BaseApp baseApp, ApplicationComponent component) {
        component.inject(this);
    }

    private void createSmsLink(String mobileNo) {
        int val = 1234;
        String mobileN="91"+mobileNo;
        String url = SmsOperations.getSmsUrl("1207163376364313521",mobileNo, "Hi, Your One Time Password (OTP) for registration is " + val+ ". - GITHUB");
        Log.d("TAG", "createSmsLink: " + url);
        sendSms(url);
    }

    private void sendSms(String url) {
        presenter.smsLink(url);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onSuccess(ResponseBody a) {

    }

    @Override
    public void onFailure(String s) {

    }
}