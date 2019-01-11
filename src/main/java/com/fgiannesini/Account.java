package com.fgiannesini;

import com.fgiannesini.transactions.Deposit;
import com.fgiannesini.transactions.Withdrawal;

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

    public void apply(Deposit deposit) {
        balance += deposit.getAmount();
    }

    public void apply(Withdrawal withdrawal) {
        balance -= withdrawal.getAmount();
    }
}
