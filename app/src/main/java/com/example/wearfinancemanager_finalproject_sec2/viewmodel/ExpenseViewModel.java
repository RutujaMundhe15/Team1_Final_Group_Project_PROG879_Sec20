package com.example.wearfinancemanager_finalproject_sec2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.wearfinancemanager_finalproject_sec2.model.Expense;
import com.example.wearfinancemanager_finalproject_sec2.repository.ExpenseRepository;
import java.util.List;

public class ExpenseViewModel extends ViewModel {

    private final ExpenseRepository expenseRepository;
    private final MutableLiveData<List<Expense>> expenses;
    private final MutableLiveData<Double> totalExpenses;

    public ExpenseViewModel() {
        this.expenseRepository = new ExpenseRepository();
        this.expenses = new MutableLiveData<>();
        this.totalExpenses = new MutableLiveData<>(0.0);
        loadExpenses();
    }

    private void loadExpenses() {
        // Simulate loading expenses
        List<Expense> loadedExpenses = expenseRepository.getAllExpenses();
        expenses.setValue(loadedExpenses);
        calculateTotalExpenses(loadedExpenses);
    }

    private void calculateTotalExpenses(List<Expense> expenses) {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        totalExpenses.setValue(total);
    }

    public LiveData<List<Expense>> getExpenses() {
        return expenses;
    }

    public LiveData<Double> getTotalExpenses() {
        return totalExpenses;
    }

    public void addExpense(Expense expense) {
        expenseRepository.addExpense(expense);
        loadExpenses();
    }
}
