package com.example.asinit_user.parkingapp.di;

import android.support.v4.app.Fragment;
import com.example.asinit_user.parkingapp.di.scopes.ParkingSlotsScope;
import com.example.asinit_user.parkingapp.mainView.parkingView.ParkingSlotsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuildersModule_ContributeParkingSlotsFragment.ParkingSlotsFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeParkingSlotsFragment {
  private FragmentBuildersModule_ContributeParkingSlotsFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(ParkingSlotsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ParkingSlotsFragmentSubcomponent.Builder builder);

  @Subcomponent(modules = ParkingSlotsModule.class)
  @ParkingSlotsScope
  public interface ParkingSlotsFragmentSubcomponent extends AndroidInjector<ParkingSlotsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ParkingSlotsFragment> {}
  }
}
