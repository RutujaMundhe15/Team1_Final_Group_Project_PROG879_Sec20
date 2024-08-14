package com.example.wearfinancemanager_finalproject_sec2.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wearfinancemanager_finalproject_sec2.R;

public class MainActivity extends AppCompatActivity {


        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            findViewById(R.id.add_expense_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, ExpenseActivity.class));
                }
            });

            findViewById(R.id.add_budget_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, BudgetActivity.class));
                }
            });

            findViewById(R.id.view_summary_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, ViewBudgetActivity.class));
                }
            });
        }
    }
