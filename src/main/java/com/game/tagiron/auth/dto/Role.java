package com.game.tagiron.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("USER", "유저권한")
    , ADMIN("ADMIN", "관리자권한")
    ;

    private final String roleName;
    private final String roleDesc;
}
