package com.vmware.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

    @Bean
    public String javaStringBean1() {
        return "javaStringBean1value";
    }

}