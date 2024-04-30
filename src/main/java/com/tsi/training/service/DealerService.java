package com.tsi.training.service;

import com.tsi.training.dto.DealerDTO;
import com.tsi.training.entity.Dealer;
import com.tsi.training.mapper.DealerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerMapper dealerMapper;


    public List<Dealer> createDealers(List<DealerDTO> dealerDTOList)
    {
        return this.dealerMapper.toEntity(dealerDTOList);
    }
}
