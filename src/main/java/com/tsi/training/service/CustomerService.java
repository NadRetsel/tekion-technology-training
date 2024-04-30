package com.tsi.training.service;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.entity.Customer;
import com.tsi.training.mapper.CustomerMapper;
import com.tsi.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public List<Customer> createCustomers(List<CustomerDTO> customerDTOList)
    {
        log.info("Customers - Saving to database {}", customerDTOList);
        return this.customerRepository.saveAll(
                this.customerMapper.toEntity(customerDTOList));
    }
}
