package edu.unimagdalena.api.service;

import edu.unimagdalena.api.model.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO create(CarDTO carDTO);

    CarDTO getCarById(Long id);

    CarDTO update(CarDTO carDTO, Long id);

    void delete(Long id);

    List<CarDTO> getAllCars();
}
