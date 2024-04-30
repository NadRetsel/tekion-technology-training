package com.tsi.training.controller;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.entity.Customer;
import com.tsi.training.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public List<Customer> createCustomers(@RequestBody List<CustomerDTO> customerDTOList)
    {
        return this.customerService.createCustomers(customerDTOList);
    }
}
