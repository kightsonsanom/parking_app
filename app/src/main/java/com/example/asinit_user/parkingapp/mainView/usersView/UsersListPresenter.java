package com.example.asinit_user.parkingapp.mainView.usersView;

import android.support.v4.app.FragmentActivity;

import com.example.asinit_user.parkingapp.mainView.MainActivity;
import com.example.asinit_user.parkingapp.model.User;
import com.example.asinit_user.parkingapp.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class UsersListPresenter {

    private Repository repository;
    private List<User> userList;

    public UsersListPresenter(Repository repository) {
        this.repository = repository;
    }


    public List<String> getUnregisteredUserNames() {
        Timber.d("getUnregisteredUserNames");
        userList = repository.getUserList();
        List<String> userNames = new ArrayList<>();

        for (User user : userList) {
            if (!user.isRegistered()) {
                userNames.add(user.getUsername());
            }
        }
        return userNames;
    }

    public List<String> getRegisteredUserNames() {
        Timber.d("getRegisteredUserNames");
        userList = repository.getUserList();
        List<String> userNames = new ArrayList<>();

        for (User user : userList) {
            if (user.isRegistered()) {
                userNames.add(user.getUsername());
            }
        }
        return userNames;
    }

    public void getUserDetailFragment(FragmentActivity activity, int position) {
        ((MainActivity)activity).enterDetailFragment(userList.get(position));
    }
}
