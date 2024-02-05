package com.part3.msplus.member.domain;

import com.part3.msplus.board.command.domain.Board;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
