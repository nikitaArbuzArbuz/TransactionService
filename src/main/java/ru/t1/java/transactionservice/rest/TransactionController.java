package ru.t1.java.transactionservice.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.java.transactionservice.app.domain.dto.TransactionDto;
import ru.t1.java.transactionservice.adapter.kafka.TransactionProducer;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionProducer transactionProducer;

    @PostMapping("/create")
    public ResponseEntity<String> createTransaction(@RequestBody List<TransactionDto> transactionDto) {
        transactionProducer.sendTransaction(transactionDto);
        return ResponseEntity.ok()
                .header("Server", "Транзакции созданы и отправлены в кафку - " + transactionDto)
                .build();
    }
}
