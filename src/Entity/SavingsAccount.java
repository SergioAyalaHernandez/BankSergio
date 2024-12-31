package Entity;

import Strategy.SavingsAccountStrategy;

public class SavingsAccount extends BankAccount {
    private double tasaInteres;

    public SavingsAccount(String numberAccount, double initialBalance, double tasaInteres) {
        super(numberAccount, initialBalance, new SavingsAccountStrategy());
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}

