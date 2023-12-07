from wallet import Wallet


def main():
    wallet = Wallet()

    while True:
        print("\n===== Wallet Management =====")
        print("1. Add Income")
        print("2. Add Expense")
        print("3. Check Balance")
        print("4. View Transactions")
        print("5. Exit")

        choice = input("Enter your choice (1-5): ")

        if choice == "1":
            income = float(input("Enter income amount: "))
            wallet.add_income(income)
            print("Income added successfully!")

        elif choice == "2":
            expense = float(input("Enter expense amount: "))
            wallet.add_expense(expense)
            print("Expense added successfully!")

        elif choice == "3":
            print(wallet.check_balance())

        elif choice == "4":
            print("\n===== Transaction History =====")
            print(wallet.view_transactions())

        elif choice == "5":
            print("Exiting wallet management. Goodbye!")
            break

        else:
            print("Invalid choice. Please enter a number between 1 and 5.")


if __name__ == "__main__":
    main()
