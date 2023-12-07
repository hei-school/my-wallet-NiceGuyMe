package services;

import models.enums.CurrencyType;

public class walletServices {
    // Method to clear the console
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Clear command for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clear command for Unix-like systems
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions if needed
            e.printStackTrace();
        }
    }

    public static void showInCurrency(double amountInAr, CurrencyType toCurrencyType) {
        CurrencyConverter converter = new CurrencyConverter();

        CurrencyType fromCurrencyType = CurrencyType.MGA;
        double result = converter.convert(amountInAr, fromCurrencyType, toCurrencyType);

        System.out.println(amountInAr + " " + fromCurrencyType + " is equal to " + result + " " + toCurrencyType);
    }

    public static void showInMultipleCurrencies(double amountInAr) {
        showInCurrency(amountInAr, CurrencyType.USD);
        showInCurrency(amountInAr, CurrencyType.EUR);
        showInCurrency(amountInAr, CurrencyType.GBP);
    }

}
