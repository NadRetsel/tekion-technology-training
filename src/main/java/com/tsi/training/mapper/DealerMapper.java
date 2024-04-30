package com.tsi.training.mapper;

import com.tsi.training.entity.Dealer;
import com.tsi.training.dto.DealerDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class DealerMapper implements BaseEntityMapper<DealerDTO, Dealer> {

    @Override
    public Dealer toEntity(DealerDTO dto) {
        return Dealer.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public DealerDTO toDto(Dealer entity) {
        return DealerDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public List<Dealer> toEntity(List<DealerDTO> dtoList) {
        return dtoList.stream()
                .map(this :: toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DealerDTO> toDto(List<Dealer> entityList) {
        return entityList.stream()
                .map(this :: toDto)
                .collect(Collectors.toList());
    }
}
