package pl.adbacademy.parkingapp.di;

import pl.adbacademy.parkingapp.di.scopes.UsersListScope;
import pl.adbacademy.parkingapp.mainView.usersView.UsersListPresenter;
import pl.adbacademy.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersListModule {

    @Provides
    @UsersListScope
    UsersListPresenter provideUsersListPresenter(Repository repository) {
        return new UsersListPresenter(repository);
    }
}
