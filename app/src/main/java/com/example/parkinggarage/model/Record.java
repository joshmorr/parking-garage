package com.example.parkinggarage.model;

import com.google.firebase.Timestamp;

public abstract class Record {
    private Vehicle vehicle;
    private String attendantName;
    private Timestamp timestamp;
    private double rate;

    public Record() {
    }

    public Record(Vehicle vehicle, String attendantName, Timestamp timeParked, double rate) {
        this.vehicle = vehicle;
        this.attendantName = attendantName;
        this.timestamp = timeParked;
        this.rate = rate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public Timestamp getTimeParked() {
        return timestamp;
    }

    public void setTimeParked(Timestamp timeParked) {
        this.timestamp = timeParked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public abstract String toString();

}
