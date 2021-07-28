package com.vedant.exchangeservice.Mapper;

import com.vedant.exchangeservice.DTO.StockExchangeDTO;
import com.vedant.exchangeservice.Entity.StockExchangeEntity;

public class StockExchangeMapper {
    public static StockExchangeDTO convertToDTO(StockExchangeEntity stockExchangeEntity){
        StockExchangeDTO s = new StockExchangeDTO();

        s.setId(stockExchangeEntity.getId());
        s.setName(stockExchangeEntity.getName());
        s.setBrief(stockExchangeEntity.getBrief());
        s.setContactAddressId(stockExchangeEntity.getContactAddressId());
        s.setRemarks(stockExchangeEntity.getRemarks());

        return s;
    }

    public static StockExchangeEntity convertToEntity(StockExchangeDTO stockExchangeDTO) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();

        stockExchangeEntity.setId(stockExchangeDTO.getId());
        stockExchangeEntity.setName(stockExchangeDTO.getName());
        stockExchangeEntity.setBrief(stockExchangeDTO.getBrief());
        stockExchangeEntity.setContactAddressId(stockExchangeEntity.getContactAddressId());
        stockExchangeEntity.setRemarks(stockExchangeDTO.getRemarks());

        return stockExchangeEntity;
    }
}
