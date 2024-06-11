package edu.unimagdalena.api.model.mappers;

import edu.unimagdalena.api.model.dto.CarDTO;
import edu.unimagdalena.api.model.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    // Car -> CarDTO
    CarDTO carToCarDTO(Car car);

    // CarDTO -> Car
    @Mapping(target = "id", ignore = true)
    Car carDTOToCar(CarDTO carDTO);
}
