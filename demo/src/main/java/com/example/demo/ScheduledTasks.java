package com.example.demo;

import com.example.demo.service.ExpenseAggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
    private ExpenseAggService expenseAggregationService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void aggregateDailyExpenses() {
        expenseAggregationService.aggregateUserExpensesDaily();
    }

    @Scheduled(cron = "0 0 0 * * MON")
    public void aggregateWeeklyExpenses() {
        expenseAggregationService.aggregateUserExpensesWeekly();
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void aggregateMonthlyExpenses() {
        expenseAggregationService.aggregateUserExpensesMonthly();
    }

}
