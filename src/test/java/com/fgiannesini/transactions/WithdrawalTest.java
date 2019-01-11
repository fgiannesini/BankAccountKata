package com.fgiannesini.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WithdrawalTest {

    @Test
    @DisplayName("check initial value is set")
    void check_initial_value_is_set() {
        double expectedAmount = 7.0;
        Withdrawal withdrawal = new Withdrawal(expectedAmount);
        Assertions.assertEquals(expectedAmount, withdrawal.getAmount());
    }

    @Test
    @DisplayName("Init with negative amount should throw an exception")
    void init_with_negative_amount_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Withdrawal(-6.5),
                "Withdrawal amount cannot be negative"
        );
    }
}