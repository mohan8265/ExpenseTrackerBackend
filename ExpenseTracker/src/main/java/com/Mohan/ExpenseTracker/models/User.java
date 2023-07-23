package com.Mohan.ExpenseTracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private Integer userId;
    @NotBlank(message = "user name can't be empty")
    private String userName;
    @NotBlank(message = "mobile number can't be empty")
    private String userPhoneNumber;
    @Email(message = "not a valid email")
    @Column(unique = true)
    private String userEmail;
    @NotBlank(message = "password can't be empty")
    private String userPassword;
}

