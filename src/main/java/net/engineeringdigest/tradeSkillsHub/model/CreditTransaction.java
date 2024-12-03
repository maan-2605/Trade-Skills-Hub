package net.engineeringdigest.tradeSkillsHub.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_transactions")
public class CreditTransaction {
    @Id
    private String id;

    private String userId;
    private TransactionType type;
    private int amount;
    private String description;
    private LocalDateTime timestamp;

    // Enum for Transaction Types
    public enum TransactionType {
        SKILL_EXCHANGE,     // Credits earned/spent in a skill exchange
        REFERRAL,           // Credits from referral program
        ADMIN_ADJUSTMENT,   // Manual adjustment by admin
        BONUS,              // Bonus credits
        PURCHASE            // Purchasing credits
    }
}