package com.example.asinit_user.parkingapp.di;

import android.app.Activity;
import com.example.asinit_user.parkingapp.di.scopes.MainActivityScope;
import com.example.asinit_user.parkingapp.mainView.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilderModule_ContributeMainActivity.MainActivitySubcomponent.class)
public abstract class ActivityBuilderModule_ContributeMainActivity {
  private ActivityBuilderModule_ContributeMainActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Builder builder);

  @Subcomponent(modules = FragmentBuildersModule.class)
  @MainActivityScope
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
  }
}
