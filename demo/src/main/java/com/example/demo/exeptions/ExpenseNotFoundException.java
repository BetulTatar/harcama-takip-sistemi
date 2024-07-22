package com.example.demo.exeptions;
// bir harcama (expense) bulunamadığında kullanılır. Özellikle uygulama içerisinde harcamaların bulunamadığı durumları belirtmek için özel bir hata sınıfıdır.
public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException (String message){
        super(message);
    }
}
