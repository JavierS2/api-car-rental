package edu.unimagdalena.api.service;

import edu.unimagdalena.api.exceptions.ResourceNotAbleToDeleteException;
import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.RentDTO;
import edu.unimagdalena.api.model.entities.Car;
import edu.unimagdalena.api.model.entities.Rent;
import edu.unimagdalena.api.model.mappers.RentMapper;
import edu.unimagdalena.api.repository.CarRepository;
import edu.unimagdalena.api.repository.CustomerRepository;
import edu.unimagdalena.api.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    private final CustomerRepository customerRepository;

    private final CarRepository carRepository;

    private final RentRepository rentRepository;

    public RentServiceImpl(CustomerRepository customerRepository, CarRepository carRepository, RentRepository rentRepository) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.rentRepository = rentRepository;
    }

    @Override
    public RentDTO create(RentDTO rentDTO) {
        Rent rent = RentMapper.INSTANCE.rentDTOToRent(rentDTO, customerRepository, carRepository);
        Rent rentSaved = rentRepository.save(rent);
        return RentMapper.INSTANCE.rentToRentDTO(rentSaved);
    }

    @Override
    public RentDTO getRentById(Long id) {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found"));
        return RentMapper.INSTANCE.rentToRentDTO(rent);
    }

    @Override
    public RentDTO update(RentDTO rentDTO, Long id) {
        Rent rentInDb = rentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rent to update not found"));

        rentInDb.setStartDate(rentDTO.startDate());
        rentInDb.setEndDate(rentDTO.endDate());
        rentInDb.setTotalPrice(rentDTO.totalPrice());

        rentInDb.setCar(carRepository.findById(rentDTO.carId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found")));

        rentInDb.setCustomer(customerRepository.findById(rentDTO.customerId())
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found")));

        rentRepository.save(rentInDb);
        return RentMapper.INSTANCE.rentToRentDTO(rentInDb);
    }

    @Override
    public void delete(Long id) {
        Rent rent = rentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotAbleToDeleteException("Rent not found"));
        rentRepository.delete(rent);
    }

    @Override
    public List<RentDTO> getAllRents() {
        List<Rent> rents = rentRepository.findAll();
        return rents.stream()
                .map(RentMapper.INSTANCE::rentToRentDTO)
                .toList();
    }
}
