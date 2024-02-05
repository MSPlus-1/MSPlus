package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.Category;
import com.part3.msplus.member.domain.Member;
import com.part3.msplus.board.command.domain.dao.BoardRepository;
import com.part3.msplus.board.command.domain.dao.CategoryRepository;
import com.part3.msplus.member.domain.dao.MemberRepository;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 게시판 생성
     * @param request
     * @return
     */
    public BoardResponse createBoard(BoardCreateRequest boardCreateRequest) {
        // TODO : exception handler 처리
        Member member = this.memberRepository.findById(boardCreateRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Category category = this.categoryRepository.findById(boardCreateRequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        Board board = boardCreateRequest.toEntity(category, member, ZonedDateTime.now(), ZonedDateTime.now(), null);

        // TODO : 검증 로직

        this.boardRepository.save(board);

        return new BoardResponse(board);
    }
}
