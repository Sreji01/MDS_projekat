package com.mds.project.dto;

import java.util.Date;

public class StockAnalysisResponse {

    private String period;
    private String bestBuyDate;
    private Double bestBuyDateCloseValue;
    private String bestSellDate;
    private Double bestSellDateCloseValue;
    private Double profit;
    private Double maxProfit;

    public StockAnalysisResponse() {
    }

    public StockAnalysisResponse(String bestBuyDate, Double bestBuyDateCloseValue, String bestSellDate, Double bestSellDateCloseValue, Double profit, Double maxProfit) {
        this.bestBuyDate = bestBuyDate;
        this.bestBuyDateCloseValue = bestBuyDateCloseValue;
        this.bestSellDate = bestSellDate;
        this.bestSellDateCloseValue = bestSellDateCloseValue;
        this.profit = profit;
        this.maxProfit = maxProfit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBestBuyDate() {
        return bestBuyDate;
    }

    public void setBestBuyDate(String bestBuyDate) {
        this.bestBuyDate = bestBuyDate;
    }

    public Double getBestBuyDateCloseValue() {
        return bestBuyDateCloseValue;
    }

    public void setBestBuyDateCloseValue(Double bestBuyDateCloseValue) {
        this.bestBuyDateCloseValue = bestBuyDateCloseValue;
    }

    public String getBestSellDate() {
        return bestSellDate;
    }

    public void setBestSellDate(String bestSellDate) {
        this.bestSellDate = bestSellDate;
    }

    public Double getBestSellDateCloseValue() {
        return bestSellDateCloseValue;
    }

    public void setBestSellDateCloseValue(Double bestSellDateCloseValue) {
        this.bestSellDateCloseValue = bestSellDateCloseValue;
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
                ", bestBuyDate='" + bestBuyDate + '\'' +
                ", bestBuyDateCloseValue=" + bestBuyDateCloseValue +
                ", bestSellDate='" + bestSellDate + '\'' +
                ", bestSellDateCloseValue=" + bestSellDateCloseValue +
                ", profit=" + profit +
                ", maxProfit=" + maxProfit +
                '}';
    }
}
