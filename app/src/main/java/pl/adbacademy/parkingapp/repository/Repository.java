package pl.adbacademy.parkingapp.repository;

import android.content.Context;

import pl.adbacademy.parkingapp.ServerMock;
import pl.adbacademy.parkingapp.api.ParkingApi;
import pl.adbacademy.parkingapp.model.User;

import net.openid.appauth.AuthState;

import java.util.List;

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
        serverMock.addUser(user);
    }

    public int getParkingSlots() {
        return serverMock.getParkingSlots();
    }

    public List<User> getUserList() {
        return serverMock.getUserList();
    }

    public void updateUser(User user) {
        serverMock.updateUserStatus(user.getId(), true);
    }

    public void deleteUser(User user) {
        serverMock.deleteUser(user.getId());
    }

    public void clear() {
        sharedPreferencesRepo.clear();
    }
}
