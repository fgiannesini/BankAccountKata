package com.fgiannesini;

import java.time.LocalDate;

public class Account {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void apply(Deposit deposit, LocalDate date) {
        balance += deposit.getAmount();
    }

}
