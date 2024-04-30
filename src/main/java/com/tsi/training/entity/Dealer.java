package com.tsi.training.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dealers")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Dealer {

    @Id private Long id;
    private String description;
}
