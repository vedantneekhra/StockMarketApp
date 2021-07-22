package com.vedant.sectorservice.Controller;

import com.vedant.sectorservice.DTO.CompanyDTO;
import com.vedant.sectorservice.Repository.SectorRepository;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sector")
public class Base {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/companyBySectorId/{SectorId}")
    public List<CompanyDTO> getCompanyBySectorId(@PathVariable("SectorId") int sectorId){
        ServiceInstance serviceInstance = loadBalancer.choose("company-service");

        String baseUrl=serviceInstance.getUri().toString();
        baseUrl = baseUrl + "/company/companyBySectorId/"+Integer.toString(sectorId);

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

    @GetMapping("/sectorPrice/{SectorId}/{StartTime}/{EndTime}")
    public double getSectorPrice(@PathVariable("SectorId") int sectorId,
                                 @PathVariable("StartTime") Timestamp startTime,
                                 @PathVariable("EndTime") Timestamp endTIme){
        return 0;
    }

}
