package com.example.asinit_user.parkingapp.mainView.usersView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.mainView.MainActivity;
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
    TextView acceptUser;
    @BindView(R.id.deny_user)
    TextView denyUser;
    Unbinder unbinder;
    @BindView(R.id.isAdminTextView)
    TextView isAdminTextView;
    @BindView(R.id.isAdminCheckbox)
    CheckBox isAdminCheckbox;


    private User user;

    public static UserDetailsFragment newInstance(User user) {
        Bundle args = new Bundle();
        args.putParcelable("user", user);
        UserDetailsFragment fragment = new UserDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreateView(inflater, container, savedInstanceState);
        user = getArguments().getParcelable("user");

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

        if (user.isRegistered()) {
            hideButtonsAndShowAdminInfo();
        }
    }

    private void hideButtonsAndShowAdminInfo() {
        acceptUser.setVisibility(View.GONE);
        denyUser.setVisibility(View.GONE);
        isAdminCheckbox.setVisibility(View.GONE);
        isAdminTextView.setText("Zwykły użytkownik");

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
                Toast.makeText(getActivity(), "Zaktualizowano użytkownika", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
                break;
            case R.id.deny_user:
                userDetailsPresenter.deleteUser(user);
                Toast.makeText(getActivity(), "Usunięto użytkownika", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public String toString() {
        return "UserDetailsFragment";
    }
}
