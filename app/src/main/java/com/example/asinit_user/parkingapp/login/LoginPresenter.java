package com.example.asinit_user.parkingapp.login;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.asinit_user.parkingapp.repository.Repository;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationServiceConfiguration;

import org.json.JSONException;

import javax.inject.Inject;

import timber.log.Timber;


public class LoginPresenter {

    private static final String RESPONSE_TYPE = "code";
    AuthState mAuthState;


    private LoginCallback loginCallback;
    private Repository repository;
    private Context context;

    public void setLoginCallback(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    @Inject
    public LoginPresenter(Repository repository, Context context) {
        this.repository = repository;
        this.context = context;
    }


    public void doAuth() {

        AuthorizationServiceConfiguration serviceConfiguration = new AuthorizationServiceConfiguration(
                Uri.parse("https://accounts.google.com/o/oauth2/v2/auth") /* auth endpoint */,
                Uri.parse("https://www.googleapis.com/oauth2/v4/token") /* token endpoint */
        );

        String clientId = "111410532205-8n23r19d1m9pltrv4i3s6jjs5mu9j1dk.apps.googleusercontent.com";
        Uri redirectUri = Uri.parse("com.googleusercontent.apps.111410532205-8n23r19d1m9pltrv4i3s6jjs5mu9j1dk:/oauth2redirect");
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(
                serviceConfiguration,
                clientId,
                RESPONSE_TYPE,
                redirectUri
        );
        builder.setScopes("profile");
        AuthorizationRequest request = builder.build();
        loginCallback.createRequest(request);
    }


    public void enablePostAuthorizationFlows() {
        mAuthState = restoreAuthState();
        if (mAuthState != null && mAuthState.isAuthorized()) {
            loginCallback.startMainActivity();
        }

    }


    @Nullable
    private AuthState restoreAuthState() {
        String jsonString = repository.getAuthState();
        Timber.d("get auth state = " + jsonString);
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                return AuthState.fromJson(jsonString);
            } catch (JSONException jsonException) {
                // should never happen
            }
        }
        return null;
    }

    public void persistAuthState(AuthState authState) {
        repository.persistAuthState(authState);
    }
}
