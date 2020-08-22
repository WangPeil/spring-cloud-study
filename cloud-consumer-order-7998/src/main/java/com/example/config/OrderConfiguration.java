package com.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangpeil
 */
@Configuration
public class OrderConfiguration {
    @Bean
    public Logger.Level getLevel() {
        return Logger.Level.FULL;
    }
}
