package edu.unimagdalena.api.service;

import edu.unimagdalena.api.model.dto.RentDTO;

import java.util.List;

public interface RentService {
    RentDTO create(RentDTO rentDTO);

    RentDTO getRentById(Long id);

    RentDTO update(RentDTO rentDTO, Long id);

    void delete(Long id);

    List<RentDTO> getAllRents();
}
