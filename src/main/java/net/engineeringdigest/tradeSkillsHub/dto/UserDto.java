package net.engineeringdigest.tradeSkillsHub.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import net.engineeringdigest.tradeSkillsHub.model.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String email;
    private String fullName;
    private String bio;
    private String profilePictureUrl;
    private Set<String> skills;
    private Set<String> interestedSkills;
    private Set<User.Role> roles;
    private LocalDateTime createdAt;
}
