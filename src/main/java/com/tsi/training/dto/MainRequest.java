package com.tsi.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainRequest {

    public List<PartDTO> parts;
    public List<CustomerDTO> customers;
    public List<DealerDTO> dealers;
}
