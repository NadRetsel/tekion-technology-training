package com.tsi.training.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartDTO {

    private Long id;
    private String description;
    private Double price;
}
