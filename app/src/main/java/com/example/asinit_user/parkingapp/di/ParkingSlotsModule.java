package com.example.asinit_user.parkingapp.di;

import com.example.asinit_user.parkingapp.di.scopes.ParkingSlotsScope;
import com.example.asinit_user.parkingapp.mainView.parkingView.ParkingSlotsPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class ParkingSlotsModule {

    @Provides
    @ParkingSlotsScope
    ParkingSlotsPresenter provideParkingSlotsPresenter(Repository repository) {
        return new ParkingSlotsPresenter(repository);
    }

}
