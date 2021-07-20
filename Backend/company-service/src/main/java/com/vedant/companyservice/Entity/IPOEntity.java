package com.vedant.companyservice.Entity;

import com.vedant.companyservice.DTO.IPODTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
@Data
public class IPOEntity {

    @Id
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private CompanyEntity companyEntity;

    private double pricePerShare;
    private long totalShares;
    private Timestamp openDateTime;
    private String remark;

}
