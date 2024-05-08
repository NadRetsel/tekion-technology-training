package com.tsi.training.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dealers")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Dealer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String description;
}
