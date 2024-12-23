package net.engineeringdigest.tradeSkillsHub.repository;

import net.engineeringdigest.tradeSkillsHub.model.SkillExchange;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkillExchangeRepository extends MongoRepository<SkillExchange, String> {
    List<SkillExchange> findByOffererUserId(String offererUserId);
    List<SkillExchange> findByRequesterUserId(String requesterUserId);
    List<SkillExchange> findByStatus(SkillExchange.ExchangeStatus status);
}