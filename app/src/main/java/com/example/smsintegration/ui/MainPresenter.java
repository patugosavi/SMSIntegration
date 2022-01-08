package com.example.smsintegration.ui;

import com.example.smsintegration.network_service.ApiInterface;
import com.example.smsintegration.utils.ErrorUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainPresenter {

    private MainView mainView;
    private ApiInterface apiInterface;
    private Disposable disposable;

    public MainPresenter(MainView mainView, ApiInterface apiInterface) {
        this.mainView = mainView;
        this.apiInterface = apiInterface;
    }


    public void smsLink(String url) {
        Observable<ResponseBody> observable = apiInterface.sendSms(url);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(ResponseBody str) {
                        mainView.onSuccess(str);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainView.onFailure(ErrorUtil.onError(e));

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
