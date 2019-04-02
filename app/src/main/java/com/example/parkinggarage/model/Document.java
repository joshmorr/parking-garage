package com.example.parkinggarage.model;

import java.time.Instant;

public abstract class Document {
    private String plateNumber;
    private String category;
    private String attendantName;
    private String timeParked;
    private String date;
    private String schemeApplied;

    public Document(Stay stay) {
        plateNumber = stay.getCustomer().getVehicle().getPlateNumber();
        attendantName = stay.getAttendant().getFirstname();
        category = categoryToString();
        timeParked = timeParkedToString();

    }

    public String categoryToString() {
        return null;
    }

    private String timeParkedToString() {
        return null;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public String getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(String timeParked) {
        this.timeParked = timeParked;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchemeApplied() {
        return schemeApplied;
    }

    public void setSchemeApplied(String schemeApplied) {
        this.schemeApplied = schemeApplied;
    }

    @Override
    public abstract String toString();

}
