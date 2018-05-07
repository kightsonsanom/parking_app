package com.example.asinit_user.parkingapp.mainView.parkingView;

import com.example.asinit_user.parkingapp.repository.Repository;

import javax.inject.Inject;

public class ParkingSlotsPresenter {



    private Repository repository;


    public ParkingSlotsPresenter(Repository repository){
        this.repository = repository;
    }


    public int getParkingSlots() {
        return repository.getParkingSlots();
    }
}
