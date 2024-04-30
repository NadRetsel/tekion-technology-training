package com.tsi.training.controller;


import com.tsi.training.dto.request.OrderRequest;
import com.tsi.training.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/kafka")
    public void sendKafkaTopic()
    {
        this.orderService.sendKafkaTopic();
    }


    @PostMapping("/process")
    public void processOrder(@RequestBody OrderRequest orderRequest)
    {
        log.info("Orders - {}", orderRequest);
        this.orderService.processOrders(orderRequest.getOrders());
    }


}
