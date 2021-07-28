package com.vedant.exchangeservice.DTO;

import lombok.Data;

@Data
public class StockExchangeDTO {
    private int id;
    private String brief;
    private int contactAddressId;
    private String name;
    private String remarks;
}
