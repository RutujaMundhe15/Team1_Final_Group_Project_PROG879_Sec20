package com.example.wearfinancemanager_finalproject_sec2.repository;

import com.example.wearfinancemanager_finalproject_sec2.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    private final List<Expense> expenseList;

    public ExpenseRepository() {
        this.expenseList = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenseList);
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }
        return total;
    }
}
