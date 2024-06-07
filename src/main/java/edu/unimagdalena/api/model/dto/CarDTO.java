package edu.unimagdalena.api.model.dto;

import java.time.LocalDate;

public record CarDTO (
    Long id,
    String name,
    String model,
    Integer year,
    String location,
    Float pricePerDay,
    LocalDate endDateAvailable
) { }
