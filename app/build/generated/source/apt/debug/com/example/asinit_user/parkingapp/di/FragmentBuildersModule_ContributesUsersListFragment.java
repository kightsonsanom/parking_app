package com.example.asinit_user.parkingapp.di;

import android.support.v4.app.Fragment;
import com.example.asinit_user.parkingapp.di.scopes.UsersListScope;
import com.example.asinit_user.parkingapp.mainView.usersView.UsersListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuildersModule_ContributesUsersListFragment.UsersListFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributesUsersListFragment {
  private FragmentBuildersModule_ContributesUsersListFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(UsersListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      UsersListFragmentSubcomponent.Builder builder);

  @Subcomponent(modules = UsersListModule.class)
  @UsersListScope
  public interface UsersListFragmentSubcomponent extends AndroidInjector<UsersListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UsersListFragment> {}
  }
}
