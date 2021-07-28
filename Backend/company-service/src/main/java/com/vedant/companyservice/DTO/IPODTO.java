package com.vedant.companyservice.DTO;

import com.vedant.companyservice.Entity.CompanyEntity;
import com.vedant.companyservice.Entity.IPOEntity;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

public class IPODTO {
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private CompanyEntity company;

    private double pricePerShare;
    private long totalShares;
    private Timestamp openDateTime;
    private String remark;

    public IPODTO(IPOEntity ipoEntity){
        this.id = ipoEntity.getId();
        this.company = ipoEntity.getCompany();
        this.openDateTime = ipoEntity.getOpenDateTime();
        this.pricePerShare = ipoEntity.getPricePerShare();
        this.totalShares = ipoEntity.getTotalShares();
        this.remark = ipoEntity.getRemark();
    }
}
