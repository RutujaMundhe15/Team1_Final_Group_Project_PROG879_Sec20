package com.example.wearfinancemanager_finalproject_sec2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wearfinancemanager_finalproject_sec2.R;
import com.example.wearfinancemanager_finalproject_sec2.model.Expense;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;

    public ExpenseAdapter(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.expenseNameTextView.setText(expense.getName());
        holder.expenseAmountTextView.setText(String.format("%.2f", expense.getAmount()));
        holder.expenseDateTextView.setText(expense.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenseList = expenses;
        notifyDataSetChanged();
    }

    static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView expenseNameTextView;
        TextView expenseAmountTextView;
        TextView expenseDateTextView;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseNameTextView = itemView.findViewById(R.id.expense_name_input);
            expenseAmountTextView = itemView.findViewById(R.id.expenseAmount);
            expenseDateTextView = itemView.findViewById(R.id.expenseDate);
        }
    }
}
