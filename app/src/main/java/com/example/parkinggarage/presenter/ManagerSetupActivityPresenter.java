package com.example.parkinggarage.presenter;

import android.content.Context;

import com.example.parkinggarage.database.EmployeeAdder;
import com.example.parkinggarage.model.Employee;

public class ManagerSetupActivityPresenter extends Presenter {
    private View view;

    public ManagerSetupActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void addManager(String firstname, String lastname, String username, String password) {
        Employee manager = new Employee.Builder()
                                .setIsManager(true)
                                .setFirstname(firstname)
                                .setLastname(lastname)
                                .setUsername(username)
                                .setPassword(password)
                                .create();
        if (manager.fieldsAreFilled())
            new EmployeeAdder(manager).add();
        else
            view.showFailedAddManagerDialog();
    }

    public interface View {
        void showFailedAddManagerDialog();
    }

}
