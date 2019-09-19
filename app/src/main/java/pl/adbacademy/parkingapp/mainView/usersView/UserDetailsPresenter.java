package pl.adbacademy.parkingapp.mainView.usersView;

import pl.adbacademy.parkingapp.model.User;
import pl.adbacademy.parkingapp.repository.Repository;

public class UserDetailsPresenter {

    private Repository repository;

    public UserDetailsPresenter(Repository repository) {
        this.repository = repository;
    }


    void updateUser(User user){
        repository.updateUser(user);
    }

    void deleteUser(User user){
        repository.deleteUser(user);

    }
}
