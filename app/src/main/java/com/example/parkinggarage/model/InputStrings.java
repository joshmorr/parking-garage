package com.example.parkinggarage.model;

import java.io.Serializable;

public class InputStrings implements Serializable {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public InputStrings() {
    }

    public InputStrings(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public InputStrings(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public boolean fieldsAreFilled() {
        if (firstname == null || firstname.isEmpty()) return false;
        if (lastname == null || lastname.isEmpty()) return false;
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
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
}
