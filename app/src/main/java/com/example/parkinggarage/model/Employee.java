package com.example.parkinggarage.model;

public class Employee {
    private boolean isManager;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public Employee(Builder builder) {
        this.isManager = builder.isManager;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.username = builder.username;
        this.password = builder.password;
    }

    public boolean fieldsAreFilled() {
        if (firstname == null || firstname.isEmpty()) return false;
        if (lastname == null || lastname.isEmpty()) return false;
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        return true;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private boolean isManager;
        private String firstname;
        private String lastname;
        private String username;
        private String password;

        public Builder setIsManager(boolean manager) {
            isManager = manager;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Employee create() {
            return new Employee(this);
        }
    }


}