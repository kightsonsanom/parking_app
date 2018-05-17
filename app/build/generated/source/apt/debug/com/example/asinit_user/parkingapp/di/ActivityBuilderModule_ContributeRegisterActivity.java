package com.example.asinit_user.parkingapp.di;

import android.app.Activity;
import com.example.asinit_user.parkingapp.di.scopes.RegisterActivityScope;
import com.example.asinit_user.parkingapp.registerView.RegisterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilderModule_ContributeRegisterActivity.RegisterActivitySubcomponent.class
)
public abstract class ActivityBuilderModule_ContributeRegisterActivity {
  private ActivityBuilderModule_ContributeRegisterActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(RegisterActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      RegisterActivitySubcomponent.Builder builder);

  @Subcomponent(modules = RegisterActivityModule.class)
  @RegisterActivityScope
  public interface RegisterActivitySubcomponent extends AndroidInjector<RegisterActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RegisterActivity> {}
  }
}
