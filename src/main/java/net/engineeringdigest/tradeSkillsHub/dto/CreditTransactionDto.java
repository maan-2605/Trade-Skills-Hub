package net.engineeringdigest.tradeSkillsHub.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreditTransactionDto {
    private String id;
    private String userId;
    private double amount;
    private TransactionType type;
    private LocalDateTime timestamp;

    public enum TransactionType {
        EARN,   // Credits earned through skill exchanges
        SPEND   // Credits spent on skill exchanges
    }
}