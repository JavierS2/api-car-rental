package edu.unimagdalena.api.model.dto;

import edu.unimagdalena.api.model.entities.State;

import java.time.LocalDate;

public record RentDTO (
    Long id,
    Long customerId,
    Long carId,
    LocalDate startDate,
    LocalDate endDate,
    State state,
    Float totalPrice
) { }
