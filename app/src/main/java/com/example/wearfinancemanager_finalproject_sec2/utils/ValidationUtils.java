package com.example.wearfinancemanager_finalproject_sec2.utils;

public class ValidationUtils {
    public static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
