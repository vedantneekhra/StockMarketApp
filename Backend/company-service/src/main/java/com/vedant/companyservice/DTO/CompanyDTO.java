package com.vedant.companyservice.DTO;

import com.vedant.companyservice.Entity.CompanyEntity;
import lombok.Data;

@Data
public class CompanyDTO {

    private int id;
    private int sectorId;
    private int CEOId;
    private int BODId;
    private String name;
    private Double turnOver;

    public CompanyDTO(){

    }
    public CompanyDTO(CompanyEntity companyEntity){
        this.id = companyEntity.getId();
        this.sectorId = companyEntity.getSectorId();
        this.BODId = companyEntity.getBODId();
        this.CEOId = companyEntity.getCEOId();
        this.name = companyEntity.getName();
        this.turnOver = companyEntity.getTurnOver();
    }

}
