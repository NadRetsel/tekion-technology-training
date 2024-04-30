package com.tsi.training.dto.request;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.dto.DealerDTO;
import com.tsi.training.dto.OrderDTO;
import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private List<OrderDTO> orders;
    private List<PartDTO> parts;
    private List<CustomerDTO> customers;
    private List<DealerDTO> dealers;
}
