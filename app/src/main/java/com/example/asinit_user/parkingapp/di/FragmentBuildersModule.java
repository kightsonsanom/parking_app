package com.example.asinit_user.parkingapp.di;

import com.example.asinit_user.parkingapp.di.scopes.ParkingSlotsScope;
import com.example.asinit_user.parkingapp.di.scopes.UserDetailScope;
import com.example.asinit_user.parkingapp.di.scopes.UsersListScope;
import com.example.asinit_user.parkingapp.mainView.parkingView.ParkingSlotsFragment;
import com.example.asinit_user.parkingapp.mainView.usersView.UserDetailsFragment;
import com.example.asinit_user.parkingapp.mainView.usersView.UsersListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ParkingSlotsScope
    @ContributesAndroidInjector(modules = ParkingSlotsModule.class)
    abstract ParkingSlotsFragment contributeParkingSlotsFragment();

    @UsersListScope
    @ContributesAndroidInjector(modules = UsersListModule.class)
    abstract UsersListFragment contributesUsersListFragment();

    @UserDetailScope
    @ContributesAndroidInjector(modules = UserDetailsModule.class)
    abstract UserDetailsFragment contributeUserDetailsFragment();

}
