package pl.adbacademy.parkingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class User implements Parcelable {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String platenr;
    private boolean isRegistered;

    public User() {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public User(String username, String password, String firstname, String surname, String email, String platenr) {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.platenr = platenr;
        this.isRegistered = false;
    }

    public User(String username, String password, String firstname, String surname, String email, String platenr, boolean isRegistered) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.platenr = platenr;
        this.isRegistered = isRegistered;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlatenr() {
        return platenr;
    }

    public void setPlatenr(String platenr) {
        this.platenr = platenr;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.firstname);
        dest.writeString(this.surname);
        dest.writeString(this.email);
        dest.writeString(this.platenr);
        dest.writeByte(this.isRegistered ? (byte) 1 : (byte) 0);
    }

    protected User(Parcel in) {
        this.id = in.readLong();
        this.username = in.readString();
        this.password = in.readString();
        this.firstname = in.readString();
        this.surname = in.readString();
        this.email = in.readString();
        this.platenr = in.readString();
        this.isRegistered = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", platenr='" + platenr + '\'' +
                ", isRegistered=" + isRegistered +
                '}';
    }
}
