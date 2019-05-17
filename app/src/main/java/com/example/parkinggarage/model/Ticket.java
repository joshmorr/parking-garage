package com.example.parkinggarage.model;

import java.time.Instant;

public class Ticket extends Record {

    public Ticket() {
    }

    public Ticket(Vehicle vehicle, String attendantName, Instant timeParked, double rate) {
        super(vehicle, attendantName, timeParked, rate);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("License Plate Number: ");

        return stringBuilder.toString();
    }
}
