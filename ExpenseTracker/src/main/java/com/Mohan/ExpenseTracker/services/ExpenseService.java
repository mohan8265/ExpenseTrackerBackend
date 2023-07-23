package com.Mohan.ExpenseTracker.services;

import com.Mohan.ExpenseTracker.models.Expense;
import com.Mohan.ExpenseTracker.models.Product;
import com.Mohan.ExpenseTracker.repositories.IExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private IExpenseRepo expenseRepo;
    @Autowired
    private ProductService productService;

    public String addExpense(Expense expense) {
        expenseRepo.save(expense);
        return "expense added";
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public String updateExpenseById(Integer id,Expense expense) {
        Expense existingExpense = expenseRepo.findById(id).orElse(null);
        if(existingExpense == null){
            return "not a valid expense id";
        }

        expenseRepo.save(expense);
        return "expense details updated";
    }

    public String deleteExpenseById(Integer id) {
        Expense existingExpense = expenseRepo.findById(id).orElse(null);
        if(existingExpense == null){
            return "not a valid expense id";
        }

        expenseRepo.delete(existingExpense);
        return "deleted successfully";
    }

    public String getExpenditureByMonth(Integer monthValue) {
        Long totalExpenditure = 0L;
        List<Product> productList = productService.getAllProducts();

        for(Product product:productList){
            if(product.getProductDate().getMonthValue() == monthValue){
                totalExpenditure += product.getProductPrice();
            }
        }
        return totalExpenditure.toString();
    }
}
