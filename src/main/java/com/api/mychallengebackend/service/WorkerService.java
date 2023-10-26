package com.api.mychallengebackend.service;

import com.api.mychallengebackend.models.WorkerModel;
import com.api.mychallengebackend.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class WorkerService {
    final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }
    @Transactional
    public WorkerModel save(WorkerModel workerModel) {
       return this.workerRepository.save(workerModel);
    }

    public boolean existsByCPF(String cpf) {
        return this.workerRepository.existsByCPF(cpf);
    }
}
