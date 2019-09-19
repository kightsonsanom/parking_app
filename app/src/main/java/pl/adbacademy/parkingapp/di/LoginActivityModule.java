package pl.adbacademy.parkingapp.di;

import android.app.Application;

import pl.adbacademy.parkingapp.di.scopes.LoginActivityScope;
import pl.adbacademy.parkingapp.login.LoginPresenter;
import pl.adbacademy.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    @LoginActivityScope
    LoginPresenter provideLoginPresenter(Repository repository, Application application) {
        return new LoginPresenter(repository, application.getApplicationContext());}
}
