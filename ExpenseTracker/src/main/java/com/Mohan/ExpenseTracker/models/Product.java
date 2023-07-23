package com.Mohan.ExpenseTracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productTitle;
    private String productDescription;
    private Long productPrice;
    private LocalDate productDate;
    private String productTime;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

}
