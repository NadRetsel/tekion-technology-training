package com.tsi.training.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dealers")
@Getter
@Setter
@RequiredArgsConstructor
public class Dealer {

    @Id private Long id;
    private String description;
}
