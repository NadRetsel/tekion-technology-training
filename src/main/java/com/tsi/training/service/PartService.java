package com.tsi.training.service;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.mapper.PartMapper;
import com.tsi.training.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartService implements IPartService {

    private final PartRepository partRepository;
    private final PartMapper partMapper;


    public Optional<Part> getPartByDescription(String description) {
        return this.partRepository.findByDescription(description);
    }


    public List<Part> createParts(List<PartDTO> partDTOs) {
        return this.partMapper.toEntity(partDTOs);
    }

}
