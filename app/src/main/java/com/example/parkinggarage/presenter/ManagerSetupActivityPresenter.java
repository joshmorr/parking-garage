package com.example.parkinggarage.presenter;

import android.content.Context;

import com.example.parkinggarage.database.EmployeeAdder;
import com.example.parkinggarage.database.GarageAdder;
import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.model.PaymentScheme;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerSetupActivityPresenter extends Presenter {
    private View view;

    public ManagerSetupActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void next(FirebaseFirestore database, String firstname, String lastname, String username, String password) {
        Manager manager = new Manager(firstname, lastname, username, password);
        if (manager.fieldsAreFilled()) {
            new EmployeeAdder(database, manager).add();
            new GarageAdder(database, new Garage(new PaymentScheme())).add();
        }
        else {
            view.showFailedAddManagerDialog();
        }
    }

    public interface View {
        void showFailedAddManagerDialog();
    }

}
