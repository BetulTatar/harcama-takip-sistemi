package com.example.demo.service;

import com.example.demo.models.Expense;
import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void kullaniciSil(Long userId);
    User createUser(User user);
    User IdBul(Long userId);
    User kullaniciGuncelle(Long userId, User newuser);


}
