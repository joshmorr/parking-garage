package com.example.parkinggarage.model;

public class VehicleStay {
    private Vehicle vehicle;
    private String attendantName;
    private double rate;
    private double timeParked;
    private double timeRetrieved;
    private double totalTimeParked;

    public VehicleStay() {

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(double timeParked) {
        this.timeParked = timeParked;
    }

    public double getTimeRetrieved() {
        return timeRetrieved;
    }

    public void setTimeRetrieved(double timeRetrieved) {
        this.timeRetrieved = timeRetrieved;
    }

    public double getTotalTimeParked() {
        return totalTimeParked;
    }

    public void setTotalTimeParked(double totalTimeParked) {
        this.totalTimeParked = totalTimeParked;
    }
}
