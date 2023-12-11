import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Wallet wallet = new Wallet();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n===== Wallet Management =====");
      System.out.println("1. Add Income");
      System.out.println("2. Add Expense");
      System.out.println("3. Check Balance");
      System.out.println("4. View Transactions");
      System.out.println("5. Exit");

      System.out.print("Enter your choice (1-5): ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter income amount: $");
          double income = scanner.nextDouble();
          wallet.addIncome(income);
          System.out.println("Income added successfully!");
          break;

        case 2:
          System.out.print("Enter expense amount: $");
          double expense = scanner.nextDouble();
          wallet.addExpense(expense);
          System.out.println("Expense added successfully!");
          break;

        case 3:
          System.out.println(wallet.checkBalance());
          break;

        case 4:
          System.out.println("\n===== Transaction History =====");
          System.out.println(wallet.viewTransactions());
          break;

        case 5:
          System.out.println("Exiting wallet management. Goodbye!");
          scanner.close();
          System.exit(0);
          break;

        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 5.");
      }
    }
  }
}
