package com.example.parkinggarage.model;

public abstract class Employee extends Person {
    private String username;
    private String password;

    public Employee(String firstname, String lastname, String username, String password) {
        super(firstname, lastname);
    }

}