package com.tsi.training.controller;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.entity.Customer;
import com.tsi.training.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    public List<Customer> createCustomers(@RequestBody List<CustomerDTO> customerDTOList)
    {
        return this.customerService.createCustomers(customerDTOList);
    }
}
