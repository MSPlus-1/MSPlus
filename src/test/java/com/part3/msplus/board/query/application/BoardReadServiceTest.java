package com.part3.msplus.board.query.application;

import com.part3.msplus.board.query.dao.BoardDAO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class BoardReadServiceTest {

    @InjectMocks
    private BoardReadService boardReadService;

    @Mock
    private BoardDAO boardDAO;
}