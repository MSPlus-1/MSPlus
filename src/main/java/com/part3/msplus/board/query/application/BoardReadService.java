package com.part3.msplus.board.query.application;

import com.part3.msplus.board.command.domain.Board;
import com.part3.msplus.board.controller.dto.request.RequestParam;
import com.part3.msplus.board.controller.dto.request.SearchRequest;
import com.part3.msplus.board.controller.dto.response.BoardResponse;
import com.part3.msplus.board.controller.dto.response.PageResponse;
import com.part3.msplus.board.query.dao.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReadService {

    private final BoardDAO boardDAO;

    public PageResponse<BoardResponse> getBoards(RequestParam requestParam) {
        SearchRequest searchRequest = requestParam.getSearchRequest();
        PageRequest pageRequest = requestParam.getPageRequest();
        List<BoardResponse> boards = this.boardDAO.findAll(searchRequest, pageRequest);
        Long totalSize = this.boardDAO.findAllCount();

        return new PageResponse<BoardResponse>(boards, boards.size(), totalSize.intValue());
    }
}
