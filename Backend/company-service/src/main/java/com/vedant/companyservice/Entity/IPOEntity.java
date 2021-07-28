package com.vedant.companyservice.Entity;

import com.vedant.companyservice.DTO.IPODTO;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="ipo")
public class IPOEntity {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyEntity company;

    private double pricePerShare;
    private long totalShares;
    private int stockExchangeId;
    private Timestamp openDateTime;
    private String remark;

}
