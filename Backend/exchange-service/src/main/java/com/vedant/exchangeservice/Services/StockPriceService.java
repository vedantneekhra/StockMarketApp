package com.vedant.exchangeservice.Services;

import com.vedant.exchangeservice.DTO.StockPriceDTO;
import com.vedant.exchangeservice.Entity.StockPrice;
import com.vedant.exchangeservice.Mapper.StockPriceMapper;
import com.vedant.exchangeservice.Repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    public double getCurrentPriceByCode(int stockExchangeId, String companyCode){
        List<StockPrice> lst = stockPriceRepository.findByStockExchangeAndCompanyCode(stockExchangeId, companyCode);
        if(lst.isEmpty()){
            throw new NullPointerException("Company not found!");
        }

        Optional<StockPrice> max = lst.stream().max((o1, o2) -> {
            return o1.getRecordTime().compareTo(o2.getRecordTime());
        });

        return max.get().getPrice();
    }

    public double getPriceByStockExchangeAndCode(int stockExchangeId, String companyCode, Timestamp time){
        Optional<StockPrice> optional = stockPriceRepository.findByStockExchangeAndCompanyCodeAndRecordTime(stockExchangeId, companyCode, time);
        if(optional.isEmpty()){
            throw new NullPointerException("Stock price not found");
        }

        return optional.get().getPrice();
    }

    public Map<String, Double> getAllCurrentStockPrice(int stockExchangeId){
        Map<String, Double> m = new HashMap<>();
        List<StockPrice> currentPrice = stockPriceRepository.findAllCurrentStockPrice(stockExchangeId);

        for(StockPrice s : currentPrice){
            m.put(s.getCompanyCode(), s.getPrice());
        }

        return m;
    }

    public List<StockPriceDTO> getStockPriceByStockExchangeIdAndIdAndTimeDuration(int stockExchangeId, int companyId, Timestamp startTime, Timestamp endTime){

        List<StockPriceDTO> stockPriceDTOS = new ArrayList<>();
        List<StockPrice> stockPriceList = stockPriceRepository.findStockPriceByCompanyIdAndTimeDuration(stockExchangeId, companyId, startTime, endTime);
        for(StockPrice stockPrice : stockPriceList){
            stockPriceDTOS.add(StockPriceMapper.doMap(stockPrice));
        }

        return stockPriceDTOS;
    }

}
