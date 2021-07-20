package com.vedant.companyservice.Service;

import com.vedant.companyservice.DTO.CompanyDTO;
import com.vedant.companyservice.Entity.CompanyEntity;
import com.vedant.companyservice.Repository.CompanyRepository;
import com.vedant.companyservice.Repository.IPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDTO> getMatchingCompany(String namePattern) {
        List<CompanyEntity> byNameLike = companyRepository.findByNameLike(namePattern);
        List<CompanyDTO> byNameDTO = new ArrayList<>();

        for(CompanyEntity companyEntity: byNameLike){
            byNameDTO.add(new CompanyDTO(companyEntity));
        }

        return byNameDTO;
    }

    public CompanyDTO getCompanyById(int companyId) {
        Optional<CompanyEntity> byId = companyRepository.findById(companyId);
        if(byId.isEmpty()){
            throw new NullPointerException("Company not Found!!");
        }
        return new CompanyDTO(byId.get());
    }

    public List<CompanyDTO> getCompanyBySectorId(int sectorId){
        List<CompanyEntity> bySectorId = companyRepository.findBySectorId(sectorId);
        List<CompanyDTO> bySectorIdDTO = new ArrayList<>();

        for(CompanyEntity companyEntity : bySectorId){
            bySectorIdDTO.add(new CompanyDTO(companyEntity));
        }

        return bySectorIdDTO;
    }


}
