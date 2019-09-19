package pl.adbacademy.parkingapp.di;

import pl.adbacademy.parkingapp.di.scopes.ParkingSlotsScope;
import pl.adbacademy.parkingapp.mainView.parkingView.ParkingSlotsPresenter;
import pl.adbacademy.parkingapp.repository.Repository;

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
