package edu.unimagdalena.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record CarDTO (
        Long id,

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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate endDateAvailable
) { }
