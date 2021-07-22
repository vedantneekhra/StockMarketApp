package com.vedant.exchangeservice.Controller;

import com.vedant.exchangeservice.DTO.StockPriceDTO;
import com.vedant.exchangeservice.Services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exchange")
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

    @GetMapping("/priceByDuration")
    public List<StockPriceDTO> getStockPriceByIdAndDuration(@RequestParam("CompanyId") int companyId,
                                                            @RequestParam("StartTime") Timestamp startTime,
                                                            @RequestParam("EndTime") Timestamp endTime){

        return dataService.getStockPriceByIdAndTimeDuration(companyId, startTime, endTime);
    }

}
