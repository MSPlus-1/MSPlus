package com.part3.msplus.board.command.domain;

import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.Error;
import com.part3.msplus.global.model.BaseTimeEntity;
import com.part3.msplus.member.command.domain.Member;
import com.part3.msplus.member.command.domain.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category; // TODO : category domain 의 엔티티를 가져와야 함.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "name", nullable = false)
    private String boardName;

    @Builder
    public Board(Long id, Category category, Member member, String boardName) {
        this.checkRole(member);
        this.id = id;
        this.category = category;
        this.member = member;
        this.boardName = boardName;
    }

    public void updateBoardName(Member member, String boardName) {
        this.checkRole(member);
        this.boardName = boardName;
    }

    public void updateCategory(Member member, Category category) {
        this.checkRole(member);
        this.category = category;
    }

    public void softDeleteBoard(Member member) {
        this.checkRole(member);
        this.softDelete();
    }

    private void checkRole(Member member) {
        // member 의 role 을 확인. admin일 경우만 board 생성 가능
        if(!member.getMemberRole().getRole().equals(Role.ROLE_ADMIN) ) {
            throw new CustomException(Error.BOARD_CREATE_PERMISSION_DENIED);
        }
    }
}
