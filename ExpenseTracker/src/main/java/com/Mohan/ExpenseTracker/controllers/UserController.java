package com.Mohan.ExpenseTracker.controllers;

import com.Mohan.ExpenseTracker.models.Expense;
import com.Mohan.ExpenseTracker.models.User;
import com.Mohan.ExpenseTracker.models.dto.SignInInput;
import com.Mohan.ExpenseTracker.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public String signUp(@RequestBody @Valid User user){
        return userService.signUp(user);
    }
    @PostMapping("/signin")
    public String signIn(@RequestBody @Valid SignInInput signInInput){
        return userService.signIn(signInInput);
    }
    @PutMapping("/update")
    public String updateUser(@RequestParam String email,@RequestParam String tokenValue,@RequestBody @Valid User user){
        return userService.updateUser(email,tokenValue,user);
    }
    @DeleteMapping("/signout")
    public String signOut(@RequestParam String email,@RequestParam String tokenValue){
        return userService.signOut(email,tokenValue);
    }

    //expense related
    @PostMapping("/expense/add")
    public String addExpense(@RequestBody Expense expense,@RequestParam String email,@RequestParam String tokenValue){
        return userService.addExpense(expense,email,tokenValue);
    }
    @GetMapping("/expense/fetchAll")
    public List<Expense> getAllExpenses(@RequestParam String email,@RequestParam String tokenValue){
        return userService.getAllExpenses(email,tokenValue);
    }
    @PutMapping("/expense/expenseID/{id}")
    public String updateExpenseById(@PathVariable Integer id,@RequestBody Expense expense,@RequestParam String email,@RequestParam String tokenValue){
        return userService.updateExpenseById(id,expense,email,tokenValue);
    }
    @DeleteMapping("/expense/expenseId/{id}")
    public String deleteExpenseById(@PathVariable Integer id,@RequestParam String email,@RequestParam String tokenValue){
        return userService.deleteExpenseById(id,email,tokenValue);
    }
    @GetMapping("/expense/month/{monthValue}")
    public String getExpenditureByMonth(@PathVariable Integer monthValue,@RequestParam String email,@RequestParam String tokenValue){
        return userService.getExpenditureByMonth(monthValue,email,tokenValue);
    }

}
