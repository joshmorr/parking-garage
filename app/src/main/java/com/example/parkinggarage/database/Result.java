package com.example.parkinggarage.database;

public class Result {
    private boolean condition;

    public Result() {
    }

    public Result(boolean condition) {
        this.condition = condition;
    }

    public boolean condition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}
