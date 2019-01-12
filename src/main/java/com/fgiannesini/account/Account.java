package com.fgiannesini.account;

import com.fgiannesini.transactions.Deposit;
import com.fgiannesini.transactions.Withdrawal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final class Account {

    private double balance;

    private final List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }

    public Account(double initialBalance, LocalDate initialDate) {
        this();
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Account amount can't be negative");
        }
        transactions.add(new Transaction(initialBalance, initialDate, TransactionType.DEPOSIT));
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void apply(Deposit deposit) {
        balance += deposit.getAmount();
        transactions.add(new Transaction(deposit.getAmount(), deposit.getDate(), TransactionType.DEPOSIT));
    }

    public void apply(Withdrawal withdrawal) {
        double effectiveAmount = Math.min(balance, withdrawal.getAmount());
        balance -= effectiveAmount;
        transactions.add(new Transaction(-effectiveAmount, withdrawal.getDate(), TransactionType.WITHDRAWAL));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
