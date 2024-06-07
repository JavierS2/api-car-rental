package edu.unimagdalena.api.model.dto_save;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerToSaveDTO (

        @NotNull(message = "Dni is mandatory")
        Long dni,

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Last name is mandatory")
        String lastName,

        @NotNull(message = "Phone number is mandatory")
        @Size(min = 10, max = 10, message = "Phone number must have 10 digits")
        Long phoneNumber,

        @NotBlank(message = "Address is mandatory")
        String address
) { }
