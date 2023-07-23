package com.Mohan.ExpenseTracker.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {
    @Email(message = "not a valid email")
    private String signinEmail;
    @NotBlank(message = "password can't be empty")
    private String signinPassword;
}
