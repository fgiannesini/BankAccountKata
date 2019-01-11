package com.fgiannesini;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AccountTest {

    @Nested
    class DepositTest {
        @Test
        @DisplayName("Deposit a positive amount should impact account balance")
        void deposit_a_positive_amount_should_impact_account_balance() {
            Account account = new Account();
            Assertions.assertEquals(0, account.getBalance());

            double amount = 3;
            Deposit deposit = new Deposit(amount);
            LocalDate date = LocalDate.of(2019, 1, 1);
            account.apply(deposit, date);

            Assertions.assertEquals(amount, account.getBalance());
        }


        @Test
        @DisplayName("Deposit a negative should throw an exception")
        void deposit_a_negative_amount_should_throw_an_exception() {
            Account account = new Account();
            Assertions.assertEquals(0, account.getBalance());

            double amount = -3;
            LocalDate date = LocalDate.of(2019, 1, 1);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Deposit deposit = new Deposit(amount);
                account.apply(deposit, date);
            });
        }
    }

}