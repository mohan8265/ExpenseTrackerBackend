package com.Mohan.ExpenseTracker.repositories;

import com.Mohan.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findByUserEmail(String userEmail);
}
