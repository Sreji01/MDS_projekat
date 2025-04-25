package com.mds.project.controller;

import com.mds.project.dto.StockAnalysisRequest;
import com.mds.project.dto.StockAnalysisResponse;
import com.mds.project.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock-analysis")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<List<StockAnalysisResponse>> getBestTrades(@RequestBody StockAnalysisRequest request) throws Exception {
        List<StockAnalysisResponse> responses = stockService.analyseStocks(request.getStockTicker(),
                request.getStartDate(),
                request.getEndDate());

        return ResponseEntity.ok(responses);
    }
}
