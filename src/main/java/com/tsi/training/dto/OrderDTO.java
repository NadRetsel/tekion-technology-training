package com.tsi.training.dto;

import com.tsi.training.data.PartId;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private List<PartId> partIds;
    private Long customerId;
    private Long dealerId;

}
