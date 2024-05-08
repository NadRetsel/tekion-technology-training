package com.tsi.training.entity;

import com.tsi.training.data.Contact;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
@Getter
@Setter
@RequiredArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Builder
@AllArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String firstName;
    private String surname;
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    @Type(type = "json") @Column(columnDefinition = "json") private List<Contact> contact;


}
