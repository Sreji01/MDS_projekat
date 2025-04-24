package com.mds.project.repository;

import com.mds.project.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
