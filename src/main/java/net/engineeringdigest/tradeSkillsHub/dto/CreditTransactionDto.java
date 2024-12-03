package net.engineeringdigest.tradeSkillsHub.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import net.engineeringdigest.tradeSkillsHub.model.CreditTransaction;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransactionDto {
    private String id;
    private String userId;
    private CreditTransaction.TransactionType type;
    private int amount;
    private String description;
    private LocalDateTime timestamp;
}
