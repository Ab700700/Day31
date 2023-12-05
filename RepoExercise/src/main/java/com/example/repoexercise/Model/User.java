package com.example.repoexercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5,message = "Name should be at least 5 characters")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 5,message = "Username should be at least 5 characters")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;
    @NotEmpty(message = "Password should not be empty")
    @Column(columnDefinition = "varchar(30) not null ")
    private String password;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Write a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "Role should not be empty")
    @Pattern(regexp = "user|admin", message = "Role should be user or admin")
    @Column(columnDefinition = "varchar(6) not null check(role = 'user' or role ='admin')")
    private String role;
    @NotNull(message = "Age should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
