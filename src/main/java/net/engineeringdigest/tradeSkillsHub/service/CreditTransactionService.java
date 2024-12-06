package net.engineeringdigest.tradeSkillsHub.service;

import net.engineeringdigest.tradeSkillsHub.dto.CreditTransactionDto;
import java.util.List;

public interface CreditTransactionService {
    CreditTransactionDto createTransaction(String userId, double amount, CreditTransactionDto.TransactionType type);
    List<CreditTransactionDto> getUserTransactions(String userId);
    double getUserBalance(String userId);
}