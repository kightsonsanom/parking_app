package com.example.asinit_user.parkingapp.di;

import android.app.Activity;
import com.example.asinit_user.parkingapp.di.scopes.LoginActivityScope;
import com.example.asinit_user.parkingapp.login.LoginActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilderModule_ContributeLoginActivity.LoginActivitySubcomponent.class
)
public abstract class ActivityBuilderModule_ContributeLoginActivity {
  private ActivityBuilderModule_ContributeLoginActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(LoginActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      LoginActivitySubcomponent.Builder builder);

  @Subcomponent(modules = LoginActivityModule.class)
  @LoginActivityScope
  public interface LoginActivitySubcomponent extends AndroidInjector<LoginActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginActivity> {}
  }
}
