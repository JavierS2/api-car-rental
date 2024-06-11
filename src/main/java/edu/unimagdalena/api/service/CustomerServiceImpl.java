package edu.unimagdalena.api.service;

import edu.unimagdalena.api.exceptions.ResourceNotFoundException;
import edu.unimagdalena.api.model.dto.CustomerDTO;
import edu.unimagdalena.api.model.entities.Customer;
import edu.unimagdalena.api.model.mappers.CustomerMapper;
import edu.unimagdalena.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.CustomerDTOToCustomer(customerDTO);
        Customer customerSaved = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.CustomerToCustomerDTO(customerSaved);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return CustomerMapper.INSTANCE.CustomerToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO, Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer to update not found"));

        customer.setName(customerDTO.name());
        customer.setLastName(customerDTO.lastName());
        customer.setPhoneNumber(customerDTO.phoneNumber());
        customer.setAddress(customerDTO.address());
        customer.setDni(customerDTO.dni());

        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.CustomerToCustomerDTO(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found, not able to delete"));
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper.INSTANCE::CustomerToCustomerDTO)
                .toList();
    }
}
