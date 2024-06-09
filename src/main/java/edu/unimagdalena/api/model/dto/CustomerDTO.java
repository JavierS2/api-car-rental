package edu.unimagdalena.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerDTO (
        Long id,

        @NotNull(message = "Dni is mandatory")
        Long dni,

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Last name is mandatory")
        String lastName,

        @NotNull(message = "Phone number is mandatory")
        Long phoneNumber,

        @NotBlank(message = "Address is mandatory")
        String address
) { }
