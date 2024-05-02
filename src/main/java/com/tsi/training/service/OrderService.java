package com.tsi.training.service;


import com.tsi.training.data.PartId;
import com.tsi.training.dto.OrderDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.json.JSONata;
import com.tsi.training.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final PartRepository partRepository;
    private final JSONata jsonata = new JSONata();


    public void sendKafkaTopic()
    {
        log.info("Orders - Sending Message topic from Order");
        kafkaTemplate.send("Message", "ProcessOrders");
    }


    public void processOrders(List<OrderDTO> orderDTOList)
    {
        for(OrderDTO orderDTO : orderDTOList)
        {
            orderDTO.setPartIds(validateOrderParts(orderDTO));
        }

        //this.jsonata.execute();
    }


    private List<PartId> validateOrderParts(OrderDTO orderDTO)
    {
        List<PartId> validPartIdList = new LinkedList<>(orderDTO.getPartIds());

        for(PartId partId : orderDTO.getPartIds())
        {
            if(partRepository.findById(partId.getId()).isEmpty())
            {
                log.info("Orders - Invalid Part ID {}", partId.getId());
                validPartIdList.remove(partId);
                continue;
            }

            log.info("Orders - Valid Part ID {}", partId.getId());
        }
        return validPartIdList;
    }



}
