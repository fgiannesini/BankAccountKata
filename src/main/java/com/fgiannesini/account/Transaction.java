package com.fgiannesini.account;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate applicationDate;

    private final double amount;

    private final TransactionType transactionType;

    public Transaction(double amount, LocalDate applicationDate, TransactionType transactionType) {
        this.amount = amount;
        this.applicationDate = applicationDate;
        this.transactionType = transactionType;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
