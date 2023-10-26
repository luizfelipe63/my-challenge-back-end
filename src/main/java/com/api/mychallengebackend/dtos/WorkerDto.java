package com.api.mychallengebackend.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WorkerDto {
    @NotBlank
    private String name;
    @NotBlank
    @Size(min= 10 ,max = 14)
    private String CPF;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
