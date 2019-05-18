package com.example.parkinggarage.model;

public class Space {
    private int rowNum;
    private int spaceNum;
    private Category category;
    private Vehicle vehicle;

    public Space() {
    }

    public Space(String categoryStr, int rowNum, int spaceNum) {
        this.rowNum = rowNum;
        this.spaceNum = spaceNum;
        vehicle = null;

        if (categoryStr.equals("M"))
            category = Category.MOTORCYCLE;
        else if (categoryStr.equals("C"))
            category = Category.CAR;
        else if (categoryStr.equals("T"))
            category = Category.TRUCK;
        else
            category = null;
    }

    public boolean isEmpty() {
        return vehicle == null;
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
