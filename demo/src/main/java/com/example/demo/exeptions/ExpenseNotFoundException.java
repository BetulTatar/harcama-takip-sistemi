package com.example.demo.exeptions;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException (String message){
        super(message);
    }
}
