package com.mds.project;

import com.mds.project.dto.StockAnalysisResponse;
import com.mds.project.entity.StockInstance;
import com.mds.project.repository.StockInstanceRepository;
import com.mds.project.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StockServiceTest {

    @Mock
    private StockInstanceRepository stockInstanceRepository;

    @InjectMocks
    private StockService stockService;

    @Test
    void calculateProfitAccuracy() throws Exception {
        String stockTicker = "AMZN";
        LocalDate startDate = LocalDate.of(2001, 10, 10);
        LocalDate endDate = LocalDate.of(2001, 10, 18);

        List<StockInstance> mockStocks = List.of(
                new StockInstance(startDate, 100.0, 110.0, 95.0, 105.0, 105.0, 1000L),
                new StockInstance(LocalDate.of(2001, 10, 13), 105.0, 115.0, 97.5, 110.0, 110.0, 1200L),
                new StockInstance(LocalDate.of(2001, 10, 16), 110.0, 120.0, 100.0, 115.0, 115.0, 1200L),
                new StockInstance(endDate, 115.0, 130.0, 105.0, 120.0, 120.0, 1500L)
        );

        Mockito.when(stockInstanceRepository.findByStockTickerDateBetween(stockTicker, startDate, endDate)).thenReturn(
                mockStocks
        );

        List<StockAnalysisResponse> responses = stockService.analyseStocks(stockTicker, startDate, endDate);

        StockAnalysisResponse currentResponse = responses.get(1);

        assertEquals(15.0, currentResponse.getProfit()); // 120.0 - 105.0 = 11.0

        assertEquals(30.0, currentResponse.getMaxProfit()); // (120.0 - 105.0) + (120.0 - 110.0) + (120.0 - 115.0) = 30.0
    }
}
