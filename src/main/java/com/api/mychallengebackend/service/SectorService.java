package com.api.mychallengebackend.service;

import com.api.mychallengebackend.models.SectorModel;
import com.api.mychallengebackend.repositories.SectorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SectorService {
     final SectorRepository sectorRepository;

      public SectorService(SectorRepository sectorRepository){
          this.sectorRepository = sectorRepository;
      }

    @Transactional
    public SectorModel save(SectorModel sectorModel) {
        return sectorRepository.save(sectorModel);
    }

    public boolean existsByNameSector(String name) {
          return this.sectorRepository.existsByName(name);
    }
}
