package com.vedant.exchangeservice.Controller;

import com.vedant.exchangeservice.DTO.CompanyDTO;
import com.vedant.exchangeservice.DTO.StockExchangeDTO;
import com.vedant.exchangeservice.DTO.StockPriceDTO;
import com.vedant.exchangeservice.Services.StockExchangeService;
import com.vedant.exchangeservice.Services.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exchange")
public class Base {

    @Autowired
    private StockPriceService stockPriceService;

    @Autowired
    private StockExchangeService stockExchangeService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/priceByCode/{StockExchangeId}/{CompanyCode}")
    public double getCurrentStockPriceByCompanyCode(@PathVariable("StockExchangeId") int stockExchangeId,
                                                    @PathVariable("CompanyCode") String code){
        System.out.print("Value of company code " + code);
        return stockPriceService.getCurrentPriceByCode(stockExchangeId, code);
    }

    @GetMapping("/priceByCodeAndTime/{StockExchangeId}/{CompanyCode}/{Time}")
    public double getStockPriceByCompanyCode(@PathVariable("StockExchangeId") int stockExchangeId,
                                             @PathVariable("CompanyCode") String code,
                                             @PathVariable("Time") Timestamp time){
        return stockPriceService.getPriceByStockExchangeAndCode(stockExchangeId, code, time);
    }

    @GetMapping("/price/{StockExchangeId}")
    public Map<String, Double> getCurrentStockPrice(@PathVariable("StockExchangeID") int stockExchangeId){
        return stockPriceService.getAllCurrentStockPrice(stockExchangeId);
    }

    @GetMapping("/priceByDuration")
    public List<StockPriceDTO> getStockPriceByIdAndDuration(@RequestParam("StockExchangeId") int stockExchangeId,
                                                            @RequestParam("CompanyId") int companyId,
                                                            @RequestParam("StartTime") Timestamp startTime,
                                                            @RequestParam("EndTime") Timestamp endTime){

        return stockPriceService.getStockPriceByStockExchangeIdAndIdAndTimeDuration(stockExchangeId, companyId, startTime, endTime);
    }

    @GetMapping("/getStockExchange")
    public List<StockExchangeDTO> getStockExchange(){
        return stockExchangeService.getStockExchange();
    }

    @PostMapping("/addStockExchange")
    public ResponseEntity<StockExchangeDTO> addStockExchange(@RequestBody @Valid StockExchangeDTO stockExchangeDTO, BindingResult result){

        return new ResponseEntity<StockExchangeDTO>(stockExchangeService.addStockExchange(stockExchangeDTO), HttpStatus.OK);
    }

    @GetMapping("/companyByExchangeId/{StockExchangeId}")
    public List<CompanyDTO> getCompanyListByStockExchangeId(@PathVariable("StockExchangeId") int stockExchangeId){
        ServiceInstance serviceInstance = loadBalancer.choose("company-service");

        String baseUrl=serviceInstance.getUri().toString();
        baseUrl = baseUrl + "/company/companyByExchangeId/" + Integer.toString(stockExchangeId);

        System.out.println(baseUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CompanyDTO>> response=null;

        ParameterizedTypeReference<List<CompanyDTO>> paraRefer = new ParameterizedTypeReference<List<CompanyDTO>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };

        try{
            response = restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(), paraRefer, CompanyDTO.class);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return response.getBody();
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}
