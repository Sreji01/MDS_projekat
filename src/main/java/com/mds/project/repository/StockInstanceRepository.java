package com.mds.project.repository;

import com.mds.project.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInstanceRepository extends JpaRepository<Stock, Long> {
}
