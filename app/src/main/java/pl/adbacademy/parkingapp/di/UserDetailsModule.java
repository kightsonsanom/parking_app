package pl.adbacademy.parkingapp.di;


import pl.adbacademy.parkingapp.di.scopes.UserDetailScope;
import pl.adbacademy.parkingapp.mainView.usersView.UserDetailsPresenter;
import pl.adbacademy.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class UserDetailsModule {

    @Provides
    @UserDetailScope
    UserDetailsPresenter provideUserDetailsPresenter (Repository repository) {
        return new UserDetailsPresenter(repository);
    }
}

