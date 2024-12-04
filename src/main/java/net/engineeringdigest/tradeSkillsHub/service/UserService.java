package net.engineeringdigest.tradeSkillsHub.service;

import net.engineeringdigest.tradeSkillsHub.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    Optional<UserDto> findByUsername(String username);
    Optional<UserDto> findByEmail(String email);
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
    List<UserDto> getAllUsers();
    void addSkillToUser(String userId, String skillId);
    void removeSkillFromUser(String userId, String skillId);
}