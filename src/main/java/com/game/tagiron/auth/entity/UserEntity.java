package com.game.tagiron.auth.entity;

import com.game.tagiron.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "USER_INFO", indexes = {
        @Index(name = "IDX_USER_EMAIL", columnList = "EMAIL"),
        @Index(name = "IDX_USER_NICKNAME", columnList = "NICKNAME")
})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "INVITE_KEY", nullable = false, unique = true)
    private String inviteKey; // 친구초대 키

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", length = 30)
    private String password;

    @Column(name = "NICKNAME", length = 10)
    private String nickname;

    @OneToMany(mappedBy = "id")
    private List<UserRoleEntity> roles;

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

}
