package com.tsi.training.controller;

import com.tsi.training.dto.CustomerDTO;
import com.tsi.training.dto.DealerDTO;
import com.tsi.training.entity.Customer;
import com.tsi.training.entity.Dealer;
import com.tsi.training.service.CustomerService;
import com.tsi.training.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;


    public List<Dealer> createDealers(@RequestParam List<DealerDTO> dealerDTOList)
    {
        return this.dealerService.createDealers(dealerDTOList);
    }
}
