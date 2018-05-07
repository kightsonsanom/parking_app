package com.example.asinit_user.parkingapp;

import com.example.asinit_user.parkingapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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


}
