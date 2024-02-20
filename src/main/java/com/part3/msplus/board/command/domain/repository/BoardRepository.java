package com.part3.msplus.board.command.domain.repository;

import com.part3.msplus.board.command.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
