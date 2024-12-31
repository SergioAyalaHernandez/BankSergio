package Entity;

import Strategy.TransactionStrategy;

public abstract class BankAccount {
    private String numberAccount;
    protected double balance;
    private TransactionStrategy operationStrategy;

    public BankAccount(String numberAccount, double initialBalance, TransactionStrategy operationStrategy) {
        this.numberAccount = numberAccount;
        this.balance = initialBalance;
        this.operationStrategy = operationStrategy;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public TransactionStrategy getOperationStrategy() {
        return operationStrategy;
    }

    public void setOperationStrategy(TransactionStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
}

