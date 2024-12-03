package net.engineeringdigest.tradeSkillsHub.repository;

import net.engineeringdigest.tradeSkillsHub.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
    List<Skill> findByUserId(String userId);
    List<Skill> findByCategory(Skill.Category category);
    List<Skill> findByDifficulty(Skill.SkillLevel difficulty);
    List<Skill> findByNameContainingIgnoreCase(String name);
}