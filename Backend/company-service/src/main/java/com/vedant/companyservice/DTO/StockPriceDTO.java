package com.vedant.companyservice.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StockPriceDTO {

    private int id;
    private String companyCode;
    private int companyId;
    private Timestamp record_time;
    private double price;

}
