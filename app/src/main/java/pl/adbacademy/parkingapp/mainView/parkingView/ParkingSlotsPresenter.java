package pl.adbacademy.parkingapp.mainView.parkingView;

import pl.adbacademy.parkingapp.repository.Repository;

public class ParkingSlotsPresenter {



    private Repository repository;


    public ParkingSlotsPresenter(Repository repository){
        this.repository = repository;
    }


    public int getParkingSlots() {
        return repository.getParkingSlots();
    }
}
