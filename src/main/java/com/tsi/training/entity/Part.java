package com.tsi.training.entity;

import com.tsi.training.dto.PartDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
@Getter
@Setter
public class Part {

    @Id private Long id;
    private String description;
    private Double price;


    public Part(PartDTO partDTO)
    {
        this.id = partDTO.getId();
        this.description = partDTO.getDescription();
        this.price = partDTO.getPrice();
    }

}
