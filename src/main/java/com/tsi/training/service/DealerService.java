package com.tsi.training.service;

import com.tsi.training.dto.DealerDTO;
import com.tsi.training.entity.Dealer;
import com.tsi.training.mapper.DealerMapper;
import com.tsi.training.mapper.EntityMapper;
import com.tsi.training.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealerService {

    private final DealerRepository dealerRepository;
    private final EntityMapper<Dealer, DealerDTO> dealerMapper;


    public List<Dealer> createDealers(List<DealerDTO> dealerDTOList)
    {
        log.info("Dealers - Saving to database {}", dealerDTOList);
        return this.dealerRepository.saveAll(
                this.dealerMapper.toEntity(dealerDTOList));
    }
}
