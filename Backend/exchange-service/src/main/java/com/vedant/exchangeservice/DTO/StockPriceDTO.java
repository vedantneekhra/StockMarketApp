package com.vedant.exchangeservice.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StockPriceDTO {

    private int id;
    private String companyCode;
    private int companyId;
    private Timestamp recordTime;
    private double price;

}
