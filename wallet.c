#include "wallet.h"

void addIncome(Wallet *wallet, double amount) {
    wallet->balance += amount;
    sprintf(wallet->transactions[wallet->transactionCount], "Income: +$%.2f", amount);
    wallet->transactionCount++;
}

void addExpense(Wallet *wallet, double amount) {
    if (amount > wallet->balance) {
        printf("Insufficient funds!\n");
    } else {
        wallet->balance -= amount;
        sprintf(wallet->transactions[wallet->transactionCount], "Expense: -$%.2f", amount);
        wallet->transactionCount++;
    }
}

void checkBalance(Wallet *wallet) {
    printf("Current Balance: $%.2f\n", wallet->balance);
}

void viewTransactions(Wallet *wallet) {
    if (wallet->transactionCount == 0) {
        printf("No transactions yet.\n");
    } else {
        printf("\n===== Transaction History =====\n");
        for (int i = 0; i < wallet->transactionCount; i++) {
            printf("%s\n", wallet->transactions[i]);
        }
    }
}