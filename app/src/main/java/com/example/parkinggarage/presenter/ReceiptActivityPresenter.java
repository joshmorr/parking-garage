package com.example.parkinggarage.presenter;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReceiptActivityPresenter {
    private Vehicle vehicle;
    private View view;

    public ReceiptActivityPresenter(View view) {
        this.view = view;
    }

    public interface View {

    }
}
