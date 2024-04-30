package com.tsi.training.controller;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/part")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;


    @PostMapping
    public List<Part> createParts(@RequestParam List<PartDTO> partDTOList)
    {
        return this.partService.createParts(partDTOList);
    }


    @GetMapping("/{description}")
    public ResponseEntity<Part> getPartByDescription(@PathVariable String description)
    {
        Optional<Part> part = this.partService.getPartByDescription(description);

        return part.map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }


}
