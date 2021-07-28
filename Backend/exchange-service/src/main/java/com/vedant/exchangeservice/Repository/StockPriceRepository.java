package com.vedant.exchangeservice.Repository;

import com.vedant.exchangeservice.Entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, String> {

    public List<StockPrice> findByStockExchangeAndCompanyCode(int stockExchange, String companyCode);
    public Optional<StockPrice> findByStockExchangeAndCompanyCodeAndRecordTime(int stockExchangeId, String companyCode, Timestamp time);

    @Query(value = "SELECT * FROM stock_price WHERE (company_code, record_time) in (SELECT company_code, MAX(record_time) as m_time FROM stock_price GROUP BY company_code) AND stock_exchange_id = :stockExchangeId", nativeQuery = true)
    public List<StockPrice> findAllCurrentStockPrice(int stockExchangeId);

    @Query(value = "SELECT * FROM stock_price WHERE stock_exchange_id = :stockExchangeId AND company_id = :companyId AND record_time BETWEEN :startTime AND :endTime", nativeQuery = true)
    public List<StockPrice> findStockPriceByCompanyIdAndTimeDuration(int stockExchangeId, int companyId, Timestamp startTime, Timestamp endTime);
}
