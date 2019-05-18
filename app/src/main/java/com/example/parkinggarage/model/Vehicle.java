package com.example.parkinggarage.model;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.firebase.Timestamp;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Vehicle {
    private Category category;
    private String plateNumber;
    private String attendantName;
    private Timestamp timeParked;
    private Timestamp timeRetrieved;
    private double rate;

    public Vehicle() {
    }

    public Vehicle(Category category, String plateNumber, String attendantName, Timestamp timeParked, double rate) {
        this.category = category;
        this.plateNumber = plateNumber;
        this.attendantName = attendantName;
        this.timeParked = timeParked;
        this.rate = rate;
    }

    private void setPaymentSchemeRate() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String getDateString(Timestamp timestamp) {
        String str = timestamp.toDate().toString();
        return str;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String getTimeString(Timestamp timestamp) {
        String str = timestamp.toDate().toString();
        return str;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTicketData() {
        StringBuilder builder = new StringBuilder();
        builder.append(plateNumber)
                .append("\n\n")
                .append(getCategoryString())
                .append("\n\n")
                .append(attendantName)
                .append("\n\n")
                .append(getDateString(timeParked))
                .append("\n\n")
                .append(getTimeString(timeParked))
                .append("\n\n")
                .append(String.format("$%.2f / hour", rate));
        return builder.toString();
    }

    public String getCategoryString() {
        if (category.equals(Category.MOTORCYCLE)) return "Motorcycle";
        if (category.equals(Category.CAR)) return "Car";
        if (category.equals(Category.TRUCK)) return "Truck";
        return null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public Timestamp getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(Timestamp timeParked) {
        this.timeParked = timeParked;
    }

    public Timestamp getTimeRetrieved() {
        return timeRetrieved;
    }

    public void setTimeRetrieved(Timestamp timeRetrieved) {
        this.timeRetrieved = timeRetrieved;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
