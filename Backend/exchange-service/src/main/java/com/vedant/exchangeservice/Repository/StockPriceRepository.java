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

    public List<StockPrice> findByCompanyCode(String companyCode);
    public Optional<StockPrice> findByCompanyCodeAndRecordTime(String companyCode, Timestamp time);

    @Query(value = "SELECT * FROM stock_price WHERE (company_code, record_time) in (SELECT company_code, MAX(record_time) as m_time FROM stock_price GROUP BY company_code)", nativeQuery = true)
    public List<StockPrice> findAllCurrentStockPrice();
}
