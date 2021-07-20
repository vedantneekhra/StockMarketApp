package com.vedant.companyservice.Controller;

import com.vedant.companyservice.DTO.CompanyDTO;
import com.vedant.companyservice.DTO.IPODTO;
import com.vedant.companyservice.DTO.StockPriceDTO;
import com.vedant.companyservice.Service.CompanyService;
import com.vedant.companyservice.Service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Base {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IPOService ipoService;

    @GetMapping("/matchingCompanies/{Pattern}")
    public List<CompanyDTO> getMatchingCompany(@PathVariable("Pattern") String namePattern){
        return companyService.getMatchingCompany(namePattern);
    }

    @GetMapping("/companyDetails/{Id}")
    public CompanyDTO getCompanyDetails(@PathVariable("Id") int companyId){
        return companyService.getCompanyById(companyId);
    }

    @GetMapping("/IPODetails/{Id}")
    public IPODTO getIPODetails(@PathVariable("Id") int companyId){
        return ipoService.getIPODetailsById(companyId);
    }

    @GetMapping("/StockPrice/{CompanyId}/{StartTime}/{EndTime}")
    public List<StockPriceDTO> getStockPrice(@PathVariable("CompanyId") int companyId,
                                             @PathVariable("StartTime") Timestamp startTime,
                                             @PathVariable("endTime") Timestamp endTime){
        return new ArrayList<>();
    }

    @GetMapping("/companyBySectorId/{SectorId}")
    public List<CompanyDTO> getCompanyBySectorId(@PathVariable("SectorId") int sectorId){
        return companyService.getCompanyBySectorId(sectorId);
    }
}
