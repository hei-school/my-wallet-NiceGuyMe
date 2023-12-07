class Wallet:
    def __init__(self):
        self.owner = ""
        self.balance = 0
        self.transactions = []

    def set_owner(self, name):
        self.owner = name

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


def main():
    wallet = Wallet()

    print("==================")
    print("What is your name?")
    print("==================")

    wallet.set_owner(input())

    while True:
        print("===============================")
        print("Wallet of: " + wallet.owner)
        print("===============================")
        print("Total money: " + str(wallet.balance) + " Ariary")
        print("===============================")
        print("Select an option:")
        print("1. Add cash")
        print("2. Display my money in different currencies")
        print("3. Spend the money")
        print("4. View Transaction History")
        print("5. Exit")
        print("===============================")

        choice = input()

        if choice == "1":
            income = float(input("Enter income amount: "))
            wallet.add_income(income)

        elif choice == "2":
            print(wallet.check_balance())

        elif choice == "3":
            expense = float(input("Enter expense amount: "))
            wallet.add_expense(expense)

        elif choice == "4":
            print("===== Transaction History =====")
            print(wallet.view_transactions())

        elif choice == "5":
            print("Exiting wallet management. Goodbye!")
            break

        else:
            print("Invalid selection. Please choose an option from 1 to 5.")


if __name__ == "__main__":
    main()
