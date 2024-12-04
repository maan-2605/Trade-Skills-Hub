package net.engineeringdigest.tradeSkillsHub.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import net.engineeringdigest.tradeSkillsHub.model.Skill;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private String id;
    private String name;
    private String category;
    private String description;
    private Skill.SkillLevel difficulty;
    private String userId;
    private LocalDateTime createdAt;

}
