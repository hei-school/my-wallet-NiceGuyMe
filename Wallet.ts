// Wallet.ts

export class Wallet {
    private balance: number;
    private transactions: string[];

    constructor() {
        this.balance = 0;
        this.transactions = [];
    }

    addIncome(amount: number): void {
        this.balance += amount;
        this.transactions.push(`Income: +$${amount}`);
    }

    addExpense(amount: number): void {
        if (amount > this.balance) {
            console.log("Insufficient funds!");
        } else {
            this.balance -= amount;
            this.transactions.push(`Expense: -$${amount}`);
        }
    }

    checkBalance(): string {
        return `Current Balance: $${this.balance}`;
    }

    viewTransactions(): string {
        if (this.transactions.length === 0) {
            return "No transactions yet.";
        }
        return this.transactions.join("\n");
    }
}
