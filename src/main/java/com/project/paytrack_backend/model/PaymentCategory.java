package com.project.paytrack_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class PaymentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double budget;
    private double totalExpense;
    private double maxExpense;



    @OneToMany(mappedBy = "payments")
    private List<Expense> expenses;


}
