package com.example.parkinggarage.presenter;

import com.example.parkinggarage.model.Manager;

public class ManagerSetupActivityPresenter {
    private View view;

    public ManagerSetupActivityPresenter(View view) {
        this.view = view;
    }

    public void addManager(String firstname, String lastname, String username, String password) {
        Manager manager = new Manager(firstname, lastname, username, password);
    }

    public interface View {
        void showFailedAddManagerDialog();
    }

}
