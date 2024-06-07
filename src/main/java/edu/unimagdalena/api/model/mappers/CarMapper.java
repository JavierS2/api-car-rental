package edu.unimagdalena.api.model.mappers;

import edu.unimagdalena.api.model.dto.CarDTO;
import edu.unimagdalena.api.model.dto_save.CarToSaveDTO;
import edu.unimagdalena.api.model.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    // Car -> CarDTO
    CarDTO carToCarDTO(Car car);

    // CarDTO -> Car
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rents", ignore = true)
    Car carDTOToCar(CarDTO carDTO);

    // Car -> CarToSaveDTO
    CarToSaveDTO carToCarToSaveDTO(Car car);

    // CarToSaveDTO -> Car
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rents", ignore = true)
    Car carToCar(CarToSaveDTO carToSaveDTO);

}
