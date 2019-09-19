package pl.adbacademy.parkingapp.di;

import android.app.Application;

import pl.adbacademy.parkingapp.di.scopes.RegisterActivityScope;
import pl.adbacademy.parkingapp.registerView.RegisterPresenter;
import pl.adbacademy.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterActivityModule {

    @Provides
    @RegisterActivityScope
    RegisterPresenter provideRegisterPresenter(Repository repository, Application application) {
        return new RegisterPresenter(repository, application.getApplicationContext());}
}
