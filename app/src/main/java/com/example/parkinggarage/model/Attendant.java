package com.example.parkinggarage.model;

import java.io.Serializable;

public class Attendant extends Employee implements Serializable {
    public Attendant() {
    }

    public Attendant(InputStrings input) {
        super(input);
    }

    public Attendant(String firstname, String lastname, String password, String username) {
        super(firstname, lastname, username, password);
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname();
    }
}
