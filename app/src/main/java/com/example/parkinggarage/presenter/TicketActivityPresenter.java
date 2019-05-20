package com.example.parkinggarage.presenter;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;

public class TicketActivityPresenter {
    private Vehicle vehicle;
    private Attendant attendant;
    private View view;

    public TicketActivityPresenter(Vehicle vehicle, Attendant attendant, View view) {
        this.vehicle = vehicle;
        this.attendant = attendant;
        this.view = view;
    }

    public void finish() {
        view.startAttendantActivity(attendant);
    }

    public void setData() {
        view.setData(vehicle.getTicketData());
    }

    public void setLabels() {
        StringBuilder builder = new StringBuilder();
        builder.append("License Plate Number:")
                .append("\n\nVehicle Category:")
                .append("\n\nAttendant Name:")
                .append("\n\nDate:")
                .append("\n\nTimeParked:")
                .append("\n\nRate")
                .append("\n\n");
        view.setLabels(builder.toString());
    }

    public interface View {
        void setLabels(String labels);
        void setData(String data);
        void startAttendantActivity(Attendant attendant);
    }
}
