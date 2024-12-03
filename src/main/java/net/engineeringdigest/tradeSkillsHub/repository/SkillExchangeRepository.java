package net.engineeringdigest.tradeSkillsHub.repository;

import net.engineeringdigest.tradeSkillsHub.model.SkillExchange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillExchangeRepository extends MongoRepository<SkillExchange, String> {
    List<SkillExchange> findByOffererUserId(String offererUserId);
    List<SkillExchange> findByRequesterUserId(String requesterUserId);
    List<SkillExchange> findByStatus(SkillExchange.ExchangeStatus status);
    List<SkillExchange> findByOffererUserIdOrRequesterUserId(String offererUserId, String requesterUserId);
}