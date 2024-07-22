package com.example.demo.controller;
//Bu sınıf, harcamalarla ilgili HTTP isteklerini işlemek için kullanılıyor. REST API için endpoint'ler sağlar.
import com.example.demo.models.Expense;
import com.example.demo.service.ExpenseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/expenses")

public class ExpenseController {
    private final ExpenseService service;
    @GetMapping("/get")

    public List<Expense> getAll(){
        return service.getAll();

    }
    @GetMapping("/{expenseId}")
    public Expense getById(@PathVariable("expenseId") Long expenseId){
        return service.getExpenseId(expenseId);
    }
    @GetMapping("/total/{userId}")
    public Double getTotal(@PathVariable("userId")Long userId){
        return service.getTotalByUserId(userId);
    }
    @DeleteMapping("/{expenseId}")
    public void deleteById(@PathVariable("expenceId")Long expenseId){
        service.deleteById(expenseId);
    }
    @PostMapping("/create")
    public Expense createNewExpense (@RequestBody Expense expense){
        return service.createExpense(expense);
    }
    @PutMapping("/guncelle/{expenseId}")
    public Expense expenseUpdate(@PathVariable("expenseId")Long expenseId, @RequestBody Expense ex){
        return service.exUpdate(expenseId, ex);

    }
}
