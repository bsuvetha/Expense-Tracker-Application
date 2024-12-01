package com.dev.service;

import com.dev.model.Expense;
import java.util.List;

public interface ExpenseService {
    
    List<Expense> getAllExpenses();
    void addExpense(Expense expense);
    void updateExpense(Expense expense);
    void deleteExpense(int id);
    Expense getExpenseById(int id);
}
