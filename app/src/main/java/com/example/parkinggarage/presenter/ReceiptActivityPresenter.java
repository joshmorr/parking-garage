package com.example.parkinggarage.presenter;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReceiptActivityPresenter {
    private Vehicle vehicle;
    private View view;

    public ReceiptActivityPresenter(Vehicle vehicle, View view) {
        this.vehicle = vehicle;
        this.view = view;
    }

    public void setLabels() {
        StringBuilder builder = new StringBuilder();
        builder.append("License Plate Number:")
                .append("\n\nVehicle Category:")
                .append("\n\nAttendant Name:")
                .append("\n\nDate:")
                .append("\n\nTime Parked:")
                .append("\n\nTime Retrieved:")
                .append("\n\nRate:")
                .append("\n\nTotal:");
        view.setLabels(builder.toString());
    }

    public void setData() {
        view.setData(vehicle.getReceiptData());
    }

    public void print() {
        view.showSnackbar();
    }

    public void finish() {
        view.startAttendantActivity();
    }

    public interface View {
        void setLabels(String labels);
        void setData(String data);
        void showSnackbar();
        void startAttendantActivity();
    }
}
