package net.engineeringdigest.tradeSkillsHub.service;

import lombok.RequiredArgsConstructor;
import net.engineeringdigest.tradeSkillsHub.dto.SkillExchangeDto;
import net.engineeringdigest.tradeSkillsHub.model.SkillExchange;
import net.engineeringdigest.tradeSkillsHub.repository.SkillExchangeRepository;
import net.engineeringdigest.tradeSkillsHub.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class SkillExchangeServiceImpl implements SkillExchangeService {
    private final SkillExchangeRepository skillExchangeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public SkillExchangeDto initiateSkillExchange(String offererUserId, String requesterUserId, String offeredSkillId, String requestedSkillId) {
        SkillExchange skillExchange = new SkillExchange();
        skillExchange.setOffererUserId(offererUserId);
        skillExchange.setRequesterUserId(requesterUserId);
        skillExchange.setOfferedSkillId(offeredSkillId);
        skillExchange.setRequestedSkillId(requestedSkillId);
        skillExchange.setStatus(SkillExchange.ExchangeStatus.PENDING);
        skillExchange.setCreatedAt(LocalDateTime.now());

        SkillExchange savedExchange = skillExchangeRepository.save(skillExchange);
        return modelMapper.map(savedExchange, SkillExchangeDto.class);
    }

    @Override
    public SkillExchangeDto updateSkillExchangeStatus(String exchangeId, SkillExchangeDto.Status status) {
        SkillExchange skillExchange = skillExchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new RuntimeException("Skill Exchange not found"));

        skillExchange.setStatus(SkillExchange.ExchangeStatus.valueOf(status.name()));
        skillExchange.setUpdatedAt(LocalDateTime.now());

        SkillExchange updatedExchange = skillExchangeRepository.save(skillExchange);
        return modelMapper.map(updatedExchange, SkillExchangeDto.class);
    }

    @Override
    public Optional<SkillExchangeDto> findById(String exchangeId) {
        return skillExchangeRepository.findById(exchangeId)
                .map(exchange -> modelMapper.map(exchange, SkillExchangeDto.class));
    }

    @Override
    public List<SkillExchangeDto> findByOffererUserId(String userId) {
        return skillExchangeRepository.findByOffererUserId(userId).stream()
                .map(exchange -> modelMapper.map(exchange, SkillExchangeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SkillExchangeDto> findByRequesterUserId(String userId) {
        return skillExchangeRepository.findByRequesterUserId(userId).stream()
                .map(exchange -> modelMapper.map(exchange, SkillExchangeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SkillExchangeDto> findByStatus(SkillExchangeDto.Status status) {
        return skillExchangeRepository.findByStatus(SkillExchange.ExchangeStatus.valueOf(status.name())).stream()
                .map(exchange -> modelMapper.map(exchange, SkillExchangeDto.class))
                .collect(Collectors.toList());
    }
}