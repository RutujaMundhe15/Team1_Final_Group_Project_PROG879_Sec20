package com.example.wearfinancemanager_finalproject_sec2.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.wearfinancemanager_finalproject_sec2.R;
import com.example.wearfinancemanager_finalproject_sec2.model.Budget;
import com.example.wearfinancemanager_finalproject_sec2.viewmodel.BudgetViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BudgetActivity extends AppCompatActivity {

    private BudgetViewModel budgetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        budgetViewModel = new ViewModelProvider(this).get(BudgetViewModel.class);

        EditText budgetNameEditText = findViewById(R.id.budget_name_input);
        EditText budgetLimitEditText = findViewById(R.id.budget_limit_input);
        Button saveBudgetButton = findViewById(R.id.add_budget_button);

        saveBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String budgetName = budgetNameEditText.getText().toString();
                String budgetLimitInput = budgetLimitEditText.getText().toString();

                if (budgetLimitInput.matches("\\d+(\\.\\d+)?")) {
                    double budgetLimit = Double.parseDouble(budgetLimitInput);
                    String startDateString = "2022-01-01";
                    String endDateString = "2022-12-31";

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    try {
                        Date startDate = sdf.parse(startDateString);
                        Date endDate = sdf.parse(endDateString);

                        Budget newBudget = new Budget(budgetName, budgetLimit, startDate, endDate);
                        budgetViewModel.addBudget(newBudget);

                        Toast.makeText(BudgetActivity.this, "Budget Added", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (ParseException e) {
                        Toast.makeText(BudgetActivity.this, "Invalid date format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BudgetActivity.this, "Please enter a valid number for the budget limit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
