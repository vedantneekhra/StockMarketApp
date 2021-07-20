package com.vedant.companyservice.Service;

import com.vedant.companyservice.DTO.IPODTO;
import com.vedant.companyservice.Entity.IPOEntity;
import com.vedant.companyservice.Repository.IPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPOService {

    @Autowired
    private IPORepository ipoRepository;

    public IPODTO getIPODetailsById(int companyId) {
        Optional<IPOEntity> byId = ipoRepository.findById(companyId);
        if(byId.isEmpty()){
            throw new NullPointerException("IPO not Found!!");
        }
        return new IPODTO(byId.get());
    }
}
