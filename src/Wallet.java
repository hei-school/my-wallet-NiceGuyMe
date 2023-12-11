import java.util.ArrayList;

/**
 * The type Wallet.
 */
public class Wallet {
  private double balance;
  private ArrayList<String> transactions;

  /**
   * Instantiates a new Wallet.
   */
  public Wallet() {
    balance = 0;
    transactions = new ArrayList<>();
  }

  /**
   * Add income.
   *
   * @param amount the amount
   */
  public void addIncome(double amount) {
    balance += amount;
    transactions.add("Income: +$" + amount);
  }

  /**
   * Add expense.
   *
   * @param amount the amount
   */
  public void addExpense(double amount) {
    if (amount > balance) {
      System.out.println("Insufficient funds!");
    } else {
      balance -= amount;
      transactions.add("Expense: -$" + amount);
    }
  }

  /**
   * Check balance string.
   *
   * @return the string
   */
  public String checkBalance() {
    return "Current Balance: $" + balance;
  }

  /**
   * View transactions string.
   *
   * @return the string
   */
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
