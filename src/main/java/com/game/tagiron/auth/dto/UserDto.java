package com.game.tagiron.auth.dto;

import com.game.tagiron.auth.entity.UserEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserDto implements UserDetails {
    private Integer id;
    private String inviteKey; // 친구초대 키
    private String email;
    private String password;
    private String nickname;
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return Integer.toString(id);
    }
}
