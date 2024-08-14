package com.example.wearfinancemanager_finalproject_sec2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wearfinancemanager_finalproject_sec2.R;
import com.example.wearfinancemanager_finalproject_sec2.model.Budget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder> {

    private List<Budget> budgets = new ArrayList<>(); // Initialize with an empty list

    public BudgetAdapter(List<Budget> budgets) {
        this.budgets = budgets;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_budget, parent, false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        Budget budget = budgets.get(position);
        holder.budgetName.setText(budget.getName());
        holder.budgetLimit.setText(String.format(Locale.getDefault(), "%.2f", budget.getLimit()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        holder.budgetStartDate.setText(sdf.format(budget.getStartDate()));
        holder.budgetEndDate.setText(sdf.format(budget.getEndDate()));
    }

    @Override
    public int getItemCount() {
        return budgets.size();
    }

    public void setBudgets(List<Budget> newBudgets) {
        this.budgets = newBudgets;
        notifyDataSetChanged(); // Notify RecyclerView that data has changed
    }

    public static class BudgetViewHolder extends RecyclerView.ViewHolder {
        TextView budgetName, budgetLimit, budgetStartDate, budgetEndDate;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            budgetName = itemView.findViewById(R.id.budgetName);
            budgetLimit = itemView.findViewById(R.id.budgetLimit);
            budgetStartDate = itemView.findViewById(R.id.budgetStartDate);
            budgetEndDate = itemView.findViewById(R.id.budgetEndDate);
        }
    }
}
