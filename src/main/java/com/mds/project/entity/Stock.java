package com.mds.project.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "stock_ticker")
    private String stockTicker;

    @Column(name = "company_founding_date")
    private Date companyFoundingDate;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<StockInstance> instances = new ArrayList<>();

    public Stock(){

    }

    public Stock(String companyName, String stockTicker, Date companyFoundingDate) {
        this.companyName = companyName;
        this.stockTicker = stockTicker;
        this.companyFoundingDate = companyFoundingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public Date getCompanyFoundingDate() {
        return companyFoundingDate;
    }

    public void setCompanyFoundingDate(Date companyFoundingDate) {
        this.companyFoundingDate = companyFoundingDate;
    }

    public List<StockInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<StockInstance> instances) {
        this.instances = instances;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", stockTicker='" + stockTicker + '\'' +
                ", companyFoundingDate=" + companyFoundingDate +
                 '}';
    }
}
