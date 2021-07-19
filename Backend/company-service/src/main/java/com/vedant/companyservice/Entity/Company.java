package com.vedant.companyservice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    private int id;
    private int sectorId;
    private int CEOId;
    private int BODId;
    private String name;
    private Double turnOver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int getCEOId() {
        return CEOId;
    }

    public void setCEOId(int CEOId) {
        this.CEOId = CEOId;
    }

    public int getBODId() {
        return BODId;
    }

    public void setBODId(int BODId) {
        this.BODId = BODId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(Double turnOver) {
        this.turnOver = turnOver;
    }
}
