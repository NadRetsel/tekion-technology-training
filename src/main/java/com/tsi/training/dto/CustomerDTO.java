package com.tsi.training.dto;

import com.tsi.training.data.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String surname;
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private List<Contact> contact;

}
