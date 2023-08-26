package com.example.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo_spring_project");
        dataSource.setUsername("springstudent");
        dataSource.setPassword("springstudent");
        return dataSource;
    }
}
