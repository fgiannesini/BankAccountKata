package com.fgiannesini.transactions;

public final class Deposit{

    private final double amount;

    public Deposit(double amount) {
        checkInput(amount);
        this.amount = amount;
    }

    private void checkInput(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
    }

    public double getAmount() {
        return amount;
    }
}
