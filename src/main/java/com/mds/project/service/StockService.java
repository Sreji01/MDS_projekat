package com.mds.project.service;

import com.mds.project.dto.StockAnalysisResponse;
import com.mds.project.entity.StockInstance;
import com.mds.project.repository.StockInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockInstanceRepository stockInstanceRepository;

    String stockTicker;

    public List<StockAnalysisResponse> analyseStocks(String stockTicker, LocalDate startDate, LocalDate endDate) {

        this.stockTicker = stockTicker;

        Period period = Period.between(startDate, endDate);

        StockAnalysisResponse responseBefore = calculateBestTrades(startDate.minus(period), startDate.minusDays(1));
        StockAnalysisResponse responseDuring = calculateBestTrades(startDate, endDate);
        StockAnalysisResponse responseAfter = calculateBestTrades(endDate.plusDays(1), endDate.plus(period));

        return List.of(responseBefore, responseDuring, responseAfter);
    }

    private StockAnalysisResponse calculateBestTrades(LocalDate startDate, LocalDate endDate) {
        List<StockInstance> stocks = stockInstanceRepository.findByStockTickerDateBetween(stockTicker, startDate, endDate);

        Double minValue = Double.MAX_VALUE;
        LocalDate buyDate = null;
        Double buyCloseValue = null;

        Double maxValue = Double.MIN_VALUE;
        LocalDate sellDate = null;
        Double sellCloseValue = null;

        Double startDateCloseValue = null;
        Double endDateCloseValue = null;
        Double profit = null;

        Double profitSum = 0.0;
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(stocks.get(i).getDate());
            System.out.println(stocks.get(i).getHigh());

            if(stocks.get(i).getLow() < minValue){
                minValue = stocks.get(i).getLow();
                buyDate = stocks.get(i).getDate();
                buyCloseValue = stocks.get(i).getAdjClose();
            }

            if(stocks.get(i).getHigh() > maxValue){
                maxValue = stocks.get(i).getHigh();
                System.out.println(maxValue);
                sellDate = stocks.get(i).getDate();
                sellCloseValue = stocks.get(i).getAdjClose();
            }

            if(stocks.get(i).getDate().equals(startDate)){
                startDateCloseValue = stocks.get(i).getAdjClose();
            }

            if(stocks.get(i).getDate().equals(endDate)){
                endDateCloseValue = stocks.get(i).getAdjClose();
            }

            profit = (startDateCloseValue != null && endDateCloseValue != null) ? endDateCloseValue - startDateCloseValue : 0.0;

            Double startingValue = stocks.get(i).getAdjClose();
            Double maxProfit = Double.MIN_VALUE;

            for (int j = i + 1; j < stocks.size(); j++) {
                if(stocks.get(j).getAdjClose() > maxProfit){
                    maxProfit = stocks.get(j).getAdjClose();
                }
            }
            if(startingValue < maxProfit){
                profitSum += maxProfit - startingValue;
            }
        }
        StockAnalysisResponse response = new StockAnalysisResponse(buyDate.toString(), buyCloseValue, sellDate.toString(), sellCloseValue, profit, profitSum);

        response.setPeriod("From: " + startDate.toString() + " To: " + endDate.toString());

        return response;
    }

}

