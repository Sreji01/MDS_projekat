package com.mds.project.service;

import com.mds.project.entity.Stock;
import com.mds.project.entity.StockInstance;
import com.mds.project.repository.StockInstanceRepository;
import com.mds.project.repository.StockRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockInstanceRepository stockInstanceRepository;

    public void loadDataFromCsv() throws IOException, CsvException, ParseException {

        if(stockInstanceRepository.findStockInstanceById(1L).isPresent()){
            return;
        }

        Resource[] resources = context.getResources("classpath:data/*.csv");

        List<StockInstance> stockInstances = new ArrayList<>();

        for (Resource resource : resources) {
            try (CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
                List<String[]> records = csvReader.readAll();

                Stock stock = stockRepository.findByCompanyName(resource.getFilename().replace(".csv", ""));

                for (int i = 1; i < records.size(); i++) {
                    String[] row = records.get(i);

                        StockInstance instance = new StockInstance();
                        instance.setStock(stock);
                        instance.setDate(getDate(row[0]));
                        instance.setOpen(Double.parseDouble(row[1]));
                        instance.setHigh(Double.parseDouble(row[2]));
                        instance.setLow(Double.parseDouble(row[3]));
                        instance.setClose(Double.parseDouble(row[4]));
                        instance.setAdjClose(Double.parseDouble(row[5]));
                        instance.setVolume(Long.parseLong(row[6]));
                        stockInstances.add(instance);
                    }
                }
            }
        stockInstanceRepository.saveAll(stockInstances);
        }


    private Date getDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateString);
    }
}
