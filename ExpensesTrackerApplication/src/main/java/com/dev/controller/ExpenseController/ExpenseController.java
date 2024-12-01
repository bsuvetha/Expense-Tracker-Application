package com.dev.controller.ExpenseController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.model.Expense;
import com.dev.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Get all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Get a specific expense by ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }

    // Add a new expense
    @PostMapping
    public String addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return "Expense added successfully!";
    }

    // Update an existing expense
    @PutMapping("/{id}")
    public String updateExpense(@PathVariable int id, @RequestBody Expense expense) {
        expense.setId(id);
        expenseService.updateExpense(expense);
        return "Expense updated successfully!";
    }

    // Delete an expense
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return "Expense deleted successfully!";
    }
}
