package com.example.asinit_user.parkingapp.di;

import android.app.Application;

import com.example.asinit_user.parkingapp.di.scopes.LoginActivityScope;
import com.example.asinit_user.parkingapp.LoginPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    @LoginActivityScope
    LoginPresenter provideLoginPresenter(Repository repository, Application application) {
        return new LoginPresenter(repository, application.getApplicationContext());}
}
