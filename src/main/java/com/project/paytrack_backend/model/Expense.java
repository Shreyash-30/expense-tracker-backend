package com.project.paytrack_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double amount;
    private LocalDate date;


    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="payment_id")
    private PaymentCategory payments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
