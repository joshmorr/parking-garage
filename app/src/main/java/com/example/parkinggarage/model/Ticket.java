package com.example.parkinggarage.model;

import com.google.firebase.Timestamp;

public class Ticket extends Record {

    public Ticket() {
    }

    public Ticket(Vehicle vehicle, String attendantName, Timestamp timeParked, double rate) {
        super(vehicle, attendantName, timeParked, rate);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("License Plate Number:\t")
                .append(getVehicle().getPlateNumber())
                .append("\nVehicle Category:\t")
                .append(getVehicle().getCategoryString())
                .append("\nAttendant Name:\t\t")
                .append(getAttendantName())
                .append("\nDate:\t\t");


        return builder.toString();
    }

}
