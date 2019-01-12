package com.fgiannesini.transactions;

import java.time.LocalDate;

public final class Withdrawal{

    private final double amount;
    private final LocalDate date;

    public Withdrawal(double amount, LocalDate withdrawalDate) {
        this.date = withdrawalDate;
        this.amount = amount;
        checkInput();
    }

    private void checkInput() {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount could not be negative");
        }
        if (date == null) {
            throw new IllegalArgumentException("Withdrawal date must be set");
        }
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
