package ru.t1.java.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long accountId;
    private BigDecimal amount;
    private String description;
    private TransactionType type;

    public enum TransactionType {
        ADD, SUBTRACT, CANCEL
    }
}
