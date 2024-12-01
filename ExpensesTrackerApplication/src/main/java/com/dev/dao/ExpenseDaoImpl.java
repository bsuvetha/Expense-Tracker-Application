package com.dev.dao;

import com.dev.model.Expense;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expensesss (id, name, amount, expense_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, expense.getId(), expense.getName(), expense.getAmount(), expense.getExpense_date());
    }

    @Override
    public List<Expense> getAllExpenses() {
        String sql = "SELECT * FROM expensesss";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Expense expense = new Expense();
            expense.setId(rs.getInt("id"));
            expense.setName(rs.getString("name"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setExpense_date(rs.getString("expense_date"));
            return expense;
        });
    }

    @Override
    public void updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET name = ?, amount = ?, expense_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, expense.getName(), expense.getAmount(), expense.getExpense_date(), expense.getId());
    }

    @Override
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Expense getExpenseById(int id) {
        String sql = "SELECT * FROM expenses WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Expense expense = new Expense();
            expense.setId(rs.getInt("id"));
            expense.setName(rs.getString("name"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setExpense_date(rs.getString("expense_date"));
            return expense;
        }, id);
    }
}
