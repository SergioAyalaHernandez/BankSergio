package Entity;

import Strategy.CurrentAccountStrategy;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String numberAccount, double initialBalance, double overdraftLimit) {
        super(numberAccount, initialBalance, new CurrentAccountStrategy());
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
