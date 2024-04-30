package com.tsi.training.controller;

import com.tsi.training.dto.request.MainRequest;
import com.tsi.training.dto.response.MainResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final CustomerController customerController;
    private final DealerController dealerController;
    private final PartController partController;


    @PostMapping
    public MainResponse saveAll(@RequestBody MainRequest mainRequest)
    {
        log.info("Main - Saving {}", mainRequest);

        return MainResponse.builder()
                .customers(this.customerController.createCustomers(mainRequest.getCustomers()))
                .dealers(this.dealerController.createDealers(mainRequest.getDealers()))
                .parts(this.partController.createParts(mainRequest.getParts()))
                .build();
    }

}
