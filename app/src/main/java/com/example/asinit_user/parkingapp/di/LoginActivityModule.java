package com.example.asinit_user.parkingapp.di;

import android.app.Application;

import com.example.asinit_user.parkingapp.di.scopes.LoginActivityScope;
import com.example.asinit_user.parkingapp.login.LoginPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;
import com.example.asinit_user.parkingapp.repository.SharedPreferencesRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    @LoginActivityScope
    LoginPresenter provideLoginPresenter(Repository repository, Application application) {
        return new LoginPresenter(repository, application.getApplicationContext());}
}
