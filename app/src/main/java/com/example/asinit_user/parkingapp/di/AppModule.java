package com.example.asinit_user.parkingapp.di;

import android.app.Application;

import com.example.asinit_user.parkingapp.ServerMock;
import com.example.asinit_user.parkingapp.api.ParkingApi;
import com.example.asinit_user.parkingapp.repository.Repository;
import com.example.asinit_user.parkingapp.repository.SharedPreferencesRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class AppModule {

    @Provides
    @Singleton
    ServerMock provideServerMock(){
        return new ServerMock();
    }

    @Provides
    @Singleton
    Repository provideRepository(ServerMock serverMock, ParkingApi parkingApi, Application application, SharedPreferencesRepo sharedPreferencesRepo){
        return new Repository(serverMock, parkingApi, application.getApplicationContext(), sharedPreferencesRepo);
    }


    @Provides
    @Singleton
    SharedPreferencesRepo provideSharedPreferences(Application application){
        return new SharedPreferencesRepo(application.getApplicationContext());
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @Singleton
    ParkingApi provideParkingApi(Gson gson) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.26:8080/parking/webapi/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(ParkingApi.class);
    }
}
