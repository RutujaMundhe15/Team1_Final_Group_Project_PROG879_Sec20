package com.example.wearfinancemanager_finalproject_sec2.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wearfinancemanager_finalproject_sec2.R;
import com.example.wearfinancemanager_finalproject_sec2.adapters.BudgetAdapter;
import com.example.wearfinancemanager_finalproject_sec2.viewmodel.BudgetViewModel;

public class ViewBudgetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BudgetAdapter adapter;
    private BudgetViewModel budgetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_budget);

        recyclerView = findViewById(R.id.budget_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize ViewModel
        budgetViewModel = new ViewModelProvider(this).get(BudgetViewModel.class);

        // Observe changes in budgets data
        budgetViewModel.getBudgets().observe(this, budgets -> {
            if (budgets != null && !budgets.isEmpty()) {
                adapter = new BudgetAdapter(budgets);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
