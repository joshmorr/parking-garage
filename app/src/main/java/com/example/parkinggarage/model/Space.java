package com.example.parkinggarage.model;

public class Space {
    private Type type;

    public Space() {
        type = null;
    }

    public Space(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
