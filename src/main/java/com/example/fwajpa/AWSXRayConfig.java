package com.example.fwajpa;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class AWSXRayConfig {
    @Bean
    public Filter xrayFilter(){
        return new AWSXRayServletFilter("Firstapp");
    }
}
