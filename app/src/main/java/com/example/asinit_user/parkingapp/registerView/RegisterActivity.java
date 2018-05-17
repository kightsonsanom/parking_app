package com.example.asinit_user.parkingapp.registerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class RegisterActivity extends AppCompatActivity implements RegisterActivityCallback {

    @BindView(R.id.username_edit_text)
    TextInputEditText usernameEditText;

    @BindView(R.id.email_edit_text)
    TextInputEditText emailEditText;
    @BindView(R.id.platenr_edit_text)
    TextInputEditText platenrEditText;
    @BindView(R.id.admin_checkbox)
    CheckBox adminCheckbox;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.firstname_edit_text)
    TextInputEditText firstnameEditText;
    @BindView(R.id.surname_edit_text)
    TextInputEditText surnameEditText;
    @BindView(R.id.password_edit_text)
    TextInputEditText passwordEditText;
    @BindView(R.id.email_input_layout)
    TextInputLayout emailInputLayout;
    @BindView(R.id.platenr_input_layout)
    TextInputLayout platenrInputLayout;

    @Inject
    public RegisterPresenter registerPresenter;

    private boolean isInputValid = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        registerPresenter.setRegisterActivityCallback(this);

        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.register_button)
    public void onViewClicked() {

        String username = registerPresenter.isEmpty(usernameEditText.getText().toString());
        String password = registerPresenter.isEmpty(passwordEditText.getText().toString());
        String firstname = registerPresenter.isEmpty(firstnameEditText.getText().toString());
        String surname = registerPresenter.isEmpty(surnameEditText.getText().toString());
        String email = registerPresenter.isEmpty(emailEditText.getText().toString());
        String platenr = registerPresenter.isEmpty(platenrEditText.getText().toString());

        if (isInputValid) {
            User user = new User(username, password, firstname,surname,email,platenr);
            registerPresenter.sendRegisterData(user);
        }
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        isInputValid = false;
    }
}
