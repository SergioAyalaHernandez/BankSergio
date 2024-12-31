package Strategy;

import Entity.BankAccount;

public interface TransactionStrategy {
    void retirar(BankAccount bankAccount, double montoRetirar);
    void depositar(BankAccount bankAccount, double montoDepositar);
    double getSaldo(BankAccount bankAccount);
    String getNumeroCuenta(BankAccount bankAccount);
}
