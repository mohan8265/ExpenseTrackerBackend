package com.Mohan.ExpenseTracker.repositories;

import com.Mohan.ExpenseTracker.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByProductDate(LocalDate date);
}
