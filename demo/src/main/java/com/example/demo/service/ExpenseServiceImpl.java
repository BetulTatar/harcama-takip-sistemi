package com.example.demo.service;

import com.example.demo.exeptions.ExpenseNotFoundException;
import com.example.demo.models.Expense;
import com.example.demo.models.User;
import com.example.demo.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//ExpenseServiceImpl sınıfı, harcama ile ilgili iş mantığını uygular ve CRUD (Create, Read, Update, Delete) işlemlerini yönetir
@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository repository;
    @Override
    public List<Expense> getAll() {
        return repository.findAll();
    }

    @Override
    public Expense getExpenseId(Long expenseId) {
        return repository.findById(expenseId).orElseThrow(() -> new ExpenseNotFoundException("Harcama Bulunamadı"));
    }

    @Override
    public void deleteById(Long expenceId) {
        repository.deleteById(expenceId);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense exUpdate(Long expenseId, Expense ex) {
        Optional<Expense> expense = repository.findById(expenseId);
        if(expense.isPresent()){
            Expense foundExpense = expense.get();
            foundExpense.setDate(ex.getDate());
            foundExpense.setAmount(ex.getAmount());
            foundExpense.setUser(ex.getUser());
            return foundExpense;
        } else {
            return null;
        }
    }

    @Override
    public Double getTotalByUserId(Long userId) {
        return repository.findTotalExpenseByUserId(userId);
    }
}
