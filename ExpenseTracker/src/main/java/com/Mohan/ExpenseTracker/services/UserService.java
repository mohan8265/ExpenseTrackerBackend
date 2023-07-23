package com.Mohan.ExpenseTracker.services;

import com.Mohan.ExpenseTracker.models.AuthenticationToken;
import com.Mohan.ExpenseTracker.models.Expense;
import com.Mohan.ExpenseTracker.models.User;
import com.Mohan.ExpenseTracker.models.dto.SignInInput;
import com.Mohan.ExpenseTracker.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private AuthTokenService authTokenService;
    @Autowired
    private ExpenseService expenseService;

    public String signUp(User user) {
        User existingUser = userRepo.findByUserEmail(user.getUserEmail());
        if (existingUser != null){
            return "This Email already registered";
        }

        String encryptedPassword = user.getUserPassword();
        encryptedPassword = "##" + encryptedPassword + "##";
        user.setUserPassword(encryptedPassword);
        userRepo.save(user);
        return "registered successfully";
    }

    public String signIn(SignInInput signInInput) {
        User existingUser = userRepo.findByUserEmail(signInInput.getSigninEmail());
        if (existingUser == null){
            return "sign up first";
        }

        String encryptedPassword = signInInput.getSigninPassword();
        encryptedPassword = "##" + encryptedPassword + "##";
        if(!encryptedPassword.equals(existingUser.getUserPassword())){
            return "wrong password";
        }
        AuthenticationToken token = authTokenService.getTokenByUser(existingUser);
        if(token != null){
            return "already signin";
        }
        String tokenValue = authTokenService.addToken(existingUser);
        return "signed in successfully for token value is: " +tokenValue;

    }

    public String updateUser(String email, String tokenValue, User user) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }
        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "sign in first";
        }

        String encryptedPassword = user.getUserPassword();
        encryptedPassword = "##" + encryptedPassword + "##";
        user.setUserPassword(encryptedPassword);
        user.setUserEmail(email);
        userRepo.save(user);
        return "user's information updated";
    }

    public String signOut(String email, String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }
        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "sign in first";
        }

        authTokenService.removeToken(existingToken);
        return "sign out successfully";
    }

    public String addExpense(Expense expense,String email,String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }

        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "provide a valid Token value";
        }
        expense.setUser(existingUser);
        return expenseService.addExpense(expense);

    }

    public List<Expense> getAllExpenses(String email, String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            throw new IllegalStateException("provide a registered email");
        }

        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            throw new IllegalStateException("provide a valid Token value");
        }

        return expenseService.getAllExpenses();
    }

    public String updateExpenseById(Integer id,Expense expense, String email, String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }

        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "provide a valid Token value";
        }

        return expenseService.updateExpenseById(id,expense);
    }

    public String deleteExpenseById(Integer id,String email,String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }

        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "provide a valid Token value";
        }
        return expenseService.deleteExpenseById(id);
    }

    public String getExpenditureByMonth(Integer monthValue, String email, String tokenValue) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "provide a registered email";
        }

        AuthenticationToken existingToken = authTokenService.getTokenByUser(existingUser);
        if(existingToken == null || !existingToken.getTokenValue().equals(tokenValue)){
            return "provide a valid Token value";
        }

        return expenseService.getExpenditureByMonth(monthValue);
    }
}
