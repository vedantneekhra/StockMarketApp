package com.vedant.exchangeservice.Repository;

import com.vedant.exchangeservice.Entity.StockExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, Integer> {
}
