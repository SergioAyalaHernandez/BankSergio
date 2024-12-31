package Strategy;

import Entity.BankAccount;
import Entity.CurrentAccount;

public class CurrentAccountStrategy implements TransactionStrategy {
    @Override
    public void retirar(BankAccount bankAccount, double montoRetirar) {
        CurrentAccount currentAccount = (CurrentAccount) bankAccount;
        if (montoRetirar > 0 && montoRetirar <= (currentAccount.getBalance() + currentAccount.getOverdraftLimit())) {
            currentAccount.setBalance(currentAccount.getBalance() - montoRetirar);
            System.out.println("Se retiraron $" + montoRetirar + " de la cuenta corriente.");
        } else {
            System.out.println("El monto a retirar excede el saldo disponible o el límite de sobregiro.");
        }
    }

    @Override
    public void depositar(BankAccount bankAccount, double montoDepositar) {
        if (montoDepositar > 0) {
            bankAccount.setBalance(bankAccount.getBalance() + montoDepositar);
            System.out.println("Depósito exitoso en cuenta corriente. Saldo actual: $" + bankAccount.getBalance());
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
