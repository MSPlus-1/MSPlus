package com.part3.msplus.board.command.domain.dao;

import com.part3.msplus.board.command.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
