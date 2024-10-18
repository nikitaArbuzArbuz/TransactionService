package ru.t1.java.transactionservice.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.stream.function.StreamBridge;
import ru.t1.java.transactionservice.adapter.kafka.TransactionProducer;
import ru.t1.java.transactionservice.app.domain.dto.TransactionDto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TransactionProducerTests {
    @Mock
    private StreamBridge streamBridge;

    @InjectMocks
    private TransactionProducer transactionProducer;

    @Test
    void sendTransactionByStreamBridge() {
        List<TransactionDto> transactionDtoList = List.of(new TransactionDto());
        transactionProducer.sendTransaction(transactionDtoList);
        verify(streamBridge, times(1)).send("sendTransaction-out-0",
                transactionDtoList);
    }

    @Test
    void sendTransactionShouldHandleException() {
        List<TransactionDto> transactionDtoList = List.of(new TransactionDto());
        doThrow(new RuntimeException("Simulated exception"))
                .when(streamBridge).send("sendTransaction-out-0", transactionDtoList);
        assertDoesNotThrow(() -> transactionProducer.sendTransaction(transactionDtoList));
    }
}
