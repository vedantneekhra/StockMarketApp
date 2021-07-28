package com.vedant.companyservice.Controller;

import com.vedant.companyservice.DTO.CompanyDTO;
import com.vedant.companyservice.DTO.IPODTO;
import com.vedant.companyservice.DTO.StockPriceDTO;
import com.vedant.companyservice.Service.CompanyService;
import com.vedant.companyservice.Service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/company")
public class Base {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IPOService ipoService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/matchingCompanies/{Pattern}")
    public List<CompanyDTO> getMatchingCompany(@PathVariable("Pattern") String namePattern){
        return companyService.getMatchingCompany(namePattern);
    }

    @GetMapping("/companyDetails/{Id}")
    public CompanyDTO getCompanyDetails(@PathVariable("Id") int companyId){
        return companyService.getCompanyById(companyId);
    }

    @GetMapping("/IPODetails/{Id}")
    public List<IPODTO> getIPODetails(@PathVariable("Id") int companyId){
        return ipoService.getIPODetailsById(companyId);
    }

    @GetMapping("/StockPrice/{StockExchangeId}/{CompanyId}/{StartTime}/{EndTime}")
    public List<StockPriceDTO> getStockPrice(@PathVariable("StockExchangeId") int stockExchangeId,
                                             @PathVariable("CompanyId") int companyId,
                                             @PathVariable("StartTime") Timestamp startTime,
                                             @PathVariable("EndTime") Timestamp endTime){

        ServiceInstance serviceInstance = loadBalancer.choose("exchange-service");

        System.out.println(serviceInstance.getUri());

        String baseUrl=serviceInstance.getUri().toString();
        baseUrl = baseUrl + "/exchange/priceByDuration?StockExchangeId=" + Integer.toString(stockExchangeId) +
                "&CompanyId="+Integer.toString(companyId)+
                "&StartTime="+startTime.toString()+"&EndTime="+endTime.toString();

        System.out.println(baseUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<StockPriceDTO>> response=null;

        ParameterizedTypeReference<List<StockPriceDTO>> paraRefer = new ParameterizedTypeReference<List<StockPriceDTO>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };

        try{
            response = restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(), paraRefer, StockPriceDTO.class);
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

    @GetMapping("/companyBySectorId/{SectorId}")
    public List<CompanyDTO> getCompanyBySectorId(@PathVariable("SectorId") int sectorId){
        return companyService.getCompanyBySectorId(sectorId);
    }

    @GetMapping("/companyByExchangeId/{StockExchangeId}")
    public List<CompanyDTO> getCompanyByStockExchangeId(@PathVariable("StockExchangeId") int stockExchangeId){
        return ipoService.getCompanyByStockExchangeId(stockExchangeId);
    }

}
