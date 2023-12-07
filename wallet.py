# wallet.py

class Wallet:
    def __init__(self):
        self.balance = 0
        self.transactions = []

    def add_income(self, amount):
        self.balance += amount
        self.transactions.append(f"Income: +${amount}")

    def add_expense(self, amount):
        if amount > self.balance:
            print("Insufficient funds!")
        else:
            self.balance -= amount
            self.transactions.append(f"Expense: -${amount}")

    def check_balance(self):
        return f"Current Balance: ${self.balance}"

    def view_transactions(self):
        if not self.transactions:
            return "No transactions yet."
        return "\n".join(self.transactions)
