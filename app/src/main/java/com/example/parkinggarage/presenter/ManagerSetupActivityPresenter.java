package com.example.parkinggarage.presenter;

import android.content.Context;

import com.example.parkinggarage.model.Manager;

public class ManagerSetupActivityPresenter extends Presenter {
    private View view;

    public ManagerSetupActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void addManager(String firstname, String lastname, String username, String password) {
        Manager manager = new Manager(firstname, lastname, username, password);
    }

    public interface View {
        void showFailedAddManagerDialog();
    }

}
