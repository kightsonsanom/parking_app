package pl.adbacademy.parkingapp.login;


import net.openid.appauth.AuthorizationRequest;

public interface LoginCallback {
    void startMainActivity();

    void createRequest(AuthorizationRequest request);
}
