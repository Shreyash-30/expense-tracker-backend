package com.project.paytrack_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "name can't be empty")
    private String name;

    @Email(message ="invalid email")
    @NotBlank(message = "email can't be empty")
    private String email;
    @Min(1)
    private double income;
    @Min(1)

    private double budget;
    @Min(1)
    private double totalExpense;
}
