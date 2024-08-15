package com.example.wearfinancemanager_finalproject_sec2.model;

import java.util.Date;

public class Expense {
    /**
     * Represents an individual expense record in a financial management system.
     * This class stores details about a specific expense, including its name, amount, and the date it was incurred.
     */

    // The name of the expense item, providing a brief description (e.g., "Coffee", "Book").

    private String name;
    // The monetary amount spent on this expense, stored as a double.

    private double amount;
    // The date when the expense was incurred.
    private Date date;

    public Expense(String name, double amount, Date date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
