package edu.unimagdalena.api.model.mappers;

import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.RentDTO;
import edu.unimagdalena.api.model.entities.Rent;
import edu.unimagdalena.api.repository.CarRepository;
import edu.unimagdalena.api.repository.CustomerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentMapper {
    RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "car.id", target = "carId")
    RentDTO rentToRentDTO(Rent rent);

    default Rent rentDTOToRent(RentDTO rentDTO, CustomerRepository customerRepository, CarRepository carRepository) {
        if (rentDTO == null) return null;

        Rent rent = new Rent();
        rent.setId(rentDTO.id());
        rent.setStartDate(rentDTO.startDate());
        rent.setEndDate(rentDTO.endDate());
        rent.setTotalPrice(rentDTO.totalPrice());

        Long carId = rentDTO.carId();
        rent.setCar(carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found")));

        Long customerId = rentDTO.customerId();
        rent.setCustomer(customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found")));

        return rent;
    }
}
