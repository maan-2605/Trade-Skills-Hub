package net.engineeringdigest.tradeSkillsHub.service;

import net.engineeringdigest.tradeSkillsHub.dto.CreditTransactionDto;
import net.engineeringdigest.tradeSkillsHub.model.CreditTransaction;
import net.engineeringdigest.tradeSkillsHub.model.User;
import net.engineeringdigest.tradeSkillsHub.repository.CreditTransactionRepository;
import net.engineeringdigest.tradeSkillsHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditTransactionServiceImpl implements CreditTransactionService {
    private final CreditTransactionRepository creditTransactionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public CreditTransactionDto createTransaction(String userId, double amount, CreditTransactionDto.TransactionType type) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CreditTransaction transaction = new CreditTransaction();
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setType(CreditTransaction.TransactionType.valueOf(type.name()));
        transaction.setTimestamp(LocalDateTime.now());

        // Update user balance
        switch (type) {
            case EARN:
                user.setCredits(user.getCredits() + amount);
                break;
            case SPEND:
                if (user.getCredits() < amount) {
                    throw new RuntimeException("Insufficient credits");
                }
                user.setCredits(user.getCredits() - amount);
                break;
        }

        userRepository.save(user);
        CreditTransaction savedTransaction = creditTransactionRepository.save(transaction);

        return modelMapper.map(savedTransaction, CreditTransactionDto.class);
    }

    @Override
    public List<CreditTransactionDto> getUserTransactions(String userId) {
        return creditTransactionRepository.findByUserId(userId).stream()
                .map(transaction -> modelMapper.map(transaction, CreditTransactionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public double getUserBalance(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getCredits();
    }
}