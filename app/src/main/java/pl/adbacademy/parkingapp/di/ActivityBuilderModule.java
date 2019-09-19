package pl.adbacademy.parkingapp.di;


import pl.adbacademy.parkingapp.di.scopes.LoginActivityScope;
import pl.adbacademy.parkingapp.di.scopes.MainActivityScope;
import pl.adbacademy.parkingapp.di.scopes.RegisterActivityScope;
import pl.adbacademy.parkingapp.login.LoginActivity;
import pl.adbacademy.parkingapp.mainView.MainActivity;
import pl.adbacademy.parkingapp.registerView.RegisterActivity;

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