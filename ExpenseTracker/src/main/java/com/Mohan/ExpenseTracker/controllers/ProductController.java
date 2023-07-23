package com.Mohan.ExpenseTracker.controllers;

import com.Mohan.ExpenseTracker.models.Product;
import com.Mohan.ExpenseTracker.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/fetchAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/productId/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/productId/{id}")
    public String deleteById(@PathVariable Integer id){
        return productService.deleteById(id);
    }
    @GetMapping("/productDate/{date}")
    public List<Product> getProductsByDate(@PathVariable LocalDate date){
        return productService.getProductsByDate(date);
    }

}
