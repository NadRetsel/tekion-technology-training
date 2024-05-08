package com.tsi.training.service;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.mapper.EntityMapper;
import com.tsi.training.mapper.PartMapper;
import com.tsi.training.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartService {

    private final PartRepository partRepository;
    private final EntityMapper<Part, PartDTO> partMapper = new PartMapper();


    public Optional<Part> getPartByDescription(String description) {
        return this.partRepository.findByDescription(description);
    }


    public List<Part> createParts(List<PartDTO> partDTOList)
    {
        log.info("Parts - Saving to database {}", partDTOList);
        return this.partRepository.saveAll(this.partMapper.toEntity(partDTOList));
    }

}
