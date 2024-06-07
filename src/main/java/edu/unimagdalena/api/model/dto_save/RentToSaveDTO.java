package edu.unimagdalena.api.model.dto_save;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RentToSaveDTO (

        @NotNull(message = "Car is mandatory")
        Long carId,

        @NotNull(message = "Customer is mandatory")
        Long customerId,

        @NotNull(message = "Start date is mandatory")
        LocalDate startDate,

        @NotNull(message = "End date is mandatory")
        LocalDate endDate,

        @NotNull(message = "Total price is mandatory")
        Float totalPrice

) { }
