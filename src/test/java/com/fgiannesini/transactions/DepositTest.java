package com.fgiannesini.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DepositTest {

    @Test
    @DisplayName("check initial value is set")
    void check_initial_value_is_set() {
        double expectedAmount = 3.5;
        Deposit deposit = new Deposit(expectedAmount);
        Assertions.assertEquals(expectedAmount, deposit.getAmount());
    }

    @Test
    @DisplayName("Init with negative amount should throw an exception")
    void init_with_negative_amount_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Deposit(-3.6),
                "Deposit amount cannot be negative"
        );
    }

}