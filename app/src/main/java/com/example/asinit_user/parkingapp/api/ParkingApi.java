package com.example.asinit_user.parkingapp.api;


import com.example.asinit_user.parkingapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ParkingApi {

    @POST("users")
    Call<User> sendUser(@Body User user);

    @GET("parking/slots")
    Call<Integer> getParkingSlots();

    @GET("users")
    Call<List<User>> getUsers();

    @DELETE("users/userID")
    Call<User> deleteUser(@Query("userID") long userID);

    @PUT("users/userID")
    Call<User> updateUser(@Query("userID") long userID);
}
