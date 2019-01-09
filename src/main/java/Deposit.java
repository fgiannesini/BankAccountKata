public class Deposit {

    private final double amount;

    public Deposit(double amount) {
        checkInput(amount);
        this.amount = amount;
    }

    private void checkInput(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount could not be negative");
        }
    }

}
