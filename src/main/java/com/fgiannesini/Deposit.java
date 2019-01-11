package com.fgiannesini;

public final class Deposit {

    private final double amount;

    public Deposit(double amount) {
        checkInput(amount);
        this.amount = amount;
    }

    private void checkInput(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("com.fgiannesini.Deposit amount could not be negative");
        }
    }

    double getAmount() {
        return amount;
    }
}
