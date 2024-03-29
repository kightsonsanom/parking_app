package pl.adbacademy.parkingapp.login;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pl.adbacademy.parkingapp.R;

import pl.adbacademy.parkingapp.mainView.MainActivity;
import pl.adbacademy.parkingapp.registerView.RegisterActivity;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.TokenResponse;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private static final String USED_INTENT = "USED_INTENT";
    private static final String AUTHORIZATION_RESPONSE = "pl.adbacademy.parkingapp.HANDLE_AUTHORIZATION_RESPONSE";

    @BindView(R.id.login_button)
    Button loginButton;

    @Inject
    LoginPresenter loginPresenter;
    @BindView(R.id.register_button)
    Button registerButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        loginPresenter.setLoginCallback(this);
        loginPresenter.enablePostAuthorizationFlows();

        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        checkIntent(intent);
    }

    private void checkIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                switch (action) {
                    case AUTHORIZATION_RESPONSE:
                        if (!intent.hasExtra(USED_INTENT)) {
                            handleAuthorizationResponse(intent);
                            intent.putExtra(USED_INTENT, true);
                        }
                        break;
                    default:
                        // do nothing
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkIntent(getIntent());
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void startRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void createRequest(AuthorizationRequest request) {
        AuthorizationService authorizationService = new AuthorizationService(this);

        String action = AUTHORIZATION_RESPONSE;
        Intent postAuthorizationIntent = new Intent(action);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, request.hashCode(), postAuthorizationIntent, 0);
        authorizationService.performAuthorizationRequest(request, pendingIntent);
    }

    public void handleAuthorizationResponse(Intent intent) {
        AuthorizationResponse response = AuthorizationResponse.fromIntent(intent);
        AuthorizationException error = AuthorizationException.fromIntent(intent);
        final AuthState authState = new AuthState(response, error);

        if (response != null) {
            AuthorizationService service = new AuthorizationService(this);
            service.performTokenRequest(response.createTokenExchangeRequest(), (tokenResponse, exception) -> {
                if (exception == null) {
                    if (tokenResponse != null) {
                        authState.update(tokenResponse, exception);
                        loginPresenter.persistAuthState(authState);
                        loginPresenter.enablePostAuthorizationFlows();
                    }
                }
            });
        }
    }

    @OnClick({R.id.login_button, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
//                loginPresenter.doAuth();
                startMainActivity();
                break;
            case R.id.register_button:
                startRegisterActivity();
                break;
        }
    }
}
