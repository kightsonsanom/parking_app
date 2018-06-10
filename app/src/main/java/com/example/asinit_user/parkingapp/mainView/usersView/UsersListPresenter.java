package com.example.asinit_user.parkingapp.mainView.usersView;

import android.support.v4.app.FragmentActivity;

import com.example.asinit_user.parkingapp.mainView.MainActivity;
import com.example.asinit_user.parkingapp.model.User;
import com.example.asinit_user.parkingapp.repository.Repository;

import java.util.ArrayList;
import java.util.List;


public class UsersListPresenter implements UserListCallback{

    private Repository repository;
    private List<User> registeredUsersList = new ArrayList<>();
    private List<User> unRegisteredUsersList = new ArrayList<>();

    public static final int REGISTERED_USERS_POSITION = 0;
    public static final int UNREGISTERED_USERS_POSITION = 1;


    public UsersListPresenter(Repository repository) {
        this.repository = repository;
    }


    public List<String> getUnregisteredUserNames() {
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

    public List<String> getRegisteredUserNames() {
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

    public void getUserDetailFragment(FragmentActivity activity, int position, int currentTabPosition) {

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
