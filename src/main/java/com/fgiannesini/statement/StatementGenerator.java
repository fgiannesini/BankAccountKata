package com.fgiannesini.statement;

import com.fgiannesini.account.Transaction;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class StatementGenerator {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final NumberFormat decimalFormatter = new DecimalFormat("#0.00");

    public String generateStatementAsString(List<Transaction> transactions) {
        String statementHeader = "Operation Date Amount Balance\n";
        return statementHeader + String.join("\n", generateStatementLines(transactions));
    }

    private List<String> generateStatementLines(List<Transaction> transactions) {
        List<Transaction> sortedTransactions = getTransactionsSortedByDateFromOlder(transactions);
        List<String> statements = new ArrayList<>();
        double balance = 0;
        for (Transaction transaction : sortedTransactions) {
            balance += transaction.getAmount();
            String statement = String.join(" ",
                    transaction.getTransactionType().name(),
                    toString(transaction.getApplicationDate()),
                    toString(transaction.getAmount()),
                    toString(balance)
            );
            statements.add(statement);
        }
        Collections.reverse(statements);
        return statements;
    }

    private String toString(double amount) {
        return decimalFormatter.format(amount);
    }

    private String toString(LocalDate applicationDate) {
        return dateFormatter.format(applicationDate);
    }

    private List<Transaction> getTransactionsSortedByDateFromOlder(List<Transaction> transactions) {
        List<Transaction> sortedTransactions = new ArrayList<>(transactions);
        sortedTransactions.sort(Comparator.comparing(Transaction::getApplicationDate));
        return sortedTransactions;
    }
}
