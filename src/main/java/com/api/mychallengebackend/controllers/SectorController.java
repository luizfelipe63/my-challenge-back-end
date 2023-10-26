package com.api.mychallengebackend.controllers;


import com.api.mychallengebackend.dtos.SectorDto;
import com.api.mychallengebackend.models.SectorModel;
import com.api.mychallengebackend.service.SectorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;


@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
@RequestMapping("/sector")
public class SectorController {

    final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid SectorDto sectorDto) {
        if(sectorService.existsByNameSector(sectorDto.getNameSector())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Sector already registered under this name!");
        }


        var sectorModel = new SectorModel();
        BeanUtils.copyProperties(sectorDto, sectorModel);
        sectorModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.save(sectorModel));
    }
}
