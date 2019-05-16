package com.example.parkinggarage.presenter;

import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerActivityPresenter {
    private FirebaseFirestore database;
    private View view;

    public ManagerActivityPresenter(FirebaseFirestore database, View view) {
       this.database = database;
       this.view = view;
    }

    public void goToAttendantsList(String username) {
        view.startAttendantsListActivity(username);
    }

    public interface View {
        void startAttendantsListActivity(String username);
    }

}
