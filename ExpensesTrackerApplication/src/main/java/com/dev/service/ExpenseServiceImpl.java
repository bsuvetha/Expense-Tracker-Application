package com.dev.service;

import com.dev.dao.ExpenseDao;
import com.dev.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseDao.getAllExpenses();
    }
    @Override
    public void addExpense(Expense expense) {
        expenseDao.addExpense(expense);
    }


    @Override
    public void updateExpense(Expense expense) {
        expenseDao.updateExpense(expense);
    }

    @Override
    public void deleteExpense(int id) {
        expenseDao.deleteExpense(id);
    }

    @Override
    public Expense getExpenseById(int id) {
        return expenseDao.getExpenseById(id);
    }
}
