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
@Document(collection = "skill_exchanges")
public class SkillExchange {
    @Id
    private String id;

    private String offererUserId;
    private String requesterUserId;

    private Skill offeredSkill;
    private Skill requestedSkill;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;

    private ExchangeStatus status;
    private int exchangeHours;

    // Feedback from both parties
    private String offererFeedback;
    private String requesterFeedback;
    private Integer offererRating;
    private Integer requesterRating;

    // Enum for Exchange Status
    public enum ExchangeStatus {
        PENDING,       // Initial state when exchange is requested
        ACCEPTED,      // Both parties agreed to exchange
        IN_PROGRESS,   // Exchange is currently happening
        COMPLETED,     // Successfully finished
        CANCELLED,     // Exchange was cancelled
        DISPUTED       // There's a conflict in the exchange
    }
}