package net.engineeringdigest.tradeSkillsHub.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import net.engineeringdigest.tradeSkillsHub.model.SkillExchange;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillExchangeDto {
    private String id;
    private String offererUserId;
    private String requesterUserId;
    private SkillDto offeredSkill;
    private SkillDto requestedSkill;
    private LocalDateTime createdAt;
    private SkillExchange.ExchangeStatus status;
    private Integer exchangeHours;
}
