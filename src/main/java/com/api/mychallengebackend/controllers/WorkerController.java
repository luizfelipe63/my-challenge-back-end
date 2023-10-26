package com.api.mychallengebackend.controllers;

import com.api.mychallengebackend.dtos.WorkerDto;
import com.api.mychallengebackend.models.WorkerModel;
import com.api.mychallengebackend.service.SectorService;
import com.api.mychallengebackend.service.WorkerService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
@RequestMapping("/worker")
public class WorkerController {

    final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid WorkerDto workerDto) {
        if(workerService.existsByCPF(workerDto.getCPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF já existente!");
        }


        var workerModel = new WorkerModel();
        BeanUtils.copyProperties(workerDto, workerModel);
        workerModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(workerService.save(workerModel));
    }

}
