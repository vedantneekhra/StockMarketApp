package com.vedant.companyservice.Service;

import com.vedant.companyservice.DTO.CompanyDTO;
import com.vedant.companyservice.DTO.IPODTO;
import com.vedant.companyservice.Entity.CompanyEntity;
import com.vedant.companyservice.Entity.IPOEntity;
import com.vedant.companyservice.Repository.IPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IPOService {

    @Autowired
    private IPORepository ipoRepository;

    public List<IPODTO> getIPODetailsById(int companyId) {

        List<IPOEntity> byId = ipoRepository.findByCompanyId(companyId);
        List<IPODTO> byIdDTO = new ArrayList<>();
        for(IPOEntity ipoEntity: byId){
            byIdDTO.add(new IPODTO(ipoEntity));
        }

        return byIdDTO;
    }

    public List<CompanyDTO> getCompanyByStockExchangeId(int stockExchangeId) {
        List<IPOEntity> byStockExchangeId = ipoRepository.findByStockExchangeId(stockExchangeId);
        List<CompanyDTO> stockExchangeDTOList = new ArrayList<>();
        for(IPOEntity ipoEntity: byStockExchangeId){
            stockExchangeDTOList.add(new CompanyDTO(ipoEntity.getCompany()));
        }

        return stockExchangeDTOList;
    }
}
