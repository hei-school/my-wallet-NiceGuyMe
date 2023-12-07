#ifndef WALLET_H
#define WALLET_H

#define MAX_TRANSACTIONS 100

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    double balance;
    char transactions[MAX_TRANSACTIONS][50];
    int transactionCount;
} Wallet;

void addIncome(Wallet *wallet, double amount);
void addExpense(Wallet *wallet, double amount);
void checkBalance(Wallet *wallet);
void viewTransactions(Wallet *wallet);

#endif /* WALLET_H */
