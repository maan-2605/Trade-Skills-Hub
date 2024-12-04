package net.engineeringdigest.tradeSkillsHub.service;

import net.engineeringdigest.tradeSkillsHub.dto.SkillDto;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    SkillDto createSkill(SkillDto skillDto);
    Optional<SkillDto> findById(String skillId);
    List<SkillDto> findByCategory(String category);
    List<SkillDto> findByDifficulty(String difficulty);
    List<SkillDto> getAllSkills();
    SkillDto updateSkill(String skillId, SkillDto skillDto);
    void deleteSkill(String skillId);
    List<SkillDto> searchSkills(String query);
}