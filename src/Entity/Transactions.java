package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transactions {
    private int transactionId;
    private Double previousAmount;
    private Double newAmount;
    private LocalDateTime transactionDate;

    public Transactions(int transactionId, Double previousAmount, Double newAmount, LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.previousAmount = previousAmount;
        this.newAmount = newAmount;
        this.transactionDate = transactionDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Double getPreviousAmount() {
        return previousAmount;
    }

    public void setPreviousAmount(Double previousAmount) {
        this.previousAmount = previousAmount;
    }

    public Double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(Double newAmount) {
        this.newAmount = newAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
