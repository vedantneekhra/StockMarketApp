package com.vedant.exchangeservice.Services;

import com.vedant.exchangeservice.DTO.StockExchangeDTO;
import com.vedant.exchangeservice.Entity.StockExchangeEntity;
import com.vedant.exchangeservice.Mapper.StockExchangeMapper;
import com.vedant.exchangeservice.Repository.StockExchangeRepository;
import com.vedant.exchangeservice.Repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public List<StockExchangeDTO> getStockExchange(){
        List<StockExchangeEntity> all = stockExchangeRepository.findAll();
        List<StockExchangeDTO> allDTO = new ArrayList<>();

        for(StockExchangeEntity stockExchangeEntity : all){
            allDTO.add(StockExchangeMapper.convertToDTO(stockExchangeEntity));
        }

        return allDTO;
    }

    public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO){


        if(stockExchangeRepository.existsById(stockExchangeDTO.getId())){
            throw new IllegalStateException("Stock Exchange all ready exist!!");
        }

        stockExchangeRepository.save(StockExchangeMapper.convertToEntity(stockExchangeDTO));

        return stockExchangeDTO;
    }

}
