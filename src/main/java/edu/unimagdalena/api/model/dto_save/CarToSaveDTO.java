package edu.unimagdalena.api.model.dto_save;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CarToSaveDTO (

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Model is mandatory")
        String model,

        @NotNull(message = "Year is mandatory")
        @Positive
        Integer year,

        @NotBlank(message = "Location is mandatory")
        String location,

        @NotNull(message = "Price per day is mandatory")
        @Positive
        Float pricePerDay,

        @NotNull(message = "End date available is mandatory")
        LocalDate endDateAvailable
) { }
