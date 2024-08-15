package com.example.wearfinancemanager_finalproject_sec2.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wearfinancemanager_finalproject_sec2.R;


/**
 * The main activity of the application, serving as the entry point for users.
 * This class sets up the user interface for the main menu and initializes actions for buttons.
 */

public class MainActivity extends AppCompatActivity {
    //Initializes the main activity with buttons that navigate to different parts of the application.
    // The onCreate method is a fundamental part of setting up an Android activity and is called when the activity is starting.

    @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        // Set the user interface layout for this activity.
        // The layout file is defined in the project res/layout/activity_main.xml file.

        setContentView(R.layout.activity_main);
        // Setting up the listener for the "Add Expense" button to navigate to the ExpenseActivity.

            findViewById(R.id.add_expense_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, ExpenseActivity.class));
                }
            });
        // Setting up the listener for the "Add Budget" button to navigate to the BudgetActivity.

            findViewById(R.id.add_budget_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, BudgetActivity.class));
                }
            });
        // Setting up the listener for the "View Summary" button to navigate to the ViewBudgetActivity.

            findViewById(R.id.view_summary_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, ViewBudgetActivity.class));
                }
            });
        }
    }
