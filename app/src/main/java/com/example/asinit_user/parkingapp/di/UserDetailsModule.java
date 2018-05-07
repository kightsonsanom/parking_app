package com.example.asinit_user.parkingapp.di;


import com.example.asinit_user.parkingapp.di.scopes.UserDetailScope;
import com.example.asinit_user.parkingapp.di.scopes.UsersListScope;
import com.example.asinit_user.parkingapp.mainView.usersView.UserDetailsPresenter;
import com.example.asinit_user.parkingapp.mainView.usersView.UsersListPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;

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

