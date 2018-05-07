package com.example.asinit_user.parkingapp.mainView.usersView;

import com.example.asinit_user.parkingapp.model.User;
import com.example.asinit_user.parkingapp.repository.Repository;

public class UserDetailsPresenter {

    private Repository repository;

    public UserDetailsPresenter(Repository repository) {
        this.repository = repository;
    }


    public void updateUser(User user){
        repository.updateUser(user);
    }

    public void deleteUser(User user){
        repository.deleteUser(user);

    }
}
