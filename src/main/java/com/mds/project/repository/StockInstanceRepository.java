package com.mds.project.repository;

import com.mds.project.entity.Stock;
import com.mds.project.entity.StockInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockInstanceRepository extends JpaRepository<StockInstance, Long> {

    Optional<StockInstance> findStockInstanceById(Long id);

    StockInstance findFirstByOrderByIdAsc();
}
