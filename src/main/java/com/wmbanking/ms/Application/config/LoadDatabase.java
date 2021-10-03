package com.wmbanking.ms.Application.config;

import com.wmbanking.ms.Application.entity.Employee;
import com.wmbanking.ms.Application.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
        return args -> {
          logger.info("Preloading " + employeeRepository.save(new Employee("sachin", "Engineer")));
          logger.info("Preloading " + employeeRepository.save(new Employee("pravin", "owner")));
        };
    }
}
