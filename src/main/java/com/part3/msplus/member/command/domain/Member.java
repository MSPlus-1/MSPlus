package com.part3.msplus.member.command.domain;

import com.part3.msplus.member.command.domain.vo.Email;
import com.part3.msplus.member.command.domain.vo.MemberInfo;
import com.part3.msplus.member.command.domain.vo.MemberRole;
import com.part3.msplus.member.command.domain.vo.Password;
import com.part3.msplus.global.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성 전략 => identity
    private Long id;

    @Embedded
    private Password password;

    @Embedded
    private Email email;

    @Embedded
    private MemberInfo memberInfo;

    /**
     * eager loading, not null relationship
     */
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_role_id", referencedColumnName = "id")
    private MemberRole memberRole;

    @Builder
    private Member(Password password, Email email, MemberInfo memberInfo, MemberRole memberRole) {
        this.password = password;
        this.email = email;
        this.memberInfo = memberInfo;
        this.memberRole = memberRole;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email=" + email +
                ", memberInfo=" + memberInfo +
                ", memberRole=" + memberRole +
                '}';
    }
}