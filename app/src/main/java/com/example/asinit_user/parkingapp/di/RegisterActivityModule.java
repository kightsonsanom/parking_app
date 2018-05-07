package com.example.asinit_user.parkingapp.di;

import android.app.Application;

import com.example.asinit_user.parkingapp.di.scopes.RegisterActivityScope;
import com.example.asinit_user.parkingapp.registerView.RegisterPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterActivityModule {

    @Provides
    @RegisterActivityScope
    RegisterPresenter provideRegisterPresenter(Repository repository, Application application) {
        return new RegisterPresenter(repository, application.getApplicationContext());}
}
