package com.Mohan.ExpenseTracker.repositories;

import com.Mohan.ExpenseTracker.models.AuthenticationToken;
import com.Mohan.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User existingUser);
}
