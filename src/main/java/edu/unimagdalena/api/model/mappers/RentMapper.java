package edu.unimagdalena.api.model.mappers;

import edu.unimagdalena.api.model.dto.RentDTO;
import edu.unimagdalena.api.model.dto_save.RentToSaveDTO;
import edu.unimagdalena.api.model.entities.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

@Mapper
public interface RentMapper {

    RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "car.id", target = "carId")
    RentDTO rentToRentDTO(Rent rent);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "carId", target = "car.id")
    Rent rentDTOToRent(RentDTO rentDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "carId", target = "car.id")
    @Mapping(target = "state", ignore = true)
    Rent rentToToSaveDTOToRent(RentToSaveDTO rentToSaveDTO);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "car.id", target = "carId")
    RentToSaveDTO rentToRentToSaveDTO(Rent rent);

}
