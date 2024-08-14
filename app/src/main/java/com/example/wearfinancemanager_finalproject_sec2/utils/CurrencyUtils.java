package com.example.wearfinancemanager_finalproject_sec2.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {
    public static String formatCurrency(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return formatter.format(amount);
    }
}
