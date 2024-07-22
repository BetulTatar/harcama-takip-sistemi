package com.example.demo.controller;

import com.example.demo.models.Expense;
import com.example.demo.models.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/app/users")
public class UserController {

    private final UserService service;
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }
    @GetMapping("/{userId}")
    public User findUserById(@PathVariable("userId")Long userId){
        return service.IdBul(userId);
    }
    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
            service.kullaniciSil(userId);

    }
@PostMapping("/olustur")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
}
@PutMapping("/guncelle/{userId}")
    public User kullaniciGuncelle(@PathVariable("userId")Long userId, @RequestBody User newuser){
        return service.kullaniciGuncelle(userId, newuser);
}

}
