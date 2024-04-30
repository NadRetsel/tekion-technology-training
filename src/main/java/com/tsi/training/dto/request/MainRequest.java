package com.tsi.training.dto.request;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.dto.DealerDTO;
import com.tsi.training.dto.PartDTO;
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
