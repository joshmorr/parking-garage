package com.example.parkinggarage.model;

public class Space {
    private int rowNum;
    private int spaceNum;
    private Category category;
    private Vehicle vehicle;

    public Space(int rowNum, int spaceNum) {
        this.rowNum = rowNum;
        this.spaceNum = spaceNum;
        category = null;
        vehicle = null;
    }

    public Space(Category category, int rowNum, int spaceNum) {
        this.rowNum = rowNum;
        this.spaceNum = spaceNum;
        this.category = category;
        vehicle = null;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public boolean isEmpty() {
        return vehicle == null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
