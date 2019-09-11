package com.example.asinit_user.parkingapp;

import com.example.asinit_user.parkingapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import timber.log.Timber;

public class ServerMock {

    private List<User> userList;
    private int parkingSlots;

    public ServerMock() {
        setUserList();
        setParkingSlots();
    }

    private void setParkingSlots() {
        parkingSlots = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    }

    private void setUserList() {
        userList = new ArrayList<>();
        userList.add(new User("Adam Kowalski", "kowal123","Adam", "Kowalski", "adamkowalski@gmail.com", "FZ456A"));
        userList.add(new User("Artur Nowak", "artur123","Artur", "Nowak", "arturnowak@gmail.com", "FZGS345A"));
        userList.add(new User("Wojtek Rafał", "wojtek123","Wojtek", "Rafał", "wojtekrafal@gmail.com", "FZ9034UJ"));

        userList.add(new User("Andrzej Artur", "andrzej123","Wojtek", "Rafał", "wojtekrafal@gmail.com", "FZ9034UJ",true));
        userList.add(new User("Wojtek Paweł", "wojtek123","Wojtek", "Rafał", "wojtekrafal@gmail.com", "FZ9034UJ",true));
    }

    public List<User> getUserList() {
        return userList;
    }

    public int getParkingSlots() {
        return parkingSlots;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void updateUserStatus(long userID, boolean status){
        int userPosition = getPositionForUser(userID);
        if (userPosition != -1) {
            userList.get(userPosition).setRegistered(status);
            Timber.d("updating user" + userList.get(userPosition));
        } else {
            Timber.d("No user with such id");
        }
    }

    private int getPositionForUser(long userID) {
        int userPosition = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userID == userList.get(i).getId()){
                userPosition = i;
            }
        }
        return userPosition;
    }

    public void deleteUser(long id) {
        int userPosition = getPositionForUser(id);
        if (userPosition != -1) {
            userList.remove(userPosition);
        } else {
            Timber.d("No user with such id");
        }
    }
}
