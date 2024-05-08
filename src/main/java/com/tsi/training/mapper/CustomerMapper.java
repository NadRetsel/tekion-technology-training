package com.tsi.training.mapper;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;


public class CustomerMapper implements EntityMapper<Customer, CustomerDTO> {

    @Override
    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .surname(dto.getSurname())
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .contact(dto.getContact())
                .postCode(dto.getPostCode())
                .build();
    }

    @Override
    public CustomerDTO toDto(Customer entity) {
        return CustomerDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .surname(entity.getSurname())
                .addressLine1(entity.getAddressLine1())
                .addressLine2(entity.getAddressLine2())
                .postCode(entity.getPostCode())
                .contact(entity.getContact())
                .build();
    }

    @Override
    public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        return dtoList.stream()
                .map(this :: toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> toDto(List<Customer> entityList) {
        return entityList.stream()
                .map(this :: toDto)
                .collect(Collectors.toList());
    }
}
