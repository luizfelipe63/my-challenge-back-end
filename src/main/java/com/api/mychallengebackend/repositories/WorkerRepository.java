package com.api.mychallengebackend.repositories;

import com.api.mychallengebackend.models.WorkerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, UUID> {
    boolean existsByCPF(String cpf);
}
