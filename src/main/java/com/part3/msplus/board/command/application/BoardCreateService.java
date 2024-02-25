package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.category.command.domain.entity.Category;
import com.part3.msplus.global.exception.CustomException;
import com.part3.msplus.global.exception.dto.Error;
import com.part3.msplus.member.command.domain.Member;
import com.part3.msplus.board.command.domain.repository.BoardRepository;
import com.part3.msplus.board.command.domain.repository.CategoryRepository;
import com.part3.msplus.member.query.dao.MemberRepository;
import com.part3.msplus.board.controller.dto.request.BoardCreateRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new CustomException(Error.MEMBER_NOT_FOUND));
        Category category = this.categoryRepository.findById(boardCreateRequest.getCategoryId())
                .orElseThrow(() -> new CustomException(Error.CATEGORY_NOT_FOUND));

        Board board = boardCreateRequest.toEntity(category, member);

        this.boardRepository.save(board);

        return new BoardResponse(board);
    }
}

