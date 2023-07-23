package com.Mohan.ExpenseTracker.services;

import com.Mohan.ExpenseTracker.models.Product;
import com.Mohan.ExpenseTracker.repositories.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepo productRepo;


    public String addProduct(Product product) {
        productRepo.save(product);
        return "product added";
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    public String deleteById(Integer id) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct == null){
            return "product doesn't exit";
        }
        productRepo.deleteById(id);
        return "product deleted successfully";
    }

    public List<Product> getProductsByDate(LocalDate date) {
        List<Product> productList = productRepo.findByProductDate(date);
        return productList;
    }
}
