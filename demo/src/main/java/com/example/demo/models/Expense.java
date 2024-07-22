package com.example.demo.models;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
//Bu sınıf, harcama bilgilerini temsil eder ve id, amount, date, ve user gibi alanları içerir.
import java.time.LocalDate;
@Data
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private Double amount;
    private LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
