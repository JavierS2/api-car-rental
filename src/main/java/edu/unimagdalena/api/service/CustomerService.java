package edu.unimagdalena.api.service;

import edu.unimagdalena.api.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO update(CustomerDTO customerDTO, Long customerId);

    void delete(Long id);

    List<CustomerDTO> getAll();
}
