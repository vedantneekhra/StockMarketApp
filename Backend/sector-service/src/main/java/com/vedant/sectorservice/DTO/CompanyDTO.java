package com.vedant.sectorservice.DTO;

import lombok.Data;

@Data
public class CompanyDTO {

    private int id;
    private int sectorId;
    private int CEOId;
    private int BODId;
    private int stockExchangeId;
    private String name;
    private Double turnOver;

    public CompanyDTO(){

    }

}
