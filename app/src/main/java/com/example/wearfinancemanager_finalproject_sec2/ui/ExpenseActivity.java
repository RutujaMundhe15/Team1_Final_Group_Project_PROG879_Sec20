package com.example.wearfinancemanager_finalproject_sec2.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.wearfinancemanager_finalproject_sec2.R;
import com.example.wearfinancemanager_finalproject_sec2.model.Expense;
import com.example.wearfinancemanager_finalproject_sec2.viewmodel.ExpenseViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExpenseActivity extends AppCompatActivity {

    private ExpenseViewModel expenseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);

        EditText expenseNameEditText = findViewById(R.id.expense_name_input);
        EditText expenseAmountEditText = findViewById(R.id.expense_amount_input);
        Button saveExpenseButton = findViewById(R.id.add_expense_button);

        saveExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseName = expenseNameEditText.getText().toString();
                String expenseAmountInput = expenseAmountEditText.getText().toString();

                if (expenseAmountInput.matches("\\d+(\\.\\d+)?")) {
                    double expenseAmount = Double.parseDouble(expenseAmountInput);
                    String dateString = "2022-01-01";

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    try {
                        Date date = sdf.parse(dateString);

                        Expense newExpense = new Expense(expenseName, expenseAmount, date);
                        expenseViewModel.addExpense(newExpense);

                        Toast.makeText(ExpenseActivity.this, "Expense Added", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (ParseException e) {
                        Toast.makeText(ExpenseActivity.this, "Invalid date format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ExpenseActivity.this, "Please enter a valid number for the expense amount", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
