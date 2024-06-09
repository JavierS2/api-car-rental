package edu.unimagdalena.api.service;

import edu.unimagdalena.api.exceptions.ResourceNotAbleToDeleteException;
import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.CarDTO;
import edu.unimagdalena.api.model.entities.Car;
import edu.unimagdalena.api.model.mappers.CarMapper;
import edu.unimagdalena.api.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        Car carSaved = carRepository.save(car);
        return CarMapper.INSTANCE.carToCarDTO(carSaved);
    }

    @Override
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        return  CarMapper.INSTANCE.carToCarDTO(car);
    }

    @Override
    public CarDTO update(CarDTO carDTO, Long id) {
        Car carInDb = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car to update not found"));

        carInDb.setName(carDTO.name());
        carInDb.setModel(carDTO.model());
        carInDb.setYear(carDTO.year());
        carInDb.setLocation(carDTO.location());
        carInDb.setPricePerDay(carDTO.pricePerDay());
        carInDb.setEndDateAvailable(carDTO.endDateAvailable());

        carRepository.save(carInDb);
        return CarMapper.INSTANCE.carToCarDTO(carInDb);
    }

    @Override
    public void delete(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotAbleToDeleteException("Car not found, not able to delete"));
        carRepository.delete(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper.INSTANCE::carToCarDTO)
                .toList();
    }
}
