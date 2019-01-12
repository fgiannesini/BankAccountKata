package com.fgiannesini.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WithdrawalTest {

    @Test
    @DisplayName("Init with negative amount should throw an exception")
    void init_with_negative_amount_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Withdrawal(-6.5, LocalDate.of(2019, 1, 1)),
                "Withdrawal amount cannot be negative"
        );
    }

    @Test
    @DisplayName("Init without date should throw an exception")
    void init_without_date_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Withdrawal(3.6, null),
                "Withdrawal date must be set"
        );
    }
}