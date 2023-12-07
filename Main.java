import models.TransactionModel;
import models.WalletModel;
import models.enums.CurrencyType;
import models.enums.TransactionType;
import services.CurrencyConverter;
import services.walletServices;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final WalletModel walletModel = new WalletModel();
    private static final CurrencyConverter converter = new CurrencyConverter();

    public static void main(String[] args) {
        greetUser();

        while (true) {
            displayWalletInfo();
            int selection = getUserSelection();
            handleUserSelection(selection);
        }
    }

    private static void greetUser() {
        System.out.println("==================");
        System.out.println("What is your name?");
        System.out.println("==================");
        walletModel.setOwner(scanner.nextLine());
        walletServices.clearConsole();
    }

    private static void displayWalletInfo() {
        System.out.println("===============================");
        System.out.println("Wallet of: " + walletModel.getOwner());
        System.out.println("===============================");
        System.out.println("Total money: " + walletModel.getAmount() + " Ariary");
        System.out.println("===============================");
        System.out.println("Select an option:");
        System.out.println("1. Add cash");
        System.out.println("2. Display my money in different currencies");
        System.out.println("3. Spend the money");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        System.out.println("===============================");
    }

    private static int getUserSelection() {
        return scanner.nextInt();
    }

    private static void handleUserSelection(int selection) {
        switch (selection) {
            case 1:
                addMoney();
                break;
            case 2:
                showInMultipleCurrencies();
                break;
            case 3:
                spendMoney();
                break;
            case 4:
                displayTransactionHistory();
                break;
            case 5:
                exitProgram();
                break;
            default:
                System.out.println("Invalid selection. Please choose an option from 1 to 5.");
        }
    }

    private static void addMoney() {
        displayCurrencyOptions("Add cash in");
        int selection = getUserSelection();
        handleCurrencySelection(selection, true);
    }

    private static void showInMultipleCurrencies() {
        walletServices.showInMultipleCurrencies(walletModel.getAmount());
    }

    private static void spendMoney() {
        displayCurrencyOptions("Spend in");
        int selection = getUserSelection();
        handleCurrencySelection(selection, false);
    }

    private static void displayTransactionHistory() {
        List<TransactionModel> transactions = walletModel.getTransactionHistory();

        System.out.println("===============================");
        System.out.println("Transaction History:");
        System.out.println("===============================");

        for (TransactionModel transaction : transactions) {
            System.out.println("Date: " + transaction.date());
            System.out.println("Type: " + transaction.type());
            System.out.println("Amount: " + transaction.amount());
            System.out.println("-----------------------");
        }
        System.out.println("===============================");
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private static void displayCurrencyOptions(String message) {
        System.out.println("===============================");
        System.out.println(message + ":");
        System.out.println("1. " + CurrencyType.EUR);
        System.out.println("2. " + CurrencyType.USD);
        System.out.println("3. " + CurrencyType.GBP);
        System.out.println("4. " + CurrencyType.MGA);
        System.out.println("===============================");
    }

    private static void handleCurrencySelection(int selection, boolean isAdding) {
        double actualWallet = walletModel.getAmount();

        switch (selection) {
            case 1:
            case 2:
            case 3:
            case 4:
                handleConversion(selection, actualWallet, isAdding);
                break;
            default:
                System.out.println("Invalid currency selection.");
        }
    }

    private static void handleConversion(int selection, double actualWallet, boolean isAdding) {
        models.enums.CurrencyType fromCurrency = getCurrencyFromSelection(selection);
        models.enums.CurrencyType toCurrency = models.enums.CurrencyType.MGA;

        String action = isAdding ? "Enter the amount in" : "Enter the amount to spend in";
        System.out.println("===============================");
        System.out.println(action + " " + fromCurrency + ":");
        System.out.println("===============================");

        double value = scanner.nextDouble();
        double convertedAmount = converter.convert(value, fromCurrency, toCurrency);

        if (isAdding) {
            double newAmount = actualWallet + convertedAmount;
            walletModel.setAmount(newAmount);
            recordTransaction(TransactionType.DEPOSIT, convertedAmount);
        } else {
            double newAmount = actualWallet - convertedAmount;
            walletModel.setAmount(newAmount);
            recordTransaction(TransactionType.WITHDRAWAL, convertedAmount);
        }
    }

    private static void recordTransaction(TransactionType type, double amount) {
        TransactionModel transaction = new TransactionModel(type, amount, new Date());
        walletModel.addTransaction(transaction);
    }

    private static CurrencyType getCurrencyFromSelection(int selection) {
        return switch (selection) {
            case 1 -> CurrencyType.EUR;
            case 2 -> CurrencyType.USD;
            case 3 -> CurrencyType.GBP;
            case 4 -> CurrencyType.MGA;
            default -> throw new IllegalArgumentException("Invalid currency selection");
        };
    }
}
