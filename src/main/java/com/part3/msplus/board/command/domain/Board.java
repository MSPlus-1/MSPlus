package com.part3.msplus.board.command.domain;

import com.part3.msplus.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category; // TODO : category domain 의 엔티티를 가져와야 할 것 같음.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // TODO : member domain 의 엔티티를 가져와야 할 것 같음.

    @Column(name = "name", nullable = false)
    private String boardName;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;

    @Builder
    public Board(Long id, Category category, Member member, String boardName, ZonedDateTime createdAt, ZonedDateTime updatedAt, ZonedDateTime deletedAt) {
        this.id = id;
        this.category = category;
        this.member = member;
        this.boardName = boardName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
