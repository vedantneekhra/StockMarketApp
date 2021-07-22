package com.vedant.sectorservice.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SectorEntity {

    @Id
    private int id;
    private String name;
    private String brief;
}
