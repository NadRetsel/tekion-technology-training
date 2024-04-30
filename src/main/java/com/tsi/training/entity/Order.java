package com.tsi.training.entity;

import com.tsi.training.data.PartId;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@RequiredArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Builder @AllArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)     private Long id;
    @Temporal(TemporalType.TIMESTAMP)                       private Date orderDate;
    @Type(type = "json") @Column(columnDefinition = "json") private List<PartId> partIds;
    private Long customerId;
    private Long dealerId;


}
