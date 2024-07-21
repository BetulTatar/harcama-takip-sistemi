package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String user_name;
     private String password;

     @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;


}
