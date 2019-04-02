package com.example.parkinggarage.model;

import android.annotation.TargetApi;

import java.time.Duration;
import java.time.Instant;

public class Stay {
    private Attendant attendant;
    private Customer customer;
    private Instant timeParked;
    private Instant timeRetrieved;
    private Duration stayDuration;

    public Stay(Attendant attendant, Customer customer, Instant timeParked) {
        this.customer = customer;
        this.timeParked = timeParked;
    }

    @TargetApi(26)
    public void setStayDuration() {
        stayDuration = Duration.between(timeParked, timeRetrieved);
    }

    public Attendant getAttendant() {
        return attendant;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Instant getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(Instant timeParked) {
        this.timeParked = timeParked;
    }

    public Instant getTimeRetrieved() {
        return timeRetrieved;
    }

    public void setTimeRetrieved(Instant timeRetrieved) {
        this.timeRetrieved = timeRetrieved;
    }

    public Duration getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(Duration stayDuration) {
        this.stayDuration = stayDuration;
    }
}
