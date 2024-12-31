package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private String userId;
    private String idAccount;
    private List<Transactions> transactions;
    private SavingsAccount savingsAccount;
    private CurrentAccount currentAccount;

    public User(String userId, String idAccount, List<Transactions> transactions, SavingsAccount cuentaAhorros, BankAccount cuentaBancaria) {
        this.userId = userId;
        this.idAccount = idAccount;
        this.transactions = transactions;
        this.savingsAccount = savingsAccount;
        this.currentAccount = currentAccount;
    }

    public User(int id, String name, String lastName, LocalDate dateOfBirth, String country, String numberDocument, String userId, String idAccount, List<Transactions> transactions, SavingsAccount savingsAccount, CurrentAccount currentAccount) {
        super(id, name, lastName, dateOfBirth, country, numberDocument);
        this.userId = userId;
        this.idAccount = idAccount;
        this.transactions = transactions;
        this.savingsAccount = savingsAccount;
        this.currentAccount = currentAccount;
    }

    public User(String userId, String accountId, String userName, String userLastName,
                LocalDate dateOfBirth, String country, String numberDocument) {
        super(Integer.parseInt(userId),userName, userLastName, dateOfBirth,country,numberDocument);
        this.userId = userId;
        this.idAccount = accountId;
        this.transactions = new ArrayList<>();
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}
