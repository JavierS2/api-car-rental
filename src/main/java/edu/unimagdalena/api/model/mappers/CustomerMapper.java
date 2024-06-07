package edu.unimagdalena.api.model.mappers;

import edu.unimagdalena.api.model.dto.CustomerDTO;
import edu.unimagdalena.api.model.dto_save.CustomerToSaveDTO;
import edu.unimagdalena.api.model.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO CustomerToCustomerDTO(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rents", ignore = true)
    Customer CustomerDTOToCustomer(CustomerDTO customerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rents", ignore = true)
    Customer CustomerDTOToCustomer(CustomerToSaveDTO customerToSaveDTO);

    CustomerToSaveDTO CustomerToCustomerToSaveDTO(Customer customer);

}
