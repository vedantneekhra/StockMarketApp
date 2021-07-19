package com.vedant.exchangeservice.Controller;

import com.vedant.exchangeservice.Services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Map;

@RestController
public class Base {

    @Autowired
    private DataService dataService;

    @GetMapping("/priceByCode/{CompanyCode}")
    public double getCurrentStockPriceByCompanyCode(@PathVariable("CompanyCode") String code){
        System.out.print("Value of company code " + code);
        return dataService.getCurrentPriceByCode(code);
    }

    @GetMapping("/priceByCodeAndTime/{CompanyCode}/{Time}")
    public double getStockPriceByCompanyCode(@PathVariable("CompanyCode") String code, @PathVariable("Time") Timestamp time){
        return dataService.getPriceByCode(code, time);
    }

    @GetMapping("/price")
    public Map<String, Double> getCurrentStockPrice(){
        return dataService.getAllCurrentStockPrice();
    }

//    public long getTradeVolumeByCompanyCodeAndTimeInterval(String code, Timestamp startTime, Timestamp endTime){
//        return 0;
//    }
//
//    public boolean buyStock(String companyCode, long quantity){
//
//        return false;
//    }
//
//    public long buyStockAtfixedPrice(String companyCode, long quantity, float price){
//
//        return 0;
//    }
//
//    public boolean sellStock(String companyCode, long quantity){
//
//        return false;
//    }
//
//    public boolean sellStockAtFixedPrice(String companyCode, long quantity, float price){
//
//        return false;
//    }

}
