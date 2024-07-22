package com.example.demo.repository;

import com.example.demo.models.Expense;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//Spring Data JPA kullanarak bir Expense (harcama) repository'sini tanımlar. Repository, veritabanı işlemleri yapmak için bir arayüz sağlar
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    Double findTotalExpenseByUserId(@Param("userId") Long userId);
    List<Expense> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
