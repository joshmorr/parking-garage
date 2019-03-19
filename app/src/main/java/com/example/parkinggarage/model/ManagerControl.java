package com.example.parkinggarage.model;

import com.example.parkinggarage.model.*;

public class ManagerControl {
    private ParkingGarageSystem system;

    public ManagerControl() {
        system = new ParkingGarageSystem();
    }

    public void addAttendantAccount(String name, String username, String password) {
        system.getAccounts().put(username, new Account(name, username, password));
    }


}
