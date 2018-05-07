package com.example.asinit_user.parkingapp.repository;

import android.content.Context;
import android.widget.Toast;

import com.example.asinit_user.parkingapp.ServerMock;
import com.example.asinit_user.parkingapp.api.ParkingApi;
import com.example.asinit_user.parkingapp.model.User;

import net.openid.appauth.AuthState;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class Repository {

    private Context context;
    private SharedPreferencesRepo sharedPreferencesRepo;
    private ParkingApi parkingApi;
    private ServerMock serverMock;

    public Repository(ServerMock serverMock, ParkingApi parkingApi, Context applicationContext, SharedPreferencesRepo sharedPreferencesRepo) {
        this.context = applicationContext;
        this.sharedPreferencesRepo = sharedPreferencesRepo;
        this.parkingApi = parkingApi;
        this.serverMock = serverMock;
    }

    public String getAuthState() {
        return sharedPreferencesRepo.getAuthState();
    }


    public void persistAuthState(AuthState authState) {
        sharedPreferencesRepo.persistAuthState(authState);
    }

    public void sendRegisterData(User user) {
//        Call call = parkingApi.sendUser(user);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                Toast.makeText(context, "Wysłano użytkownika", Toast.LENGTH_SHORT).show();
//                Timber.d("wyslano uzytkownika");
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(context, "Błąd wysyłania", Toast.LENGTH_SHORT).show();
//                Timber.d("nie wyslano uzytkownika");
//            }
//        });
        serverMock.addUser(user);
    }

    public int getParkingSlots() {

//        Call call = parkingApi.getParkingSlots();
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//               parkingSlotsCallback.setParkingSlots();
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                parkingSlotsCallback.setConnectionError();
//            }
//        });

        return serverMock.getParkingSlots();
    }

    public List<User> getUnregisteredUsers() {

//        Call call = parkingApi.getUsers();
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                userListCallback.setParkingSlots();
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                userListCallback.setConnectionError();
//            }
//        });

        return serverMock.getUserList();
    }

    public void updateUser(User user) {


    }

    public void deleteUser(User user) {


    }
}
