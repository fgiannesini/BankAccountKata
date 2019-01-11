package com.fgiannesini;

import com.fgiannesini.account.Account;
import com.fgiannesini.transactions.Deposit;
import com.fgiannesini.transactions.Withdrawal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AccountTest {

    private final static double DOUBLE_ASSERT_PRECISION = 0.00001;

    @Test
    @DisplayName("create empty account")
    void create_empty_account() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance(), DOUBLE_ASSERT_PRECISION);
    }

    @Test
    @DisplayName("create positive account")
    void create_positive_account() {
        double initialBalance = 3.4;
        Account account = createAccountWithInitialBalanceAndDefaultDate(initialBalance);
        Assertions.assertEquals(initialBalance, account.getBalance(), DOUBLE_ASSERT_PRECISION);
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

    @Nested
    class DepositImpact {

        @Test
        @DisplayName("Apply a deposit account should increase balance")
        void apply_a_deposit_on_positive_account_should_increase_balance() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(5.4);

            Deposit deposit = new Deposit(3.2);
            account.apply(deposit);

            Assertions.assertEquals(8.6, account.getBalance(), DOUBLE_ASSERT_PRECISION);
        }


    }
    @Nested
    class WithdrawalImpact {

        @Test
        @DisplayName("Apply a withdrawal with amount lower than account amount. Should decrease balance")
        void apply_a_withdrawal_on_account_should_decrease_balance() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(5.4);

            Withdrawal withdrawal = new Withdrawal(3.2);
            account.apply(withdrawal);

            Assertions.assertEquals(2.2, account.getBalance(), DOUBLE_ASSERT_PRECISION);
        }

        @Test
        @DisplayName("Apply a withdrawal with amount higher than account. Should clear account amount")
        void apply_a_withdrawal_on_account_should_clear_account_amount() {
            Account account = createAccountWithInitialBalanceAndDefaultDate(2);

            Withdrawal withdrawal = new Withdrawal(3.2);
            account.apply(withdrawal);

            Assertions.assertEquals(0, account.getBalance(), DOUBLE_ASSERT_PRECISION);
        }

    }

    private Account createAccountWithInitialBalanceAndDefaultDate(double initialBalance) {
        return new Account(initialBalance, LocalDate.of(1970,1,1));
    }
}