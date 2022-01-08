package com.example.smsintegration.di.component;


import android.content.SharedPreferences;


import com.example.smsintegration.di.module.RetrofitModule;
import com.example.smsintegration.di.module.SharedPrefModule;
import com.example.smsintegration.di.scop.ApplicationScope;
import com.example.smsintegration.network_service.ApiInterface;
import com.example.smsintegration.ui.MainActivity;

import dagger.Component;


@ApplicationScope
@Component(modules = {RetrofitModule.class, SharedPrefModule.class})
public interface ApplicationComponent {

    ApiInterface getNetworkService();

    SharedPreferences sharedPrefences();

    void inject(MainActivity mainActivity);
}

