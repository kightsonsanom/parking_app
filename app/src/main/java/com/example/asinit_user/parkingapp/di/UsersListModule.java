package com.example.asinit_user.parkingapp.di;

import com.example.asinit_user.parkingapp.di.scopes.ParkingSlotsScope;
import com.example.asinit_user.parkingapp.di.scopes.UsersListScope;
import com.example.asinit_user.parkingapp.mainView.parkingView.ParkingSlotsPresenter;
import com.example.asinit_user.parkingapp.mainView.usersView.UsersListPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;

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
