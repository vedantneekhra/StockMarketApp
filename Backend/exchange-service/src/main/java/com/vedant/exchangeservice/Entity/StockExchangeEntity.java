package com.vedant.exchangeservice.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="stock_exchange")
public class StockExchangeEntity {
    @Id
    private int id;
    private String brief;
    private int contactAddressId;
    private String name;
    private String remarks;
}
