package com.example.asinit_user.parkingapp.di;


import com.example.asinit_user.parkingapp.di.scopes.LoginActivityScope;
import com.example.asinit_user.parkingapp.di.scopes.MainActivityScope;
import com.example.asinit_user.parkingapp.di.scopes.RegisterActivityScope;
import com.example.asinit_user.parkingapp.LoginActivity;
import com.example.asinit_user.parkingapp.mainView.MainActivity;
import com.example.asinit_user.parkingapp.registerView.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilderModule {

    @LoginActivityScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributeLoginActivity();

    @MainActivityScope
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

    @RegisterActivityScope
    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributeRegisterActivity();


}