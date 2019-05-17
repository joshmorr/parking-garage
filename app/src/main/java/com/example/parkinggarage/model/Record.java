package com.example.parkinggarage.model;

import java.time.Instant;

public abstract class Record {
    private Vehicle vehicle;
    private String attendantName;
    private Instant timeParked;
    private double rate;

    public Record() {
    }

    public Record(Vehicle vehicle, String attendantName, Instant timeParked, double rate) {
        this.vehicle = vehicle;
        this.attendantName = attendantName;
        this.timeParked = timeParked;
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

    public Instant getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(Instant timeParked) {
        this.timeParked = timeParked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
