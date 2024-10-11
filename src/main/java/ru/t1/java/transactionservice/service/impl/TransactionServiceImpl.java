package ru.t1.java.transactionservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.t1.java.transactionservice.dto.TransactionDto;
import ru.t1.java.transactionservice.feign.KafkaFeignClient;
import ru.t1.java.transactionservice.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final KafkaFeignClient kafkaFeignClient;

    @Autowired
    public TransactionServiceImpl(KafkaFeignClient kafkaFeignClient) {
        this.kafkaFeignClient = kafkaFeignClient;
    }

    @Override
    public void processTransaction(TransactionDto transactionDto) {
        kafkaFeignClient.sendTransaction(transactionDto);
    }
}
