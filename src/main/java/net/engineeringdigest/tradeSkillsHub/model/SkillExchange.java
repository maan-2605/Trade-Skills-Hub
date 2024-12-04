package net.engineeringdigest.tradeSkillsHub.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "skill_exchanges")
public class SkillExchange {
    @Id
    private String id;
    private String offererUserId;
    private String requesterUserId;
    private String offeredSkillId;
    private String requestedSkillId;
    private ExchangeStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum ExchangeStatus {
        PENDING,
        ACCEPTED,
        REJECTED,
        COMPLETED,
        CANCELLED
    }
}