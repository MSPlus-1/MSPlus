package com.part3.msplus.category.command.domain.repository;

import com.part3.msplus.category.command.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaCategoryRepository extends JpaRepository<Category, Long>, CategoryRepository{
}
