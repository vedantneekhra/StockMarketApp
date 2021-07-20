package com.vedant.companyservice.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CompanyEntity {

    @Id
    private int id;
    private int sectorId;
    private int CEOId;
    private int BODId;
    private String name;
    private Double turnOver;
}
