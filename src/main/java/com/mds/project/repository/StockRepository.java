package com.mds.project.repository;

import com.mds.project.entity.Stock;
import com.mds.project.entity.StockInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findFirstByOrderByIdAsc();

    Stock findByCompanyName(String companyName);

}
