package com.game.tagiron.auth.entity;

import com.game.tagiron.audit.AuditEntity;
import com.game.tagiron.auth.dto.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROLE")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
public class RoleEntity extends AuditEntity {

    @Id
    @Column(name = "ROLE_NAME", length = 20)
    private String roleNm;

    @Column(name = "ROLE_DESC")
    private String roleDesc;

    public RoleEntity(Role role) {
        this.roleNm = role.getRoleName();
        this.roleDesc = role.getRoleDesc();
    }

}
