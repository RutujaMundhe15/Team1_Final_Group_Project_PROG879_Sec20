package com.example.wearfinancemanager_finalproject_sec2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.wearfinancemanager_finalproject_sec2.model.Budget;
import com.example.wearfinancemanager_finalproject_sec2.repository.BudgetRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BudgetViewModel extends ViewModel {

    private final BudgetRepository budgetRepository;
    private final MutableLiveData<List<Budget>> budgets;
    private final MutableLiveData<Double> totalBudget;

    public BudgetViewModel() {
        this.budgetRepository = new BudgetRepository();
        this.budgets = new MutableLiveData<>();
        this.totalBudget = new MutableLiveData<>(0.0);
        loadBudgets();
    }

    private void loadBudgets() {
        // Add some dummy data for testing
        List<Budget> loadedBudgets = new ArrayList<>();
        loadedBudgets.add(new Budget("Groceries", 500.0, new Date(), new Date()));
        loadedBudgets.add(new Budget("Rent", 1500.0, new Date(), new Date()));
        loadedBudgets.add(new Budget("Utilities", 300.0, new Date(), new Date()));
        loadedBudgets.add(new Budget("Entertainment", 200.0, new Date(), new Date()));

        budgets.setValue(loadedBudgets);
        calculateTotalBudget(loadedBudgets);
    }

    private void calculateTotalBudget(List<Budget> budgets) {
        double total = 0;
        for (Budget budget : budgets) {
            total += budget.getLimit();
        }
        totalBudget.setValue(total);
    }

    public LiveData<List<Budget>> getBudgets() {
        return budgets;
    }

    public LiveData<Double> getTotalBudget() {
        return totalBudget;
    }

    public void addBudget(Budget budget) {
        budgetRepository.addBudget(budget);
        loadBudgets();
    }
}
