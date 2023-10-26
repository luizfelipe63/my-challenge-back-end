package com.api.mychallengebackend.dtos;

import javax.validation.constraints.NotBlank;

public class SectorDto {

    @NotBlank
    private String nameSector;

    public String getNameSector() {
        return nameSector;
    }

    public void setNameSector(String nameSector) {
        this.nameSector = nameSector;
    }
}
