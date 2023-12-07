import java.util.ArrayList;

public class Wallet {
    private double balance;
    private ArrayList<String> transactions;

    public Wallet() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public void addIncome(double amount) {
        balance += amount;
        transactions.add("Income: +$" + amount);
    }

    public void addExpense(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            transactions.add("Expense: -$" + amount);
        }
    }

    public String checkBalance() {
        return "Current Balance: $" + balance;
    }

    public String viewTransactions() {
        if (transactions.isEmpty()) {
            return "No transactions yet.";
        }
        StringBuilder transactionHistory = new StringBuilder();
        for (String transaction : transactions) {
            transactionHistory.append(transaction).append("\n");
        }
        return transactionHistory.toString();
    }
}
