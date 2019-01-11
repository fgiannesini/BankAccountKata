package com.fgiannesini;

import com.fgiannesini.transactions.Deposit;
import com.fgiannesini.transactions.Withdrawal;

public final class Account {

    private double balance;

    public Account() {
    }

    Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Account amount can't be negative");
        }
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void apply(Deposit deposit) {
        balance += deposit.getAmount();
    }

    public void apply(Withdrawal withdrawal) {
        balance = Math.max(0, balance - withdrawal.getAmount());
    }
}
