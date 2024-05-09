package com.tsi.training.service;


import com.tsi.training.data.PartId;
import com.tsi.training.dto.OrderDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    @Value("${spring.kafka.template.topics}") private final String[] topics;
    private final String[] messages = {
            "First message",
            "Second message"
    };
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final PartRepository partRepository;


    public void sendKafkaTopic()
    {
        log.info("Sending message \"{}\" from topic [{}]", this.messages[0], this.topics[0]);
        kafkaTemplate.send(this.topics[0], "First message");

        log.info("Sending message \"{}\" from topic [{}]", this.messages[1], this.topics[1]);
        kafkaTemplate.send(this.topics[1], "Second message");
    }


    public void processOrders(List<OrderDTO> orderDTOList)
    {
        for(OrderDTO orderDTO : orderDTOList)
        {
            orderDTO.setPartIds(validateOrderParts(orderDTO));
        }
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
