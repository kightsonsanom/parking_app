package pl.adbacademy.parkingapp.di;

import pl.adbacademy.parkingapp.di.scopes.ParkingSlotsScope;
import pl.adbacademy.parkingapp.di.scopes.UserDetailScope;
import pl.adbacademy.parkingapp.di.scopes.UsersListScope;
import pl.adbacademy.parkingapp.mainView.parkingView.ParkingSlotsFragment;
import pl.adbacademy.parkingapp.mainView.usersView.UserDetailsFragment;
import pl.adbacademy.parkingapp.mainView.usersView.UsersListFragment;

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
