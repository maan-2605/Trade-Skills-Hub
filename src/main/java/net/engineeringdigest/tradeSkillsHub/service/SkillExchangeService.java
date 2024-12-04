package net.engineeringdigest.tradeSkillsHub.service;

import net.engineeringdigest.tradeSkillsHub.dto.SkillExchangeDto;

import java.util.List;
import java.util.Optional;

public interface SkillExchangeService {
    SkillExchangeDto initiateSkillExchange(String offererUserId, String requesterUserId, String offeredSkillId, String requestedSkillId);
    SkillExchangeDto updateSkillExchangeStatus(String exchangeId, SkillExchangeDto.Status status);
    Optional<SkillExchangeDto> findById(String exchangeId);
    List<SkillExchangeDto> findByOffererUserId(String userId);
    List<SkillExchangeDto> findByRequesterUserId(String userId);
    List<SkillExchangeDto> findByStatus(SkillExchangeDto.Status status);
}