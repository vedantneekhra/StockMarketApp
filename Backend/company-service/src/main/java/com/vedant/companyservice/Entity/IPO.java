package com.vedant.companyservice.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class IPO {

    @Id
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private Company company;

    private double PricePerShare;
    private long TotalShares;
    private Timestamp OpenDateTime;
    private String Remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getPricePerShare() {
        return PricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        PricePerShare = pricePerShare;
    }

    public long getTotalShares() {
        return TotalShares;
    }

    public void setTotalShares(long totalShares) {
        TotalShares = totalShares;
    }

    public Timestamp getOpenDateTime() {
        return OpenDateTime;
    }

    public void setOpenDateTime(Timestamp openDateTime) {
        OpenDateTime = openDateTime;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
