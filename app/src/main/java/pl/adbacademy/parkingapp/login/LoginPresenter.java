package pl.adbacademy.parkingapp.login;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import pl.adbacademy.parkingapp.repository.Repository;

import net.openid.appauth.AuthState;
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
                Uri.parse("http://10.0.2.2:8080/auth/realms/parking-users/protocol/openid-connect/auth") /* auth endpoint */,
                Uri.parse("http://10.0.2.2:8080/auth/realms/parking-users/protocol/openid-connect/token") /* token endpoint */
        );

        String clientId = "spring-app";
        Uri redirectUri = Uri.parse("http://10.0.2.2:8081/abc");
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(
                serviceConfiguration,
                clientId,
                RESPONSE_TYPE,
                redirectUri
        );
        builder.setScopes("profile, openid");
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
