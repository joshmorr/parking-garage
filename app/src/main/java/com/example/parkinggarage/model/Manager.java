package com.example.parkinggarage.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Manager extends Employee implements Serializable {
    private String garageId;
    private ArrayList<String> attendantsList;

    public Manager() {
    }

    public Manager(String firstname, String lastname, String username, String password, String garageId) {
        super(firstname, lastname, username, password);
        this.garageId = garageId;
    }

    public Manager(String garageId, InputStrings input) {
        super(input);
        this.garageId = garageId;
        attendantsList = new ArrayList<>();
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }

    public ArrayList<String> getAttendantsList() {
        return attendantsList;
    }

    public void setAttendantsList(ArrayList<String> attendantsList) {
        this.attendantsList = attendantsList;
    }
}
