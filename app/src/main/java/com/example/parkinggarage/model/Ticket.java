package com.example.parkinggarage.model;

public class Ticket extends Document {

    public Ticket(Stay stay) {
        super(stay);
    }

    @Override
    public String toString() {
        String str = "Ticket:";
        str += "License Plate Number:\t" + getPlateNumber();
        str += "Category:\t" + categoryToString();
        return str;
    }
}
