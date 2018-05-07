package com.example.asinit_user.parkingapp.registerView;

import android.content.Context;

import com.example.asinit_user.parkingapp.model.User;
import com.example.asinit_user.parkingapp.repository.Repository;

public class RegisterPresenter {

    private Repository repository;
    private Context context;
    private RegisterActivity registerActivityCallback;

    public RegisterPresenter(Repository repository, Context context) {
        this.repository = repository;
        this.context = context;
    }

    public void setRegisterActivityCallback(RegisterActivity registerActivityCallback) {
        this.registerActivityCallback = registerActivityCallback;
    }

    public String isEmpty(String s) {
        if (s.isEmpty() || s.equals("")){
            registerActivityCallback.showError("Nazwa użytkownika nie może być pusta");

            return null;
        } else {
            return s;
        }
    }

    public void sendRegisterData(User user) {
       repository.sendRegisterData(user);
    }
}
