package com.vedant.companyservice.Repository;

import com.vedant.companyservice.Entity.IPOEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPORepository extends JpaRepository<IPOEntity, Integer> {
    public List<IPOEntity> findByCompanyId(int companyId);

    @Query(value = "SELECT * FROM ipo as i JOIN company as c ON c.id = i.company_id WHERE i.stock_exchange_id = :stockExchangeId", nativeQuery = true)
    public List<IPOEntity> findByStockExchangeId(int stockExchangeId);

}
