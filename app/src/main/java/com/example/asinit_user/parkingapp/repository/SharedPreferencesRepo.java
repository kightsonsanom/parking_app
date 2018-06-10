package com.example.asinit_user.parkingapp.repository;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.asinit_user.parkingapp.R;

import net.openid.appauth.AuthState;


public class SharedPreferencesRepo {

    private static final String AUTH_STATE = "AUTH_STATE";


    private final SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesRepo (Context context){
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getAuthState(){
        return sharedPreferences.getString(AUTH_STATE, null);
    }

    public void persistAuthState(AuthState authState) {
        editor.putString(AUTH_STATE, authState.toJsonString()).commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
