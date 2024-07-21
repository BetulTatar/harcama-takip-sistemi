package com.example.demo.service;

import com.example.demo.models.Expense;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Transactional
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void kullaniciSil(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
    @Transactional
    @Override
    public User IdBul(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    @Transactional
    public User kullaniciGuncelle(Long userId, User newuser) {
        Optional<User> user =repository.findById(userId);
        if (user.isPresent()){
            User found = user.get();
            found.setUser_name(newuser.getUser_name());
            found.setPassword(newuser.getPassword());
            return found;
        }else
            return null;
    }


}