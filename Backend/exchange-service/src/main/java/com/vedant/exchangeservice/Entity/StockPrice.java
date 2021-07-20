package com.vedant.exchangeservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class StockPrice {

    @Id
    @GeneratedValue
    private long id;

    private String companyCode;
    private int companyId;
    private Timestamp recordTime;
    private double price;

    public StockPrice(){

    }

    public StockPrice(long id, String companyCode, int companyId, Timestamp recordTime, double price) {
        this.id = id;
        this.companyCode = companyCode;
        this.companyId = companyId;
        this.recordTime = recordTime;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
