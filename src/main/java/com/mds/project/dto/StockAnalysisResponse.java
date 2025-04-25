package com.mds.project.dto;

import java.util.Date;

public class StockAnalysisResponse {

    private String period;
    private String buyDate;
    private Double buyDateCloseValue;
    private String sellDate;
    private Double sellDateCloseValue;
    private Double profit;
    private Double maxProfit;

    public StockAnalysisResponse() {
    }

    public StockAnalysisResponse(String buyDate, Double buyDateCloseValue, String sellDate, Double sellDateCloseValue, Double profit, Double maxProfit) {
        this.buyDate = buyDate;
        this.buyDateCloseValue = buyDateCloseValue;
        this.sellDate = sellDate;
        this.sellDateCloseValue = sellDateCloseValue;
        this.profit = profit;
        this.maxProfit = maxProfit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Double getBuyDateCloseValue() {
        return buyDateCloseValue;
    }

    public void setBuyDateCloseValue(Double buyDateCloseValue) {
        this.buyDateCloseValue = buyDateCloseValue;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public Double getSellDateCloseValue() {
        return sellDateCloseValue;
    }

    public void setSellDateCloseValue(Double sellDateCloseValue) {
        this.sellDateCloseValue = sellDateCloseValue;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(Double maxProfit) {
        this.maxProfit = maxProfit;
    }

    @Override
    public String toString() {
        return "StockAnalysisResponse{" +
                "period='" + period + '\'' +
                ", buyDate=" + buyDate +
                ", buyDateCloseValue=" + buyDateCloseValue +
                ", sellDate=" + sellDate +
                ", sellDateCloseValue=" + sellDateCloseValue +
                ", profit=" + profit +
                ", maxProfit=" + maxProfit +
                '}';
    }
}
