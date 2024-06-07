package edu.unimagdalena.api.model.dto;

public record CustomerDTO (
    Long id,
    Long dni,
    String name,
    String lastName,
    Long phoneNumber,
    String address
) { }
