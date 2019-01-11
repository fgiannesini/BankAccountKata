package com.fgiannesini.statement;

import com.fgiannesini.account.Transaction;
import com.fgiannesini.account.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StatementGeneratorTest {

    @Test
    @DisplayName("no transaction should return empty string")
    void no_transaction_should_return_empty_string() {
        String statementAsString = new StatementGenerator().generateStatementAsString(Collections.emptyList());
        Assertions.assertEquals("", statementAsString);
    }

    @Test
    @DisplayName("transactions : 1 deposit and 2 withdrawals, ordered from newer")
    void transactions_one_deposit_two_withdrawals_ordered_from_newer() {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(500.95, LocalDate.of(2018, 1, 31), TransactionType.DEPOSIT),
                new Transaction(-250.45, LocalDate.of(2018, 5, 31), TransactionType.WITHDRAWAL),
                new Transaction(-100, LocalDate.of(2018, 7, 31), TransactionType.WITHDRAWAL)
        );

        String statementAsString = new StatementGenerator().generateStatementAsString(transactionList);

        String expectedStatement = "" +
                "Operation Date Amount Balance\n" +
                "Withdrawal 31/07/2018 -100.00 150.50\n" +
                "Withdrawal 31/05/2018 -250.45 250.50\n" +
                "Deposit 31/01/2018 500.95 500.95";
        Assertions.assertEquals(expectedStatement, statementAsString);
    }

}