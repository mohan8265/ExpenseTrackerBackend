package com.Mohan.ExpenseTracker.repositories;

import com.Mohan.ExpenseTracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpenseRepo extends JpaRepository<Expense,Integer> {
}
