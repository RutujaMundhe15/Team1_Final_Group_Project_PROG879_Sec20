package com.example.wearfinancemanager_finalproject_sec2.repository;

import com.example.wearfinancemanager_finalproject_sec2.model.Budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetRepository {

    private final List<Budget> budgetList;

    public BudgetRepository() {
        this.budgetList = new ArrayList<>();
    }

    public void addBudget(Budget budget) {
        budgetList.add(budget);
    }

    public List<Budget> getAllBudgets() {
        return new ArrayList<>(budgetList);
    }

    public double getTotalBudget() {
        double total = 0;
        for (Budget budget : budgetList) {
            total += budget.getLimit();
        }
        return total;
    }
}
