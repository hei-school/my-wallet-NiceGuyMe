#include "wallet.h"

int main() {
    Wallet wallet;
    wallet.balance = 0;
    wallet.transactionCount = 0;

    while (1) {
        printf("\n===== Wallet Management =====\n");
        printf("1. Add Income\n");
        printf("2. Add Expense\n");
        printf("3. Check Balance\n");
        printf("4. View Transactions\n");
        printf("5. Exit\n");

        int choice;
        printf("Enter your choice (1-5): ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                double income;
                printf("Enter income amount: $");
                scanf("%lf", &income);
                addIncome(&wallet, income);
                printf("Income added successfully!\n");
                break;

            case 2:
                double expense;
                printf("Enter expense amount: $");
                scanf("%lf", &expense);
                addExpense(&wallet, expense);
                printf("Expense added successfully!\n");
                break;

            case 3:
                checkBalance(&wallet);
                break;

            case 4:
                viewTransactions(&wallet);
                break;

            case 5:
                printf("Exiting wallet management. Goodbye!\n");
                exit(0);

            default:
                printf("Invalid choice. Please enter a number between 1 and 5.\n");
        }
    }

    return 0;
}
