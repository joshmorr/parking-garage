package com.example.parkinggarage.model;

public class Account {
    private String firstname;
    private String lastname;
    private String username;
    private int passwordHash;
    private boolean isManager;

    public Account() {
    }

    public Account(String firstname, String lastname, String username, String password, boolean isManager) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        passwordHash = password.hashCode();
        this.isManager = isManager;
    }

    public boolean checkPasswordInput(String input) {
        if (input.hashCode() == passwordHash) {
            return true;
        }
        return false;
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

    public void setPassword(String password) {
        this.passwordHash = password.hashCode();
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
