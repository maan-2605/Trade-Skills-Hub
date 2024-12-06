package net.engineeringdigest.tradeSkillsHub.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "credit_transactions")
public class CreditTransaction {
    @Id
    private String id;
    private String userId;
    private double amount;
    private TransactionType type;
    private LocalDateTime timestamp;

    public enum TransactionType {
        EARN,
        SPEND
    }
}