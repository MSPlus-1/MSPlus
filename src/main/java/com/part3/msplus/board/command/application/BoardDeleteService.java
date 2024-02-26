package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.repository.BoardRepository;
import com.part3.msplus.board.controller.dto.request.BoardDeleteRequest;
import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.Error;
import com.part3.msplus.member.command.domain.Member;
import com.part3.msplus.member.query.dao.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardDeleteService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void softDeleteBoard(Long boardId, BoardDeleteRequest boardDeleteRequest) {

        Member member = this.memberRepository.findById(boardDeleteRequest.getMemberId())
                .orElseThrow(() -> new CustomException(Error.MEMBER_NOT_FOUND));
        Board board = this.boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(Error.Board_NOT_FOUND));

        board.softDeleteBoard(member);

        this.boardRepository.save(board);
    }
}
