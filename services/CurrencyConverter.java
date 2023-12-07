package services;

import models.enums.CurrencyType;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<CurrencyType, Double> conversionRates;

    public CurrencyConverter() {
        // Initialize the conversion rates
        conversionRates = new HashMap<>();
        conversionRates.put(CurrencyType.USD, 1.0);
        conversionRates.put(CurrencyType.EUR, 0.93);
        conversionRates.put(CurrencyType.GBP, 0.80);
        conversionRates.put(CurrencyType.MGA, 4500.0);
    }

    public double convert(double amount, CurrencyType fromCurrencyType, CurrencyType toCurrencyType) {
        if (!conversionRates.containsKey(fromCurrencyType) || !conversionRates.containsKey(toCurrencyType)) {
            System.out.println("Invalid currency");
            return -1; // or throw an exception
        }

        double fromRate = conversionRates.get(fromCurrencyType);
        double toRate = conversionRates.get(toCurrencyType);

        // Convert the amount from the source currency to USD and then to the target currency
        double inUSD = amount / fromRate;

        return inUSD * toRate;
    }
}
