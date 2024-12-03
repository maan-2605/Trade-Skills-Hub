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
@Document(collection = "skills")
public class Skill {
    @Id
    private String id;

    private String name;
    private String category;
    private String description;
    private SkillLevel difficulty;
    private String userId; // Owner of the skill

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Nested enum for Skill Level
    public enum SkillLevel {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    public enum Category {
        TECHNOLOGY,
        ARTS_AND_CREATIVITY,
        LANGUAGES,
        MUSIC,
        SPORTS,
        COOKING,
        PROFESSIONAL_SKILLS,
        PERSONAL_DEVELOPMENT,
        OTHER
    }
}