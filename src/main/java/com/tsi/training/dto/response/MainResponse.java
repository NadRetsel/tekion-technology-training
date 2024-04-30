package com.tsi.training.dto.response;

import com.tsi.training.entity.Customer;
import com.tsi.training.entity.Dealer;
import com.tsi.training.entity.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainResponse {

    public List<Part> parts;
    public List<Customer> customers;
    public List<Dealer> dealers;
}
