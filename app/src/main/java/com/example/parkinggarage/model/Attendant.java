package com.example.parkinggarage.model;

import android.annotation.TargetApi;

import java.io.Serializable;
import java.time.Instant;

public class Attendant extends Employee implements Serializable {
    public Attendant() {
    }

    public Attendant(InputStrings input) {
        super(input);
    }

    public Attendant(String firstname, String lastname, String password, String username) {
        super(firstname, lastname, username, password);
    }

    @TargetApi(26)
    public void park(Customer customer) {
        Stay stay = new Stay(this, customer, Instant.now());

    }

    @TargetApi(26)
    public void retrieve(Stay stay) {
        stay.setTimeRetrieved(Instant.now());
        stay.setStayDuration();
    }

}
