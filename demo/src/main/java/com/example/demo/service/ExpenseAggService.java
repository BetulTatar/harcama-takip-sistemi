package com.example.demo.service;

public interface ExpenseAggService {
    void aggregateUserExpensesDaily();

    void aggregateUserExpensesWeekly();

    void aggregateUserExpensesMonthly();
}
