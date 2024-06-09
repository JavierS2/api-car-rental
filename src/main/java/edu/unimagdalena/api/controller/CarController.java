package edu.unimagdalena.api.controller;

import edu.unimagdalena.api.exceptions.ResourceNotAbleToDeleteException;
import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.CarDTO;
import edu.unimagdalena.api.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@Valid @RequestBody CarDTO carDTO) {
        CarDTO newCar = carService.create(carDTO);
        return ResponseEntity.ok(newCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(@PathVariable Long id, @Valid @RequestBody CarDTO carDTO) {
        try {
            CarDTO updatedCar = carService.update(carDTO, id);
            return ResponseEntity.ok(updatedCar);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            carService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        List<CarDTO> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        try {
            CarDTO car = carService.getCarById(id);
            return ResponseEntity.ok(car);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
