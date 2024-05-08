package com.tsi.training.entity;

import com.tsi.training.dto.PartDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parts")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Part {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String description;
    private Double price;


    public Part(PartDTO partDTO)
    {
        this.id = partDTO.getId();
        this.description = partDTO.getDescription();
        this.price = partDTO.getPrice();
    }

}
