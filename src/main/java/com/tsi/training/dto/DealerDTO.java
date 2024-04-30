package com.tsi.training.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DealerDTO {

    private Long id;
    private String description;
}
