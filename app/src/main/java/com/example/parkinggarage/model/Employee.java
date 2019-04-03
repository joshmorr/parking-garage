package com.example.parkinggarage.model;

public abstract class Employee extends Person {
    private String username;
    private String password;

    public Employee(String firstname, String lastname, String username, String password) {
        super(firstname, lastname);
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