package com.mds.project;

import com.mds.project.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	CsvService csvService;

	@Bean
	public CommandLineRunner commandLineRunner() {

		return runner -> {
			csvService.loadDataFromCsv();
		};
	}

}
