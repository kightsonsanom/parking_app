package com.example.asinit_user.parkingapp.login;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.mainView.MainActivity;
import com.example.asinit_user.parkingapp.registerView.RegisterActivity;

import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private static final String USED_INTENT = "USED_INTENT";

    @BindView(R.id.login_button)
    Button loginButton;

    @Inject
    LoginPresenter loginPresenter;
    @BindView(R.id.login_checkbox)
    CheckBox loginCheckbox;
    @BindView(R.id.register_button)
    Button registerButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        loginPresenter.setLoginCallback(this);
        loginPresenter.enablePostAuthorizationFlows();


        Timber.d("onCreate from LoginActivity");
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        Timber.d("new intent arrived");
        checkIntent(intent);
    }

    private void checkIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Timber.d("action from checkIntent = " + action);
            switch (action) {
                case "com.example.asinit_user.parkingapp.HANDLE_AUTHORIZATION_RESPONSE":
                    if (!intent.hasExtra(USED_INTENT)) {
                        loginPresenter.handleAuthorizationResponse(intent);
                        intent.putExtra(USED_INTENT, true);
                    }
                    break;
                default:
                    // do nothing
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

        String action = "com.example.asinit_user.parkingapp.HANDLE_AUTHORIZATION_RESPONSE";
        Intent postAuthorizationIntent = new Intent(action);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, request.hashCode(), postAuthorizationIntent, 0);
        authorizationService.performAuthorizationRequest(request, pendingIntent);
    }

    @OnClick({R.id.login_button, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                if (loginCheckbox.isChecked()) {
                    startMainActivity();
                } else {
                    loginPresenter.doAuth();
                }
                break;
            case R.id.register_button:
                startRegisterActivity();
                break;
        }
    }
}
