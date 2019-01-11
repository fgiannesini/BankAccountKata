package com.fgiannesini.transactions;

public final class Withdrawal {

    private final double amount;

    public Withdrawal(double amount) {
        checkInput(amount);
        this.amount = amount;
    }

    private void checkInput(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount could not be negative");
        }
    }

    public double getAmount() {
        return amount;
    }
}
