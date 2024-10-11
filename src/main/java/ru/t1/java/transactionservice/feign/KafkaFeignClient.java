package ru.t1.java.transactionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.t1.java.transactionservice.config.FeignConfig;
import ru.t1.java.transactionservice.dto.TransactionDto;

@FeignClient(name = "kafkaClient", url = "http://localhost:9092")
public interface KafkaFeignClient {

    @PostMapping("/topics/t1_demo_client_transactions")
    void sendTransaction(@RequestBody TransactionDto transactionDto);
}

