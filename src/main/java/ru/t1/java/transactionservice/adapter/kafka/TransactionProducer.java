package ru.t1.java.transactionservice.adapter.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import ru.t1.java.transactionservice.app.domain.dto.TransactionDto;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionProducer {

    private final StreamBridge streamBridge;

    public void sendTransaction(List<TransactionDto> transactionDto) {
        try {
            streamBridge.send("sendTransaction-out-0", transactionDto);
            log.info("Транзакции отправлены в топик: {}", transactionDto);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
