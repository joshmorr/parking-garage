package com.example.parkinggarage.presenter;

import android.content.Context;

import com.example.parkinggarage.database.EmployeeAdder;
import com.example.parkinggarage.database.GarageAdder;
import com.example.parkinggarage.database.UsernameChecker;
import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.model.ManagerSetupInput;
import com.example.parkinggarage.model.PaymentScheme;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

public class ManagerSetupActivityPresenter extends Presenter {
    private View view;

    public ManagerSetupActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void next(FirebaseFirestore database, ManagerSetupInput input)  {

    }

    public interface View {
        void showFailedAddManagerDialog();
    }

}
