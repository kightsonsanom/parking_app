package com.example.asinit_user.parkingapp.di;

import android.support.v4.app.Fragment;
import com.example.asinit_user.parkingapp.di.scopes.UserDetailScope;
import com.example.asinit_user.parkingapp.mainView.usersView.UserDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuildersModule_ContributeUserDetailsFragment.UserDetailsFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeUserDetailsFragment {
  private FragmentBuildersModule_ContributeUserDetailsFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(UserDetailsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      UserDetailsFragmentSubcomponent.Builder builder);

  @Subcomponent(modules = UserDetailsModule.class)
  @UserDetailScope
  public interface UserDetailsFragmentSubcomponent extends AndroidInjector<UserDetailsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserDetailsFragment> {}
  }
}
