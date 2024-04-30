package com.tsi.training.controller;

import com.tsi.training.dto.MainRequest;
import com.tsi.training.entity.Customer;
import com.tsi.training.entity.Dealer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final CustomerController customerController;
    private final DealerController dealerController;
    private final PartController partController;


    @PostMapping
    public void saveAll(@RequestBody MainRequest mainRequest)
    {
        log.info("{}", mainRequest);
        this.customerController.createCustomers(mainRequest.getCustomers());
        this.dealerController.createDealers(mainRequest.getDealers());
        this.partController.createParts(mainRequest.getParts());
    }

}
