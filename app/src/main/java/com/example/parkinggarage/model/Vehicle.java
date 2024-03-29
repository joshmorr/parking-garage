package com.example.parkinggarage.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

public class Vehicle implements Parcelable {
    private Category category;
    private String plateNumber;
    private String attendantName;
    private String id;
    private Timestamp timeParked;
    private Timestamp timeRetrieved;
    private double rate;
    private int rowNum;
    private int spaceNum;

    public Vehicle() {
    }

    public Vehicle(Category category, String plateNumber, String attendantName, Timestamp timeParked, double rate) {
        this.category = category;
        this.plateNumber = plateNumber;
        this.attendantName = attendantName;
        this.timeParked = timeParked;
        timeRetrieved = null;
        this.rate = rate;
        rowNum = -1;
        spaceNum = -1;
    }


    protected Vehicle(Parcel in) {
        category = in.readParcelable(Category.class.getClassLoader());
        plateNumber = in.readString();
        attendantName = in.readString();
        id = in.readString();
        timeParked = in.readParcelable(Timestamp.class.getClassLoader());
        timeRetrieved = in.readParcelable(Timestamp.class.getClassLoader());
        rate = in.readDouble();
        rowNum = in.readInt();
        spaceNum = in.readInt();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    private double total() {
        Long seconds = Math.abs(timeRetrieved.getSeconds() - timeParked.getSeconds());
        return (seconds.doubleValue() / 3600) * rate;
    }

    private String getDateString(Timestamp timestamp) {
        return null;
    }

    private String getTimeString(Timestamp timestamp) {
        String str = timestamp.toDate().toString();
        String timeStr = str.substring(11,13);
        String am_pm;
        int hour = Integer.valueOf(timeStr);
        if (hour > 12) {
            hour -= 12;
            am_pm = "PM";
        } else {
            am_pm = "AM";
        }
        return hour + str.substring(13,16) + " " + am_pm;
    }

    public String receiptData() {
        StringBuilder builder = new StringBuilder();
        builder.append(plateNumber)
                .append("\n\n")
                .append(getCategoryString())
                .append("\n\n")
                .append(attendantName)
                .append("\n\n")
                .append("2/3/2019")
                .append("\n\n")
                .append(getTimeString(timeParked))
                .append("\n\n");
        if (timeRetrieved != null) {
            builder.append(getTimeString(timeRetrieved));
        }
        builder.append(String.format("\n\n$%.2f / hour", rate))
                .append(String.format("\n\n$%.2f", total()));
        return builder.toString();
    }

    public String ticketData() {
        StringBuilder builder = new StringBuilder();
        builder.append(plateNumber)
                .append("\n\n")
                .append(getCategoryString())
                .append("\n\n")
                .append(attendantName)
                .append("\n\n")
                .append("2/3/2019")
                .append("\n\n")
                .append(getTimeString(timeParked))
                .append("\n\n")
                .append(String.format("$%.2f / hour", rate));
        return builder.toString();
    }

    public String getCategoryString() {
        if (category.equals(Category.MOTORCYCLE)) return "Motorcycle";
        if (category.equals(Category.CAR)) return "Car";
        if (category.equals(Category.TRUCK)) return "Truck";
        return null;
    }

    @Override
    public String toString() {
        int space = 25;
        StringBuilder builder = new StringBuilder();
        builder.append(getCategoryString());
        for (int i = 0; i < space - getCategoryString().length(); i++)
            builder.append(" ");
        String timeStr = getTimeString(timeParked);
        builder.append(timeStr);
        for (int i = 0; i < space - timeStr.length(); i++)
            builder.append(" ");
        builder.append("Row: " + rowNum + ", Space: " + spaceNum);
        return builder.toString();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTimeParked() {
        return timeParked;
    }

    public void setTimeParked(Timestamp timeParked) {
        this.timeParked = timeParked;
    }

    public Timestamp getTimeRetrieved() {
        return timeRetrieved;
    }

    public void setTimeRetrieved(Timestamp timeRetrieved) {
        this.timeRetrieved = timeRetrieved;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(category, flags);
        dest.writeString(plateNumber);
        dest.writeString(attendantName);
        dest.writeString(id);
        dest.writeParcelable(timeParked, flags);
        dest.writeParcelable(timeRetrieved, flags);
        dest.writeDouble(rate);
        dest.writeInt(rowNum);
        dest.writeInt(spaceNum);
    }
}
