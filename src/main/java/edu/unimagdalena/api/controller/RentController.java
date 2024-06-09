package edu.unimagdalena.api.controller;

import edu.unimagdalena.api.exceptions.ResourceNotAbleToDeleteException;
import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.RentDTO;
import edu.unimagdalena.api.service.RentService;
import edu.unimagdalena.api.service.RentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController {

    private final RentServiceImpl rentService;

    public RentController(RentServiceImpl rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public ResponseEntity<RentDTO> create(@Valid @RequestBody RentDTO rentDTO) {
        RentDTO newRent = rentService.create(rentDTO);
        return ResponseEntity.ok(newRent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentDTO> update(@PathVariable Long id, @Valid @RequestBody RentDTO rentDTO) {
        try {
            RentDTO updatedRent = rentService.update(rentDTO, id);
            return ResponseEntity.ok(updatedRent);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            rentService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RentDTO>> getAll() {
        List<RentDTO> rents = rentService.getAllRents();
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentDTO> getRentById(@PathVariable Long id) {
        try {
            RentDTO rent = rentService.getRentById(id);
            return ResponseEntity.ok(rent);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
