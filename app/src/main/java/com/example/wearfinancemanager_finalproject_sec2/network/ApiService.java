package com.example.wearfinancemanager_finalproject_sec2.network;

import com.example.wearfinancemanager_finalproject_sec2.model.Expense;
import com.example.wearfinancemanager_finalproject_sec2.model.Budget;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("expenses")
    Call<List<Expense>> getExpenses();

    @POST("expenses")
    Call<Expense> addExpense(@Body Expense expense);

    @GET("budgets")
    Call<List<Budget>> getBudgets();

    @POST("budgets")
    Call<Budget> addBudget(@Body Budget budget);


}
