package com.example.demo.service;

import com.example.demo.models.Expense;

import java.util.List;
//ExpenseService arayüzü, Expense nesneleri ile ilgili temel CRUD (Create, Read, Update, Delete) işlemlerini ve ek işlevleri tanımlar.
public interface ExpenseService {
    List<Expense> getAll();

    Expense getExpenseId(Long expenseId);
    void deleteById(Long expenceId);
    Expense createExpense(Expense expense);

    Expense exUpdate(Long expenseId, Expense ex);

    Double getTotalByUserId(Long userId);
}
