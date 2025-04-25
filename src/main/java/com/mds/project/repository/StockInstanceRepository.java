package com.mds.project.repository;

import com.mds.project.entity.StockInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StockInstanceRepository extends JpaRepository<StockInstance, Long> {

    StockInstance findFirstByOrderByIdAsc();

    @Query("SELECT si FROM StockInstance si WHERE si.stock.stockTicker = :stockTicker AND " +
            "si.date BETWEEN :startDate AND :endDate")
    List<StockInstance> findByStockTickerDateBetween(@Param("stockTicker") String stockTicker,
                                                     @Param("startDate") LocalDate StartDate,
                                                     @Param("endDate") LocalDate EndDate);

}
