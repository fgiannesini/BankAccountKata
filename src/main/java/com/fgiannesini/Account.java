package com.fgiannesini;

import com.fgiannesini.transactions.Deposit;

import java.time.LocalDate;

public final class Account {

    private double balance;

    public Account() {
    }

    Account(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void apply(Deposit deposit, LocalDate date) {
        balance += deposit.getAmount();
    }

}
