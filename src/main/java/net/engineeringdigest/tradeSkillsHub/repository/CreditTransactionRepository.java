package net.engineeringdigest.tradeSkillsHub.repository;

import net.engineeringdigest.tradeSkillsHub.model.CreditTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
    @Repository
    public interface CreditTransactionRepository extends MongoRepository<CreditTransaction, String> {
        List<CreditTransaction> findByUserId(String userId);
        List<CreditTransaction> findByUserIdAndTimestampBetween(
                String userId,
                LocalDateTime startDate,
                LocalDateTime endDate
        );
        List<CreditTransaction> findByType(CreditTransaction.TransactionType type);
    }

