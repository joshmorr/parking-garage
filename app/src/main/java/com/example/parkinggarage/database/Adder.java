package com.example.parkinggarage.database;

import com.google.firebase.firestore.FirebaseFirestore;

public abstract class Adder {
    private FirebaseFirestore database;
    private String collectionPath;
    private static String tag;

    public Adder() {
        database = FirebaseFirestore.getInstance();
    }

    public FirebaseFirestore getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseFirestore database) {
        this.database = database;
    }

    public String getCollectionPath() {
        return collectionPath;
    }

    public void setCollectionPath(String collectionPath) {
        this.collectionPath = collectionPath;
    }

    public static String getTag() {
        return tag;
    }

    public static void setTag(String tag) {
        Adder.tag = tag;
    }
}
