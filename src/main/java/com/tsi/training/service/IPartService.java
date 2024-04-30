package com.tsi.training.service;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;

import java.util.List;
import java.util.Optional;

public interface IPartService {
    Optional<Part> getPartByDescription(String description);

    List<Part> createParts(List<PartDTO>parts);
}
