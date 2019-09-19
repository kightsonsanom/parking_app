package pl.adbacademy.parkingapp.repository;


import android.content.Context;
import android.content.SharedPreferences;

import pl.adbacademy.parkingapp.R;

import net.openid.appauth.AuthState;


public class SharedPreferencesRepo {

    private static final String AUTH_STATE = "AUTH_STATE";

    private final SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesRepo(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    String getAuthState() {
        return sharedPreferences.getString(AUTH_STATE, null);
    }

    void persistAuthState(AuthState authState) {
        editor.putString(AUTH_STATE, authState.toJsonString()).commit();
    }

    void clear() {
        editor.clear();
        editor.commit();
    }
}
