package com.mds.project.repository;

import com.mds.project.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByCompanyName(String companyName);

}
