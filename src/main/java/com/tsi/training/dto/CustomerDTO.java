package com.tsi.training.dto;

import com.tsi.training.data.Contact;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String surname;
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private Contact contact;

}
