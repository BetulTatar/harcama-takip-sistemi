package com.example.demo.controller;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {
    private final UserRepository repository;
    @ApiOperation(value = "Get all users", notes = "Returns a list of all users")
    @GetMapping("/users")
    public List<User> getUsers() {

        return repository.findAll();
    }

    @ApiOperation(value = "Get user by ID", notes = "Returns user details by user ID")
    @GetMapping("/users/{id}")
    public User getUserById(
            @ApiParam(value = "ID of the user to fetch", required = true)
            @PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Kullanıcı Bulunamadı"));
    }
}
