package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangpeil
 */
@Configuration
public class CustomRule {
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }
}
