package com.api.mychallengebackend.repositories;
import com.api.mychallengebackend.models.SectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SectorRepository extends JpaRepository<SectorModel, UUID>{
     boolean existsByName(String name);
}
