package com.example.parkinggarage.model;

import android.annotation.TargetApi;

import java.time.Instant;

public class Attendant {

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
