package com.example.parkinggarage.model;

public class Account {
    private String name;
    private String username;
    private String password;
    private boolean isManager;

    public Account(boolean isManager) {
        this.isManager = isManager;
    }

    public Account(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        isManager = false;
    }

    public Account(String name, String username, String password, boolean isManager) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
