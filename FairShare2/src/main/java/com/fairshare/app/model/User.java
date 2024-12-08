package com.fairshare.app.model;

public class User {
    private String name;
    private double amountOwed;

    public User(String name) {
        this.name = name;
        this.amountOwed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
