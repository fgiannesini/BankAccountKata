package com.fgiannesini.account;

import com.fgiannesini.transactions.Deposit;
import com.fgiannesini.transactions.Withdrawal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class AccountTest {

    private final static double DOUBLE_ASSERT_PRECISION = 0.00001;
    private final static LocalDate initialDate = LocalDate.of(1970, 1, 1);

    @Test
    @DisplayName("create empty account")
    void create_empty_account() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance(), DOUBLE_ASSERT_PRECISION);
        Assertions.assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    @DisplayName("create positive account")
    void create_positive_account() {
        double initialBalance = 3.4;
        Account account = createAccountWithInitialBalanceAndDefaultDate(initialBalance);

        Assertions.assertEquals(initialBalance, account.getBalance(), DOUBLE_ASSERT_PRECISION);

        List<Transaction> transactions = account.getTransactions();
        Assertions.assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(initialBalance, transaction.getAmount(), DOUBLE_ASSERT_PRECISION);
        Assertions.assertEquals(initialDate, transaction.getApplicationDate());
        Assertions.assertEquals(TransactionType.DEPOSIT, transaction.getTransactionType());
    }

    @Test
    @DisplayName("create negative account should throw an exception")
    void create_negative_account_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> createAccountWithInitialBalanceAndDefaultDate(-3.4),
                "Account amount can't be negative"
        );
    }

    private Account createAccountWithInitialBalanceAndDefaultDate(double initialBalance) {
        return new Account(initialBalance, initialDate);
    }

    @Nested
    class WithdrawalImpact {

        @Test
        @DisplayName("Apply a withdrawal with amount lower than account amount should decrease balance")
        void apply_a_withdrawal_on_account_should_decrease_balance() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(5.4);

            LocalDate withdrawalDate = initialDate.plusDays(1);
            Withdrawal withdrawal = new Withdrawal(3.2, withdrawalDate);
            account.apply(withdrawal);

            Assertions.assertEquals(2.2, account.getBalance(), DOUBLE_ASSERT_PRECISION);

            List<Transaction> transactions = account.getTransactions();
            Assertions.assertEquals(2, transactions.size());
            Transaction transaction = transactions.get(1);
            Assertions.assertEquals(-3.2, transaction.getAmount(), DOUBLE_ASSERT_PRECISION);
            Assertions.assertEquals(withdrawalDate, transaction.getApplicationDate());
            Assertions.assertEquals(TransactionType.WITHDRAWAL, transaction.getTransactionType());
        }

        @Test
        @DisplayName("Apply a withdrawal with amount higher than account should clear account amount")
        void apply_a_withdrawal_should_clear_account_amount() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(2);

            LocalDate withdrawalDate = initialDate.plusDays(1);
            Withdrawal withdrawal = new Withdrawal(3.2, withdrawalDate);
            account.apply(withdrawal);

            Assertions.assertEquals(0, account.getBalance(), DOUBLE_ASSERT_PRECISION);

            List<Transaction> transactions = account.getTransactions();
            Assertions.assertEquals(2, transactions.size());
            Transaction transaction = transactions.get(1);
            Assertions.assertEquals(-2.0, transaction.getAmount(), DOUBLE_ASSERT_PRECISION);
            Assertions.assertEquals(withdrawalDate, transaction.getApplicationDate());
            Assertions.assertEquals(TransactionType.WITHDRAWAL, transaction.getTransactionType());
        }

    }

    @Nested
    class DepositImpact {

        @Test
        @DisplayName("Apply a deposit should increase balance")
        void apply_a_deposit_should_increase_balance() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(5.4);

            LocalDate depositDate = initialDate.plusDays(1);
            Deposit deposit = new Deposit(3.2, depositDate);
            account.apply(deposit);

            Assertions.assertEquals(8.6, account.getBalance(), DOUBLE_ASSERT_PRECISION);

            List<Transaction> transactions = account.getTransactions();
            Assertions.assertEquals(2, transactions.size());
            Transaction transaction = transactions.get(1);
            Assertions.assertEquals(3.2, transaction.getAmount(), DOUBLE_ASSERT_PRECISION);
            Assertions.assertEquals(depositDate, transaction.getApplicationDate());
            Assertions.assertEquals(TransactionType.DEPOSIT, transaction.getTransactionType());
        }

    }
}