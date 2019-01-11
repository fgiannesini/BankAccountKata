package com.fgiannesini;

import com.fgiannesini.transactions.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AccountTest {

    @Test
    @DisplayName("create empty account")
    void create_empty_account() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("create not empty account")
    void create_not_empty_account() {
        double initialBalance = -3.4;
        Account account = new Account(initialBalance);
        Assertions.assertEquals(initialBalance, account.getBalance());
    }

    @Nested
    class DepositImpact {

        @Test
        @DisplayName("Apply a deposit on initial account should impact balance")
        void apply_a_deposit_on_initial_account_should_impact_balance() {
            Account account = new Account(5.4);

            Deposit deposit = new Deposit(3.2);
            LocalDate date = LocalDate.of(2019, 1, 1);
            account.apply(deposit, date);

            Assertions.assertEquals(8.6, account.getBalance());
        }

        @Test
        @DisplayName("Apply a deposit on negative account should impact balance")
        void apply_a_deposit_on_negative_account_should_impact_balance() {
            Account account = new Account(-5.7);

            double amount = 3.2;
            Deposit deposit = new Deposit(amount);
            LocalDate date = LocalDate.of(2019, 1, 1);
            account.apply(deposit, date);

            Assertions.assertEquals(-2.5, account.getBalance());
        }
    }


}