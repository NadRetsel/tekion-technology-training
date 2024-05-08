package com.tsi.training.mapper;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;


public class PartMapper implements EntityMapper<Part, PartDTO> {

    @Override
    public Part toEntity(PartDTO dto) {
        return Part.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }

    @Override
    public PartDTO toDto(Part entity) {
        return PartDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public List<Part> toEntity(List<PartDTO> dtoList) {
        return dtoList.stream()
                .map(this :: toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartDTO> toDto(List<Part> entityList) {
        return entityList.stream()
                .map(this :: toDto)
                .collect(Collectors.toList());
    }
}
