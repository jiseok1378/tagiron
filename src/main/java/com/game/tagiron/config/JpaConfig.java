package com.game.tagiron.config;

import com.game.tagiron.auth.dto.Role;
import com.game.tagiron.auth.entity.RoleEntity;
import com.game.tagiron.auth.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@RequiredArgsConstructor
public class JpaConfig {

    private final RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void init() {
        List<RoleEntity> roles = Arrays.stream(Role.values())
                .map(RoleEntity::new)
                .toList();

        for( RoleEntity role : roles) {

            if( roleRepository.findById(role.getRoleNm()).isEmpty() ){
                roleRepository.save(role);
            }

        }
    }
}
