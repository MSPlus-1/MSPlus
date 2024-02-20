package com.part3.msplus.board.query.dao;

import com.part3.msplus.board.command.domain.Board;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BoardDAO extends JpaRepository<Board, Long> {
}
