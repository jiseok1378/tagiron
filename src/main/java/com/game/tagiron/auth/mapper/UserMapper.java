package com.game.tagiron.auth.mapper;

import com.game.tagiron.auth.dto.UserDto;
import com.game.tagiron.auth.entity.RoleEntity;
import com.game.tagiron.auth.entity.UserEntity;
import com.game.tagiron.auth.entity.UserRoleEntity;
import com.game.tagiron.util.PasswordUtil;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class ); // 2

    @Mapping(source = "roles", target = "roles", qualifiedByName = "getRoles")
    UserDto toDto(UserEntity entity);


    @Named("getRoles")
    default List<String> getRoles(List<UserRoleEntity> roles){
        if(roles == null) return List.of();

        return roles.stream()
                .map(UserRoleEntity::getRole)
                .map(RoleEntity::getRoleNm)
                .toList();
    }
}
