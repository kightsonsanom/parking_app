package com.example.asinit_user.parkingapp.mainView.usersView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class UserDetailsFragment extends Fragment {


    @Inject
    UserDetailsPresenter userDetailsPresenter;
    @BindView(R.id.username_label)
    TextView usernameLabel;
    @BindView(R.id.username_text)
    TextView usernameText;
    @BindView(R.id.password_label)
    TextView passwordLabel;
    @BindView(R.id.password_text)
    TextView passwordText;
    @BindView(R.id.firstname_label)
    TextView firstnameLabel;
    @BindView(R.id.firstname_text)
    TextView firstnameText;
    @BindView(R.id.lastname_label)
    TextView lastnameLabel;
    @BindView(R.id.lastname_text)
    TextView lastnameText;
    @BindView(R.id.email_label)
    TextView emailLabel;
    @BindView(R.id.email_text)
    TextView emailText;
    @BindView(R.id.platenr_label)
    TextView platenrLabel;
    @BindView(R.id.platenr_text)
    TextView platenrText;
    @BindView(R.id.accept_user)
    Button acceptUser;
    @BindView(R.id.deny_user)
    Button denyUser;
    Unbinder unbinder;
    private User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreateView(inflater, container, savedInstanceState);
        user = getArguments().getParcelable("user");
        Timber.d("onCreateView from UserDetailsFragment");

        View view = inflater.inflate(R.layout.user_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeFields();
    }

    private void initializeFields() {


        Timber.d("initializeFields method");

        if (user != null) {
            usernameText.setText(user.getUsername());
            passwordText.setText(user.getPassword());
            firstnameText.setText(user.getFirstname());
            lastnameText.setText(user.getSurname());
            platenrText.setText(user.getPlatenr());
            emailText.setText(user.getEmail());

        } else {
            Timber.d("user jest nullem w UserDetailsFragment");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.accept_user, R.id.deny_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.accept_user:
                userDetailsPresenter.updateUser(user);
                break;
            case R.id.deny_user:
                userDetailsPresenter.deleteUser(user);
                break;
        }
    }


}
