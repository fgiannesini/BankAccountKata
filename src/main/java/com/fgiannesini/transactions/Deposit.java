package com.fgiannesini.transactions;

import java.time.LocalDate;

public final class Deposit{

    private final double amount;
    private final LocalDate date;

    public Deposit(double amount, LocalDate depositDate) {
        this.date = depositDate;
        this.amount = amount;
        checkInput();
    }

    private void checkInput() {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        if (date == null) {
            throw new IllegalArgumentException("Deposit date must be set");
        }
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
