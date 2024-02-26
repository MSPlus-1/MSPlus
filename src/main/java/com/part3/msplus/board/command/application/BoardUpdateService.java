package com.part3.msplus.board.command.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.command.domain.Category;
import com.part3.msplus.board.command.domain.repository.BoardRepository;
import com.part3.msplus.board.command.domain.repository.CategoryRepository;
import com.part3.msplus.board.controller.dto.request.BoardPatchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
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
public class BoardUpdateService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    public BoardResponse updateBoard(Long boardId, BoardPatchRequest boardPatchRequest) {

        Member member = this.memberRepository.findById(boardPatchRequest.getMemberId())
                .orElseThrow(() -> new CustomException(Error.MEMBER_NOT_FOUND));
        Board board = this.boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(Error.Board_NOT_FOUND));
        if(boardPatchRequest.getCategoryId() != null) {
            Category category = this.categoryRepository.findById(boardPatchRequest.getCategoryId())
                    .orElseThrow(() -> new CustomException(Error.CATEGORY_NOT_FOUND));
            board.updateCategory(member, category);
        }
        if(boardPatchRequest.getBoardName() != null) {
            board.updateBoardName(member, boardPatchRequest.getBoardName());
        }

        this.boardRepository.save(board);

        return new BoardResponse(board);
    }
}
