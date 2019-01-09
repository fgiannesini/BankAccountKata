import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AccountTest {

    @Test
    @DisplayName("Deposit a positive amount on date")
    void deposit_a_positive_amount() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance());

        double amount = 3;
        Deposit deposit = new Deposit(amount);
        LocalDate date = LocalDate.of(2019, 1, 1);
        account.apply(deposit, date);

        Assertions.assertEquals(amount, account.getBalance());
    }

}