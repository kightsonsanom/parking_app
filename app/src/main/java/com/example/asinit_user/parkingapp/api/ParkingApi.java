package com.example.asinit_user.parkingapp.api;


import com.example.asinit_user.parkingapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ParkingApi {

    @POST("users")
    Call<User> sendUser(@Body User user);

    @GET("parking/slots")
    Call<Integer> getParkingSlots();

    @GET
    Call<List<User>> getUsers();
}
