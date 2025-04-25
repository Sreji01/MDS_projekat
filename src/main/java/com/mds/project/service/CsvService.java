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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        if (stockInstanceRepository.findFirstByOrderByIdAsc() != null) {
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
                    instance.setDate(safeParse(row[0], LocalDate.class));
                    instance.setOpen(safeParse(row[1], Double.class));
                    instance.setHigh(safeParse(row[2], Double.class));
                    instance.setLow(safeParse(row[3], Double.class));
                    instance.setClose(safeParse(row[4], Double.class));
                    instance.setAdjClose(safeParse(row[5], Double.class));
                    instance.setVolume(safeParse(row[6], Long.class));
                    stockInstances.add(instance);
                }
            }
            stockInstanceRepository.saveAll(stockInstances);
        }
    }

    private <T> T safeParse(String value, Class<T> type) throws ParseException {
        if (value == null || value.trim().equalsIgnoreCase("null") || value.trim().isEmpty()) {
            return null;
        }
        if (type == Double.class) {
            return type.cast(Double.parseDouble(value.trim()));
        } else if (type == Long.class) {
            return type.cast(Long.parseLong(value.trim()));
        } else if (type == Integer.class) {
            return type.cast(Integer.parseInt(value.trim()));
        } else if (type == LocalDate.class) {
            return type.cast(getDate(value.trim()));
        }
        throw new IllegalArgumentException("Unsupported type: " + type.getName());
    }

    private LocalDate getDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}
