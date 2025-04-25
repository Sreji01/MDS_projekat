package com.mds.project.dto;

import java.time.LocalDate;

public class StockAnalysisRequest {

    private String stockTicker;
    private LocalDate startDate;
    private LocalDate endDate;

    public StockAnalysisRequest() {
    }

    public StockAnalysisRequest(String stockTicker, LocalDate startDate, LocalDate endDate) {
        this.stockTicker = stockTicker;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
