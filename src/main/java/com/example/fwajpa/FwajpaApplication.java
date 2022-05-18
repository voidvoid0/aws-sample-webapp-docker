package com.example.fwajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class FwajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwajpaApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        System.out.println("Initializing datasource");
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://" + System.getenv("RDS_HOSTNAME") + ":" + System.getenv("RDS_PORT") + "/" + System.getenv("RDS_DB_NAME") )
                .username(System.getenv("RDS_USERNAME"))
                .password(System.getenv("RDS_PASSWORD"))
                .build();
    }
}
