package com.example.asinit_user.parkingapp;


import net.openid.appauth.AuthorizationRequest;

public interface LoginCallback {
    void startMainActivity();

    void createRequest(AuthorizationRequest request);
}
