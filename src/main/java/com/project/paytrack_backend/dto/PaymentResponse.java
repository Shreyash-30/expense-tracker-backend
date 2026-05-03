package com.project.paytrack_backend.dto;

import jakarta.validation.constraints.*;

public class PaymentResponse {
    private int id;


    @NotBlank(message="name can't be blank")
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    @Min(1) @Max(100)
    private String description;
    @NotBlank(message = "budget is must")
    @Min(1)
    private double budget;
}
