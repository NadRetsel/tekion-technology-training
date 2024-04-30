package com.tsi.training.service;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.entity.Customer;
import com.tsi.training.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;


    public List<Customer> createCustomers(List<CustomerDTO> customerDTOList)
    {
        return this.customerMapper.toEntity(customerDTOList);
    }
}
