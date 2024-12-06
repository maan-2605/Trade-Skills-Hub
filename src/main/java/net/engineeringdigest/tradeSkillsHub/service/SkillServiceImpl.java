package net.engineeringdigest.tradeSkillsHub.service;

import lombok.RequiredArgsConstructor;
import net.engineeringdigest.tradeSkillsHub.dto.SkillDto;
import net.engineeringdigest.tradeSkillsHub.model.Skill;
import net.engineeringdigest.tradeSkillsHub.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final ModelMapper modelMapper;

    @Override
    public SkillDto createSkill(SkillDto skillDto) {
        Skill skill = modelMapper.map(skillDto, Skill.class);
        Skill savedSkill = skillRepository.save(skill);
        return modelMapper.map(savedSkill, SkillDto.class);
    }

    @Override
    public Optional<SkillDto> findById(String skillId) {
        return skillRepository.findById(skillId)
                .map(skill -> modelMapper.map(skill, SkillDto.class));
    }

    @Override
    public List<SkillDto> findByCategory(String category) {
        return skillRepository.findByCategory(Skill.Category.valueOf(category)).stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SkillDto> findByDifficulty(String difficulty) {
        return skillRepository.findByDifficulty(Skill.SkillLevel.valueOf(difficulty)).stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SkillDto updateSkill(String skillId, SkillDto skillDto) {
        Skill existingSkill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        modelMapper.map(skillDto, existingSkill);
        Skill updatedSkill = skillRepository.save(existingSkill);
        return modelMapper.map(updatedSkill, SkillDto.class);
    }

    @Override
    public void deleteSkill(String skillId) {
        skillRepository.deleteById(skillId);
    }

    @Override
    public List<SkillDto> searchSkills(String query) {
        return skillRepository.findByNameContainingIgnoreCase(query).stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());
    }
}