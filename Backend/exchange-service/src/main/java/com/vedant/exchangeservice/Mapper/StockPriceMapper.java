package com.vedant.exchangeservice.Mapper;

import com.vedant.exchangeservice.DTO.StockPriceDTO;
import com.vedant.exchangeservice.Entity.StockPrice;

public class StockPriceMapper {

    public static StockPriceDTO doMap(StockPrice stockPrice){

        StockPriceDTO stockPriceDTO = new StockPriceDTO();
        stockPriceDTO.setPrice(stockPrice.getPrice());
        stockPriceDTO.setCompanyCode(stockPrice.getCompanyCode());
        stockPriceDTO.setCompanyId(stockPrice.getCompanyId());
        stockPriceDTO.setRecordTime(stockPrice.getRecordTime());
        stockPriceDTO.setId(stockPrice.getCompanyId());

        return stockPriceDTO;
    }
}
