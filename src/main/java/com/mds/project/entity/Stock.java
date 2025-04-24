package com.mds.project.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

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

    @Column(name = "current_price")
    private BigDecimal currentPrice;

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

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", stockTicker='" + stockTicker + '\'' +
                ", companyFoundingDate=" + companyFoundingDate +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
