package models;

import java.util.ArrayList;
import java.util.List;

public class WalletModel {
    private final List<TransactionModel> transactions;
    private String owner;
    private double amount;

    public WalletModel() {
        this.owner = "";
        this.amount = 0;
        transactions = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addTransaction(TransactionModel transaction) {
        transactions.add(transaction);
    }

    public List<TransactionModel> getTransactionHistory() {
        return transactions;
    }
}



