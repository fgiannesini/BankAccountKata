package com.fgiannesini.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DepositTest {

    @Test
    @DisplayName("Init with negative amount should throw an exception")
    void init_with_negative_amount_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Deposit(-3.6, LocalDate.of(2019, 1, 1)),
                "Deposit amount cannot be negative"
        );
    }

    @Test
    @DisplayName("Init without date should throw an exception")
    void init_without_date_should_throw_an_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Deposit(3.6, null),
                "Deposit date must be set"
        );
    }

}