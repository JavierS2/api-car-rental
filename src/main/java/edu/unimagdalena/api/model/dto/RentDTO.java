package edu.unimagdalena.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RentDTO (
        Long id,

        @NotNull(message = "Car is mandatory")
        Long carId,

        @NotNull(message = "Customer is mandatory")
        Long customerId,

        @NotNull(message = "Start date is mandatory")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate startDate,

        @NotNull(message = "End date is mandatory")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate endDate,

        @NotNull(message = "Total price is mandatory")
        Float totalPrice
) { }
