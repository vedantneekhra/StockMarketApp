package com.vedant.companyservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class Base {

    @GetMapping("/matchingCompanies/{Pattern}")
    public List<CompanyDTO> getMatchingCompany(@PathVariable("Pattern") String namePattern){
        return ;
    }

    @GetMapping("/companyDetails/{Id}")
    public CompanyDTO getCompanyDetails(@PathVariable("Id") long companyId){

    }

    @GetMapping("/IPODetails/{Id}")
    public IPODTO getIPODetails(@PathVariable("Id") Long companyId){

    }

    @GetMapping("/StockPrice/{CompanyId}/{StartTime}/{EndTime}")
    public List
}
