package Strategy;

import Entity.BankAccount;

public class SavingsAccountStrategy implements TransactionStrategy {

    @Override
    public void retirar(BankAccount bankAccount, double montoRetirar) {
        if (montoRetirar > 0 && montoRetirar <= bankAccount.getBalance()) {
            bankAccount.setBalance(bankAccount.getBalance() - montoRetirar);
            System.out.println("Se retiraron $" + montoRetirar + " de la cuenta de ahorros.");
        } else {
            System.out.println("El monto a retirar debe ser positivo y no exceder el saldo actual.");
        }
    }

    @Override
    public void depositar(BankAccount bankAccount, double montoDepositar) {
        if (montoDepositar > 0) {
            bankAccount.setBalance(bankAccount.getBalance() + montoDepositar);
            System.out.println("Depósito exitoso en cuenta de ahorros. Saldo actual: $" + bankAccount.getBalance());
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    @Override
    public double getSaldo(BankAccount bankAccount) {
        return bankAccount.getBalance();
    }

    @Override
    public String getNumeroCuenta(BankAccount bankAccount) {
        return bankAccount.getNumberAccount();
    }
}

