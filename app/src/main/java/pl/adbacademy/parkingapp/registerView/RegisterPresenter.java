package pl.adbacademy.parkingapp.registerView;

import android.content.Context;

import pl.adbacademy.parkingapp.R;
import pl.adbacademy.parkingapp.model.User;
import pl.adbacademy.parkingapp.repository.Repository;

public class RegisterPresenter {

    private Repository repository;
    private Context context;
    private RegisterActivity registerActivityCallback;

    public RegisterPresenter(Repository repository, Context context) {
        this.repository = repository;
        this.context = context;
    }

    void setRegisterActivityCallback(RegisterActivity registerActivityCallback) {
        this.registerActivityCallback = registerActivityCallback;
    }

    String isEmpty(String stringToValidate) {
        if (stringToValidate.isEmpty() || stringToValidate.equals("")){
            registerActivityCallback.showError(context.getString(R.string.invalid_username_error));
            return null;
        } else {
            return stringToValidate;
        }
    }

    void sendRegisterData(User user) {
       repository.sendRegisterData(user);
    }
}
