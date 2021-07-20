package com.vedant.companyservice.Repository;

import com.vedant.companyservice.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

    public List<CompanyEntity> findByNameLike(String namePattern);
    public List<CompanyEntity> findBySectorId(int sectorId);
}
