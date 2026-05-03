package com.project.paytrack_backend.dto;

import com.project.paytrack_backend.model.User;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PaymentRequest {

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
