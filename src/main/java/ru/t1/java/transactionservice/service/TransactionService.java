package ru.t1.java.transactionservice.service;

import ru.t1.java.transactionservice.dto.TransactionDto;

public interface TransactionService {
    void processTransaction(TransactionDto transactionDto);
}
