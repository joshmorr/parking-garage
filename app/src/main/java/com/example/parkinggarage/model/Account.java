package com.example.parkinggarage.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private boolean isManager;

    public Account() {
    }

    public Account(final Builder builder) {
        firstname = builder.firstname;
        lastname = builder.lastname;
        username = builder.username;
        password = builder.password;
        isManager = builder.isManager;
    }

    protected Account(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        username = in.readString();
        password = in.readString();
        isManager = in.readByte() != 0;
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeByte((byte) (isManager ? 1 : 0));
    }

    public boolean fieldAreFilled() {
        if (firstname == null || firstname.isEmpty()) {
            return false;
        }
        if (lastname == null || lastname.isEmpty()) {
            return false;
        }
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public boolean isManager() {
        return isManager;
    }

    public void setIsManager(boolean manager) {
        isManager = manager;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String username;
        private String password;
        private boolean isManager;

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setIsManager(boolean manager) {
            isManager = manager;
            return this;
        }

        public Account create() {
            return new Account(this);
        }
    }
}
