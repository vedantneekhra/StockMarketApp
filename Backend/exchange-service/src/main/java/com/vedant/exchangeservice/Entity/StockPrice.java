package com.vedant.exchangeservice.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class StockPrice {

    @Id
    @GeneratedValue
    private long id;

    private String companyCode;
    private int companyId;

    @ManyToOne(fetch = FetchType.EAGER)
    private StockExchangeEntity stockExchange;

    private Timestamp recordTime;
    private double price;

}
