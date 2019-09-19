package pl.adbacademy.parkingapp.mainView.usersView;

import android.support.v4.app.FragmentActivity;

import pl.adbacademy.parkingapp.mainView.MainActivity;
import pl.adbacademy.parkingapp.model.User;
import pl.adbacademy.parkingapp.repository.Repository;

import java.util.ArrayList;
import java.util.List;


public class UsersListPresenter implements UserListCallback{

    private Repository repository;
    private List<User> registeredUsersList = new ArrayList<>();
    private List<User> unRegisteredUsersList = new ArrayList<>();

    private static final int REGISTERED_USERS_POSITION = 0;
    private static final int UNREGISTERED_USERS_POSITION = 1;


    public UsersListPresenter(Repository repository) {
        this.repository = repository;
    }


    List<String> getUnregisteredUserNames() {
        List<User> userList = repository.getUserList();
        List<String> userNames = new ArrayList<>();

        for (User user : userList) {
            if (!user.isRegistered()) {
                userNames.add(user.getUsername());
                unRegisteredUsersList.add(user);
            }
        }
        return userNames;
    }

    List<String> getRegisteredUserNames() {
        List<User> userList = repository.getUserList();
        List<String> userNames = new ArrayList<>();

        for (User user : userList) {
            if (user.isRegistered()) {
                userNames.add(user.getUsername());
                registeredUsersList.add(user);
            }
        }
        return userNames;
    }

    void getUserDetailFragment(FragmentActivity activity, int position, int currentTabPosition) {

        switch (currentTabPosition) {
            case 0:
                ((MainActivity) activity).enterDetailFragment(registeredUsersList.get(position),REGISTERED_USERS_POSITION);
                break;
            case 1:
                ((MainActivity) activity).enterDetailFragment(unRegisteredUsersList.get(position), UNREGISTERED_USERS_POSITION);
                break;
            default:


        }

    }
}
