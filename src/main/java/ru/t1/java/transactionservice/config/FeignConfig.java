package ru.t1.java.transactionservice.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.t1.java.transactionservice.utils.FeignErrorDecoder;

@Configuration
public class FeignConfig {
    @Value("${feign.client.config.default.readTimeout}")
    private int readTimeout;

    @Value("${feign.client.config.default.connectTimeout}")
    private int connectTimeout;

    @Value("${feign.client.config.default.logger.level}")
    private Logger.Level loggerLevel;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return loggerLevel;
    }

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
