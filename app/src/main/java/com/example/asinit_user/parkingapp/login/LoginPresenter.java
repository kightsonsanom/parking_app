package com.example.asinit_user.parkingapp.login;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.example.asinit_user.parkingapp.mainView.MainActivity;
import com.example.asinit_user.parkingapp.repository.Repository;
import com.example.asinit_user.parkingapp.repository.SharedPreferencesRepo;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.TokenResponse;

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
//            if (mMakeApiCall.getVisibility() == View.GONE) {
//                mMakeApiCall.setVisibility(View.VISIBLE);
//                mMakeApiCall.setOnClickListener(new MakeApiCallListener(this, mAuthState, new AuthorizationService(this)));
//            }
//            if (mSignOut.getVisibility() == View.GONE) {
//                mSignOut.setVisibility(View.VISIBLE);
//                mSignOut.setOnClickListener(new SignOutListener(this));
//            }
//        } else {
//            mMakeApiCall.setVisibility(View.GONE);
//            mSignOut.setVisibility(View.GONE);
//        }
    }

    @Nullable
    private AuthState restoreAuthState() {
        String jsonString = repository.getAuthState();
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                return AuthState.jsonDeserialize(jsonString);
            } catch (JSONException jsonException) {
                // should never happen
            }
        }
        return null;
    }

    public void handleAuthorizationResponse(Intent intent) {
        AuthorizationResponse response = AuthorizationResponse.fromIntent(intent);
        AuthorizationException error = AuthorizationException.fromIntent(intent);
        final AuthState authState = new AuthState(response, error);

        if (response != null) {
            Timber.d(String.format("Handled Authorization Response %s ", authState.jsonSerializeString()));
            AuthorizationService service = new AuthorizationService(context);
            service.performTokenRequest(response.createTokenExchangeRequest(), new AuthorizationService.TokenResponseCallback() {
                @Override
                public void onTokenRequestCompleted(@Nullable TokenResponse tokenResponse, @Nullable AuthorizationException exception) {
                    if (exception != null) {
                        Timber.d("Token Exchange failed" + exception.toString());
                    } else {
                        if (tokenResponse != null) {
                            authState.update(tokenResponse, exception);
                            repository.persistAuthState(authState);
                            Timber.d(String.format("Token Response [ Access Token: %s, ID Token: %s ]", tokenResponse.accessToken, tokenResponse.idToken));
                            enablePostAuthorizationFlows();
                        }
                    }
                }
            });
        }
    }
}
